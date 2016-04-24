package me.wonwoo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdNotFoundException extends RuntimeException {
  private Long id;

  public IdNotFoundException(Long id) {
    this.id = id;
  }

  @Override
  public String getMessage() {
    return id + " not found";
  }
}
