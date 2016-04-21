package me.wonwoo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ReservationException extends RuntimeException {

    private String message;

    public ReservationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
