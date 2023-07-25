package org.qiwi.hack.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValCursDTO {
    @JsonProperty(value = "Date")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;

    private Valute valute;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Valute {

        @JsonProperty(value = "NumCode")
        private Integer numCode;

    }
}
