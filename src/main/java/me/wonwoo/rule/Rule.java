
package me.wonwoo.rule;


import me.wonwoo.domain.Screen;

public interface Rule {

    boolean isStatisfiedBy(Screen screen);
}
