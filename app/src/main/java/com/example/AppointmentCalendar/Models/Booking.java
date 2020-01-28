package com.example.AppointmentCalendar.Models;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;

public class Booking
{


//    public HashMap<LocalDate, ArrayList<Bookings>> localDateHashMap = new HashMap<>();
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

//    @Override
//    public String toString()
//    {
//        return "ClassPojo [date = "+date+", bookings = "+bookings+"]";
//    }
}
		