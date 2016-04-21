package me.wonwoo.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

public class ScreenDto {

    @Data
    public static class Screen{

        private Long id;

        private Date screenTime;

        private BigDecimal disCount;

        private Movie movie;

    }

    @Data
    public static class Movie{
        private Long id;

        private String title;

        private Integer price;
    }
}
