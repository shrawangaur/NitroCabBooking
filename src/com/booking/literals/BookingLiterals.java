package com.booking.literals;

import com.booking.domain.BookingRequest;
import com.booking.domain.Cab;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by acer on 11/29/2014.
 */
public class BookingLiterals {

    public static List<Cab> populateAvailableCabs() {
        List<Cab> cabList = new ArrayList<Cab>();
        Cab cabOne = new Cab("DL01HB001", 100020,false);
        Cab cabTwo = new Cab("DL01HB002", 100040,false);
        Cab cabThree = new Cab("DL01HB003", 100060,false);
        Cab cabFour = new Cab("DL01HB004", 100080,false);
        cabList.add(cabOne);
        cabList.add(cabTwo);
        cabList.add(cabThree);
        cabList.add(cabFour);
        return cabList;
    }

    public static Set<BookingRequest> populateBookingRequest() {
        Set<BookingRequest> bookingRequestList = new TreeSet<BookingRequest>();
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            BookingRequest bookingRequestOne = new BookingRequest("BR001", 100025, 100036, sdf.parse("29-11-2014 18:00:00"));
            BookingRequest bookingRequestTwo = new BookingRequest("BR002", 100056, 100042, sdf.parse("29-11-2014 17:30:00"));
            BookingRequest bookingRequestFour = new BookingRequest("BR004", 100028, 100036, sdf.parse("29-11-2014 15:00:00"));
            BookingRequest bookingRequestThree = new BookingRequest("BR003", 100044, 100056, sdf.parse("29-11-2014 17:00:00"));
            bookingRequestList.add(bookingRequestOne);
            bookingRequestList.add(bookingRequestTwo);
            bookingRequestList.add(bookingRequestFour);
            bookingRequestList.add(bookingRequestThree);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       return bookingRequestList;
    }
}
