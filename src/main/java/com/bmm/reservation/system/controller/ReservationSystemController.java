package com.bmm.reservation.system.controller;

import com.bmm.reservation.system.domain.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class ReservationSystemController {


    @GetMapping
    public List<Movie> getMovieList(){
        return Arrays.asList( new Movie("1", "Kaun Banega"));
    }
}
