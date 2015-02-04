package com.dell.boomi.dto;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by piyush_g on 2/3/2015.
 */
public class FormatterUtil {

    public static void main(String[] args) {
        String dateString = "01/31/2007T23:59:59Z";
        String amount = "00000.50000";
        parseAmountFormat(amount);
    }

    private static BigDecimal parseAmountFormat(String amount) {
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        BigDecimal amt = new BigDecimal(amount);
        System.out.println(df.format(amt));
        return amt;


    }

    private static String parseDateFormat(String str) {
        DateFormat parser = new SimpleDateFormat("MM/dd/yyyy'T'HH:mm:ss'Z'");
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm aaa");
        String formatedDate = null;
        try {
            Date convertedDate = parser.parse(str);
            formatedDate = formatter.format(convertedDate);
            System.out.println(formatedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return formatedDate;
    }


}



