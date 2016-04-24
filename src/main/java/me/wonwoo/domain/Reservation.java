
package me.wonwoo.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@ToString(exclude = {"customer", "screen"})
public class Reservation {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CUSTOMER_ID")
  private Customer customer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SCREEN_ID")
  private Screen screen;

  private BigDecimal price;

  public Reservation() {

  }

  public Reservation(Customer customer, Screen screen) {
    this.customer = customer;
    this.screen = screen;
    this.price = screen.fee();
  }
}
