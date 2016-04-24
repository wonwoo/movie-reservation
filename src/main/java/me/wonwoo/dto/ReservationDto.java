package me.wonwoo.dto;

import lombok.Data;

import java.math.BigDecimal;

public class ReservationDto {

  @Data
  public static class ReservationRequest {

    private Long customerId;
    private Long screenId;
  }

  @Data
  public static class ReservationResponse {

    private Long customerId;
    private Long screenId;
    private BigDecimal price;
  }
}
