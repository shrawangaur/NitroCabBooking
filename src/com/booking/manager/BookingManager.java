package com.booking.manager;

import com.booking.domain.BookingRequest;
import com.booking.domain.Cab;
import com.booking.literals.BookingLiterals;
import com.booking.price.PriceService;

import java.util.*;

/**
 * Created by acer on 11/29/2014.
 */
public class BookingManager {

    static List<Cab> cabList = BookingLiterals.populateAvailableCabs();


    public Map<String, String> assignCab(Set<BookingRequest> bookingRequestList) {
        Map<String, String> bookingToCabMap = new HashMap<String, String>();
        for (BookingRequest bookingRequest : bookingRequestList) {

            //Find Nearest Empty Cabs
            Cab cab = findCabFor(bookingRequest);

            if (cab == null) {
                // cannot find cab
                bookingToCabMap.put(bookingRequest.getBookingId(), "No Cab Assigned");
                continue;
            }

            // check time required to reach there
            int distanceToReachPickUp = Math.abs(cab.getCabLocation() - bookingRequest.getPickUpArea()) * 2;// each area code diff is 2 km
            int timeRequiredToReachPickUpLocation = distanceToReachPickUp * 2; //each km requires 2 min

            Date currentTime = new Date();
            //diff between currenttime and pickup time
            long diffTimeInMillis = bookingRequest.getPickUpTime().getTime() - currentTime.getTime();
            int diffTimeinMins = (int) (diffTimeInMillis / (60 * 1000));

            if (diffTimeinMins < (timeRequiredToReachPickUpLocation + 15)) {
                // nearest cab cannot reach pick up location at appropriate time. do not assign cab
                bookingToCabMap.put(bookingRequest.getBookingId(), "Cab Cannot Reach on Time");
                continue;
            }


            int commuteDistance = Math.abs(bookingRequest.getDropArea() - bookingRequest.getPickUpArea()) * 2;

            PriceService priceService = new PriceService();

            if (priceService.isProfitableFor(distanceToReachPickUp, commuteDistance)) {
                cab.setOccupied(true);
                bookingToCabMap.put(bookingRequest.getBookingId(), cab.getCabNumber());
            } else {
                bookingToCabMap.put(bookingRequest.getBookingId(), null);
            }
        }

        return bookingToCabMap;
    }

    private static Cab findCabFor(BookingRequest bookingRequest) {
        int pickUpAreaCode = bookingRequest.getPickUpArea();
        int cabLocation = 0;
        int distanceBetweenCabAndPickUp = 0;
        Cab minDistCab = null;
        int minDist = Integer.MAX_VALUE;

        for (Cab cab : cabList) {
            if (cab.isOccupied()) {
                continue;
            }

            cabLocation = cab.getCabLocation();
            distanceBetweenCabAndPickUp = Math.abs(pickUpAreaCode - cabLocation);

            if (minDist > distanceBetweenCabAndPickUp) {
                minDistCab = cab;
                minDist = distanceBetweenCabAndPickUp;
            }
        }
        return minDistCab;
    }
}
