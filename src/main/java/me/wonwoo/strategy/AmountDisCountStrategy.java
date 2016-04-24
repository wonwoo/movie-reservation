package me.wonwoo.strategy;

import me.wonwoo.domain.Screen;
import me.wonwoo.rule.Rule;

import java.math.BigDecimal;
import java.util.List;

/**
 * 가격할인
 */
public class AmountDisCountStrategy extends DisCountStrategy {

  public AmountDisCountStrategy(List<Rule> rules) {
    super(rules);
  }

  @Override
  protected BigDecimal getDiscountFee(Screen screen) {
    return screen.dcAmount();
  }
}
