package br.com.kamatech.healthproviders.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralControllerAdvice {

  @ExceptionHandler
  public ResponseEntity<String> handleNotFound(MedicNotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Médico não encontrado");
  }

}
