package me.wonwoo.domain;


import lombok.Data;
import lombok.ToString;

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

}

