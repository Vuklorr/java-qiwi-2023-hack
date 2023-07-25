package org.qiwi.hack.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseRequest {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static String getCurrencyCode(String input) {
        String[] parts = input.split("=");
        return parts.length == 2 && parts[0].equalsIgnoreCase("--code") ? parts[1] : null;
    }

    public static Date getDate(String input) {
        String[] parts = input.split("=");
        if(parts.length == 2 && parts[0].equalsIgnoreCase("--date")) {
            try {
                return DATE_FORMAT.parse(parts[1]);

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
