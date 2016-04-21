package me.wonwoo.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.function.Consumer;

@Data
@Entity
@ToString(exclude = {"disCount"})
public class DisCountRule {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DISCOUNT_ID")
    private DisCount disCount;

    private Integer seq;

    public DisCountRule setIfTrue(boolean ifTrue, Consumer<DisCountRule> consumer){
        if(ifTrue){
            consumer.accept(this);
        }
        return this;
    }
}
