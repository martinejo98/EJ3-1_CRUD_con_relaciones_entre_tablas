package com.example.EJ31_CRUD_con_relaciones_entre_tablas.exception;

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
