package me.wonwoo.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CustomerDto {

    @Data
    public static class Customer {
        private Long id;
        private List<Reservation> reservations;
    }

    @Data
    public static class Reservation {
        private Long id;
        private Screen screen;
        private BigDecimal price;
    }

    @Data
    public static class Screen {
        private Movie movie;
        private Date screenTime;

    }

    @Data
    public static class Movie {
        private Long id;
        private String title;
    }
}
