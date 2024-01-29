package br.com.bootcamp.controllers;

import br.com.bootcamp.exceptions.TransactionNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Set;

@RestControllerAdvice
public class ExceptionController {

  @ExceptionHandler(TransactionNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String notFoundHandler(RuntimeException exception) {
    return exception.getMessage();
  }

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String ConstraintViolationExceptionHandler(ConstraintViolationException exception) {
    Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();

    if (!violations.isEmpty()) {
      ConstraintViolation<?> firstViolation = violations.iterator().next();

      return firstViolation.getMessageTemplate();
    }

    return "Validation failed.";
  }
}