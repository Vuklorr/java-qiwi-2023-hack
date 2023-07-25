package org.qiwi.hack.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class RequestData {
    private String currencyCode;

    private Date date;
}
