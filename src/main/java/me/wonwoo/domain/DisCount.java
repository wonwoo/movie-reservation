package me.wonwoo.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@ToString(exclude = {"movie", "disCountRules"})
public class DisCount {

    @Id
    @GeneratedValue
    private Long id;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "disCount")
    private List<DisCountRule> disCountRules = new ArrayList<>();

    //enum 빼야댐
    @Enumerated(EnumType.STRING)
    private DisCountType disCountType;

    private BigDecimal price;

}
