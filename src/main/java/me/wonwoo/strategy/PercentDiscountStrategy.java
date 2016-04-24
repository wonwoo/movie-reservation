package me.wonwoo.strategy;

import me.wonwoo.domain.Movie;
import me.wonwoo.domain.Screen;
import me.wonwoo.rule.Rule;

import java.math.BigDecimal;
import java.util.List;

/**
 * 퍼센트 할인
 */
public class PercentDiscountStrategy extends DisCountStrategy{

    public PercentDiscountStrategy(List<Rule> rules) {
        super(rules);
    }

    @Override
    protected BigDecimal getDiscountFee(Screen screen) {
        return screen.dcPercent();
    }
}

