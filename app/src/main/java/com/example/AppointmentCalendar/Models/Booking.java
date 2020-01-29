package com.example.AppointmentCalendar.Models;

import java.util.ArrayList;

public class Booking
{
    private long date;

    ArrayList < Bookings>   bookings;

    public long getDate ()
    {
        return date;
    }

    public void setDate (long date)
    {
        this.date = date;
    }

    public ArrayList<Bookings> getBookings ()
    {
        return bookings;
    }

    public void setBookings (ArrayList<Bookings> bookings)
    {
        this.bookings = bookings;
    }

}
		