package com.bmm.reservation.system.service;

import com.bmm.reservation.system.dao.MovieDao;
import com.bmm.reservation.system.model.movie.MovieInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ReservationService {

    @Autowired
    private MovieDao movieDao;

    @Transactional("catalogTransactionManager")
    public void saveMovie(MovieInfo movie){
        movieDao.save(movie);
    }

    @Transactional("catalogTransactionManager")
    public MovieInfo getMovie(int movieId){
        Optional<MovieInfo> movie = movieDao.findById(movieId);
        if(movie.isPresent()){
            return movie.get();
        }
        return null;
    }



}
