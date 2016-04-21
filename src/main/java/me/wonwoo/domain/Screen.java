
package me.wonwoo.domain;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

@Data
@Entity
@ToString(exclude = {"reservations", "movie"})
public class Screen  {

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

    @Transient
    private BigDecimal disCount;

    private Integer seq;

}
