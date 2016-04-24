
package me.wonwoo.domain;


import lombok.Data;
import lombok.ToString;
import me.wonwoo.rule.Rule;
import me.wonwoo.rule.SequenceRule;
import me.wonwoo.strategy.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
@Entity
@ToString(exclude = {"reservations", "movie"})
public class Screen {

  @Id
  @GeneratedValue
  private Long id;

  @Temporal(TemporalType.TIMESTAMP)
  private Date screenTime;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MOVIE_ID")
  private Movie movie;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "screen")
  private List<Reservation> reservations = new ArrayList<>();

  private Integer seq;

  //스크린 예약에 대한 위임
  public Reservation reservation(Customer customer) {
    return new Reservation(customer, this);
  }

  //얼마나 할인? 여기를 좀더 다듬여야 될듯
  public BigDecimal fee() {
    DisCount disCount = movie.getDisCount();
    DisCountType disCountType = disCount.getDisCountType();

    List<Rule> rules = new ArrayList<>();
    rules.add(new SequenceRule(disCount.getDisCountRules()
      .stream()
      .map(i -> i.getSeq())
      .collect(toList()))
    );
    if (disCountType == DisCountType.AMOUNT) {
      movie.setDisCountStrategy(new AmountDisCountStrategy(rules));
    } else if (disCountType == DisCountType.PERCENT) {
      movie.setDisCountStrategy(new PercentDiscountStrategy(rules));
    } else {
      movie.setDisCountStrategy(new NonDisCountStrategy(rules));
    }

    return movie.calculateFee(this);
  }

  /**
   * 가격 할인
   * @return
   */
  public BigDecimal dcAmount() {
    return movie.getDisCount().getPrice();
  }

  /**
   * 퍼센트 할인
   *
   * @return
   */
  public BigDecimal dcPercent() {
    BigDecimal percent = dcAmount().divide(new BigDecimal(100));
    return movie.getPrice().multiply(percent);
  }

  /**
   * 할인 해야 될 시퀀스 찾기
   * @param sequences
   * @return
   */
  public boolean isSequence(List<Integer> sequences) {
    for (Integer sequence : sequences) {
      if (sequence.equals(seq)) {
        return true;
      }
    }
    return false;
  }
}
