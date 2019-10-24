package com.bmm.reservation.system.dao;

import com.bmm.reservation.system.model.movie.MovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieDao extends JpaRepository<MovieInfo,Integer> {
}
