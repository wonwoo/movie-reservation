
package me.wonwoo.rule;


import me.wonwoo.domain.Screen;

import java.util.List;

public class SequenceRule implements Rule {

    private final List<Integer> sequences;

    public SequenceRule(List<Integer> sequences) {
        this.sequences = sequences;
    }

    @Override
    public boolean isStatisfiedBy(Screen screen) {
        return screen.isSequence(sequences);
    }
}
