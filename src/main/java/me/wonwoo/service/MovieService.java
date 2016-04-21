package me.wonwoo.service;

import me.wonwoo.domain.Movie;
import me.wonwoo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie findOne(Long id) {
        return movieRepository.findOne(id);
    }
}
