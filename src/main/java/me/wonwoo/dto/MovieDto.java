package me.wonwoo.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieDto {

    @Data
    public static class Movie {
        private Long id;

        private String title;

        private Integer price;

        private List<Screen> screens = new ArrayList<>();

    }

    @Data
    public static class Screen {

        private Long id;

        private Date screenTime;

    }

}
