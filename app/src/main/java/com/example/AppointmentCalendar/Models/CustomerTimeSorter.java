package com.example.AppointmentCalendar.Models;

import com.example.AppointmentCalendar.Models.Booking;
import com.example.AppointmentCalendar.Models.Bookings;

import java.util.Comparator;

public class CustomerTimeSorter implements Comparator<Bookings> {

    @Override
    public int compare(Bookings booking1, Bookings booking2) {
        return booking1.getBookingStartTime().compareTo(booking2.getBookingStartTime());

    }
}
