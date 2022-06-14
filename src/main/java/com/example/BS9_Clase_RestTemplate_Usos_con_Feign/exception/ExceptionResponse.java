package com.example.BS9_Clase_RestTemplate_Usos_con_Feign.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ExceptionResponse {

    private Date timestamp;
    private int HttpCode;
    private String mensaje;
}
