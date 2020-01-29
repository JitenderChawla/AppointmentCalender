package com.example.AppointmentCalendar.Models;


import android.os.Environment;
import android.util.Log;

import com.example.AppointmentCalendar.View.Activity.MainActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.joda.time.LocalDate;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ObjectManager {

//    public static void SerializeObject(HashMap<LocalDate, ArrayList<Bookings>> _mybooking) {
//
//        String folder_main = "AppointmentCalender";
//        String fileName = "Booking.json";
//
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String strJson = gson.toJson(_mybooking);
//        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + folder_main, fileName);
//        try {
//            FileOutputStream stream = new FileOutputStream(file);
//            BufferedOutputStream out = new BufferedOutputStream(stream);
//            try {
//                stream.write(strJson.getBytes());
//                out.flush();
//
//            } catch (Exception ex) {
//            } finally {
//                out.close();
//                stream.close();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void SerializeObject(ArrayList<Booking> _mybooking) {

        String folder_main = "AppointmentCalender";
        String fileName = "Booking.json";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String strJson = gson.toJson(_mybooking);
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + folder_main, fileName);
        try {
            FileOutputStream stream = new FileOutputStream(file);
            BufferedOutputStream out = new BufferedOutputStream(stream);
            try {
                stream.write(strJson.getBytes());
                out.flush();

            } catch (Exception ex) {
            } finally {
                out.close();
                stream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getObjectString(Booking _mybooking) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String strJson = gson.toJson(_mybooking);
            return strJson;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void deSerializeObject() {
        try {
            String folder_main = Common.appfolder_main;
            String fileName = "Booking.json";
            File file = new File(Common.ExternalSDPath + File.separator + folder_main + File.separator + fileName);

            if (file.exists()) {
                FileInputStream is = new FileInputStream(file);
                BufferedReader r = new BufferedReader(new InputStreamReader(is));
                StringBuilder total = new StringBuilder();
                String line;
                while ((line = r.readLine()) != null) {
                    total.append(line).append('\n');
                }
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();

                MainActivity.localDateHashMap = gson.fromJson(total.toString(), new TypeToken<HashMap<LocalDate, ArrayList<Bookings>>>() {
                }.getType());
                if (Common._bookingdetails == null) {
                    Common._bookingdetails = new Booking();
                }
            } else {
                Common._bookingdetails = new Booking();
            }
        } catch (Exception ex) {
            String a = ex.toString();

        }
    }
        public static String readBookingsJsonFile() {
            String ret = "";
            FileInputStream inputStream = null;
            try {

                File file1 = new File(Common.ExternalSDPath +
                        File.separator+Common.appfolder_main+File.separator+ "Booking.json");

                if (file1.exists()) {
                    inputStream = new FileInputStream(file1);
                    BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder total = new StringBuilder();
                    String line;
                    while ((line = r.readLine()) != null) {
                        total.append(line);
                    }
                    ret = total.toString();
                }

            }
            catch (FileNotFoundException e) {
                Log.wtf("readBookingsJsonFile", "File not found: " + e.toString());
            } catch (IOException e) {
                Log.wtf("readBookingsJsonFile", "Can not read file: " + e.toString());
            }
            finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return ret;
        }
    }
