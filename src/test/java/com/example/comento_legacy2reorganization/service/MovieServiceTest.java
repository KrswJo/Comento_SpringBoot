package com.example.comento_legacy2reorganization.service;

import com.example.comento_legacy2reorganization.dao.MovieMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieServiceTest {
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieMapper movieMapper;

    @Test
    public void findService() throws Exception {
        int size = movieService.getMovieList().size();
        assertEquals(size, 3);
    }
}