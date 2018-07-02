package com.binaryworks.java;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class JavaTime {

    public static void main(String args[]){
        /*LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime nextDay = localDateTime.withHour(0).withMinute(0).withSecond(0).plusDays(1);
        System.out.println(nextDay);*/

        String dateStart = "01/14/2012 09:29:28";
        String dateStop = "01/14/2012 09:29:48";

        //HH converts hour in 24 hours format (0-23), day calculation
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);

            //in milliseconds
            long diff = d2.getTime() - d1.getTime();

            double diffSeconds = diff / 1000 % 60;
            double diffMinutes = diff / (60 * 1000) % 60;
            double diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            System.out.print(diffDays + " days, ");
            System.out.print(diffHours + " hours, ");
            System.out.print(diffMinutes + " minutes, ");
            System.out.println(diffSeconds + " seconds.");

            double minsec = (diffDays * 24) + (diffHours * 60) + diffMinutes + (diffSeconds / 100) ;
            System.out.print(minsec + " minutes.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
