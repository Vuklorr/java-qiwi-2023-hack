package org.qiwi.hack;

import generated.ValCurs;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.qiwi.hack.utils.ParseRequest;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;


public class CurrencyRates {

    private static final String API_URL = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=%s";
    public static void main(String[] args) throws IOException, JAXBException {

        //currency_rates --code=USD --date=2022-10-08
        if(args.length != 2) {
            System.out.println("Используйте формат ввода: currency_rates --code=USD --date=2022-10-08");
            return;
        }

        String code = ParseRequest.getCurrencyCode(args[0]);
        LocalDate date = ParseRequest.getDate(args[1]);

        if(code == null && date == null) {
            System.out.println("Неверные параметры");
            return;
        }

        String response = generateAnsSendRequest(date);

        ValCurs valCurs = unmarshal(response);

        ValCurs.Valute valute = valCurs.getValute().stream()
                .filter(item -> code.equals(item.getCharCode()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
        System.out.println("Charcode " + valute.getCharCode());
        System.out.println("value " + valute.getValue());
    }

    private static String generateAnsSendRequest(LocalDate date) throws IOException {

        String targetUrl = String.format(API_URL, date);
        URL url = new URL(targetUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        //Get Response
        InputStream is = con.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();

        return response.toString();
    }

    private static ValCurs unmarshal(String input) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ValCurs.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (ValCurs) unmarshaller.unmarshal(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
    }
}