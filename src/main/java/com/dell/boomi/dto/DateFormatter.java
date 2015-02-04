package com.dell.boomi.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by piyush_g on 2/3/2015.
 */
public class DateFormatter {

    public static void main(String[] args) {

        String dateString = "01/31/2007T23:59:59Z";
        DateFormat parser = new SimpleDateFormat("MM/dd/yyyy'T'HH:mm:ss'Z'");
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm aaa");
        try {
            Date convertedDate = parser.parse(dateString);
            String formattedDate = formatter.format(convertedDate);
            System.out.println(formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}



