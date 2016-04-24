package me.wonwoo.domain;


import lombok.Data;
import lombok.ToString;
import me.wonwoo.strategy.DisCountStrategy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Data
@Entity
@ToString(exclude = {"screens", "disCount"})
public class Movie {

  @Id
  @GeneratedValue
  private Long id;

  private String title;

  private BigDecimal price;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
  private List<Screen> screens = new ArrayList<>();

  @OneToOne(fetch = FetchType.EAGER)
  @PrimaryKeyJoinColumn
  private DisCount disCount;

  //흠
  private String runningTime;

  @Transient
  private DisCountStrategy disCountStrategy;

  void setDisCountStrategy(DisCountStrategy disCountStrategy) {
    this.disCountStrategy = disCountStrategy;
  }

  /**
   * 원 가격에서 할인 할 가격 빼기 (실제 할인된 가격)
   * @param screen
   * @return
   */
  public BigDecimal calculateFee(Screen screen) {
    return price.subtract(disCountStrategy.calculateDisCountFee(screen));
  }
}

