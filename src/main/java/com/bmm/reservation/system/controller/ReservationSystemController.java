package com.bmm.reservation.system.controller;

import com.bmm.reservation.system.domain.Movie;
/*import org.springframework.transaction.annotation.Transactional;*/
import com.bmm.reservation.system.model.movie.MovieInfo;
import com.bmm.reservation.system.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class ReservationSystemController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/movies/{movieId}")
    public MovieInfo getMovie(@PathVariable("movieId") Integer movieId){
        System.out.println("Movie Id is " + movieId);
        MovieInfo movieInfo = reservationService.getMovie(movieId);
        return movieInfo;
    }


    @GetMapping
    public List<String> getMovies(){
        return Arrays.asList("Movie-Name");
    }

    @PostMapping
    public void addMovie(@RequestBody MovieInfo movie){
        System.out.println("Movie Name is " + movie.getName());
        reservationService.saveMovie(movie);
    }
}
