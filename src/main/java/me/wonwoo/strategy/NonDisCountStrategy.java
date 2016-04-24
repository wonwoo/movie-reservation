package me.wonwoo.strategy;

import me.wonwoo.domain.Screen;
import me.wonwoo.rule.Rule;

import java.math.BigDecimal;
import java.util.List;

/**
 * 할인 하지 않음
 */
public class NonDisCountStrategy extends DisCountStrategy {
  public NonDisCountStrategy(List<Rule> rules) {
    super(rules);
  }

  @Override
  protected BigDecimal getDiscountFee(Screen screen) {
    return BigDecimal.ZERO;
  }
}
