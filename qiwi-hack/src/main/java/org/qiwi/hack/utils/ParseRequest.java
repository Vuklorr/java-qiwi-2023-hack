package org.qiwi.hack.utils;

import org.qiwi.hack.entity.RequestData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseRequest {
    public static RequestData parseRequest(String request) {
        String code = getCurrencyCode(request);
        Date date = getDate(request);
        return new RequestData(code, date);
    }

    private static String getCurrencyCode(String input) {
        Pattern pattern = Pattern.compile("--code=([A-Z]{3})");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }

    public static Date getDate(String inputString) {
        Pattern pattern = Pattern.compile("--date=(\\d{4}-\\d{2}-\\d{2})");
        Matcher matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            String dateString = matcher.group(1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return sdf.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
