package com.booking.price;

/**
 * Created by acer on 11/29/2014.
 */
public class PriceService {


    public boolean isProfitableFor(int distanceToReachPickUp,int commuteDistance) {

        int costIncurredByCompany = (distanceToReachPickUp + commuteDistance) * 5; //5 rs for each km
        int costPaidByCustomer = commuteDistance * 10; // 10 rs chargable.

        double profit = ((costPaidByCustomer - costIncurredByCompany) * 100 ) / costIncurredByCompany;

        if (profit > 20) {
            return true;
        }
        return false;

    }
}
