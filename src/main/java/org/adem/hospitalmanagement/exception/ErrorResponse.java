package org.adem.hospitalmanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {

    private Map<String,String> message;
    private String path;
    private LocalDate timestamp;
    private int statusCode;
}
