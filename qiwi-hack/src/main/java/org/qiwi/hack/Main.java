package org.qiwi.hack;

import org.qiwi.hack.entity.RequestData;
import org.qiwi.hack.utils.ParseRequest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите запрос: "); //currency_rates --code=USD --date=2022-10-08
        String request = in.nextLine();

        RequestData data = ParseRequest.parseRequest(request);
        System.out.println(data.toString());

        in.close();
    }
}