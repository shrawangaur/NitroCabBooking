package com.booking.domain;

import java.util.Date;

/**
 * Created by acer on 11/29/2014.
 */
public class BookingRequest implements Comparable {

    private String bookingId;
    private int pickUpArea;
    private int dropArea;
    private Date pickUpTime;

    public BookingRequest(String bookingId, int pickUpArea, int dropArea, Date pickUpTime) {
        this.bookingId = bookingId;
        this.pickUpArea = pickUpArea;
        this.dropArea = dropArea;
        this.pickUpTime = pickUpTime;
    }

    public String getBookingId() {
        return bookingId;
    }

    public int getPickUpArea() {
        return pickUpArea;
    }

    public int getDropArea() {
        return dropArea;
    }

    public Date getPickUpTime() {
        return pickUpTime;
    }


    @Override
    public int compareTo(Object _br) {
        BookingRequest br = (BookingRequest)_br;
        return this.getPickUpTime().compareTo(br.getPickUpTime());
    }
}
