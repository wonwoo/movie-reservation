
package me.wonwoo.web;


import me.wonwoo.domain.Movie;
import me.wonwoo.domain.Screen;
import me.wonwoo.dto.MovieDto;
import me.wonwoo.repository.MovieRepository;
import me.wonwoo.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/movie")
public class MovieController {

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private MovieService movieService;

  @Autowired
  private ModelMapper modelMapper;


  @GetMapping("/all")
  public List<MovieDto.Movie> getMovies() {
    List<Movie> movies = movieRepository.findAll();
    return movies.stream()
      .map(i -> modelMapper.map(i, MovieDto.Movie.class))
      .collect(toList());
  }

  @GetMapping
  public List<MovieDto.Movie> getReservationMovices() {
    List<Movie> movies = movieRepository.findAll();


//        for (Movie mo :movies) {
//            List<Screen> collect = mo.getScreens().stream().filter(i -> {
//                Instant instant = Instant.ofEpochMilli(i.getScreenTime().getTime());
//                LocalDateTime screenLocalTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//                LocalDateTime now = LocalDateTime.now().plusMinutes(30);
//                return screenLocalTime.isAfter(now);
//            }).collect(Collectors.toList());
//            mo.setScreens(collect);
//        }
    //흠!
    movies.stream().forEach(i -> {
      List<Screen> screens = i.getScreens().stream().filter(j -> {
        Instant instant = Instant.ofEpochMilli(j.getScreenTime().getTime());
        LocalDateTime screenLocalTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        LocalDateTime now = LocalDateTime.now().plusMinutes(30);
        return screenLocalTime.isAfter(now);
      }).collect(toList());
      i.setScreens(screens);
    });
    return movies.stream()
      .map(i -> modelMapper.map(i, MovieDto.Movie.class))
      .collect(toList());
  }

  @GetMapping("/{id}")
  public MovieDto.Movie getMovie(@PathVariable Long id) {
    Movie movie = movieService.findOne(id);
    return modelMapper.map(movie, MovieDto.Movie.class);
  }
}
