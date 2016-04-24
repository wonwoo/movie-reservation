package me.wonwoo.strategy;

import me.wonwoo.domain.Screen;
import me.wonwoo.rule.Rule;

import java.math.BigDecimal;
import java.util.List;

/**
 * 할인에 대한 추상 클래스
 */
public abstract class DisCountStrategy {

  private final List<Rule> rules;

  protected DisCountStrategy(List<Rule> rules) {
    this.rules = rules;
  }

  public BigDecimal calculateDisCountFee(Screen screen) {
    for (Rule rule : rules) {
      if (rule.isStatisfiedBy(screen)) {
        return getDiscountFee(screen);
      }
    }
    return BigDecimal.ZERO;
  }

  protected abstract BigDecimal getDiscountFee(Screen screen);
}
