package org.qiwi.hack;

import org.qiwi.hack.entity.RequestData;
import org.qiwi.hack.utils.ParseRequest;

import java.util.Date;


public class CurrencyRates {
    public static void main(String[] args) {
        //currency_rates --code=USD --date=2022-10-08
        if(args.length != 2) {
            System.out.println("Используйте формат ввода: currency_rates --code=USD --date=2022-10-08");
            return;
        }

        String code = ParseRequest.getCurrencyCode(args[0]);
        Date date = ParseRequest.getDate(args[1]);

        RequestData data = new RequestData(code, date);

        System.out.println(data);

    }
}