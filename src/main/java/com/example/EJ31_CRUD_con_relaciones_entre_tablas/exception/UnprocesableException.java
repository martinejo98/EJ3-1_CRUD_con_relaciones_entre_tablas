package com.example.EJ31_CRUD_con_relaciones_entre_tablas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocesableException extends RuntimeException{

  public UnprocesableException(String message) {
    super(message);
  }
}
