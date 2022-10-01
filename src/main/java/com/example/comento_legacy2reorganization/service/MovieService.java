package com.example.comento_legacy2reorganization.service;

import com.example.comento_legacy2reorganization.vo.MovieVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MovieService {
    @Transactional
    public List<MovieVO> getMovieList() throws Exception;
}
