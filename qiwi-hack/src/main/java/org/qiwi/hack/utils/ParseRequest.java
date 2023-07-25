package org.qiwi.hack.utils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ParseRequest {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String getCurrencyCode(String input) {

        String[] parts = input.split("=");
        return parts.length == 2 && parts[0].equalsIgnoreCase("--code") ? parts[1] : null;
    }

    public static LocalDate getDate(String input) {

        String[] parts = input.split("=");
        return parts.length == 2 && parts[0].equalsIgnoreCase("--date")
                ? LocalDate.parse(parts[1], DATE_FORMATTER)
                : null;
    }
}
