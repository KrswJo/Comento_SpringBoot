package com.example.comento_legacy2reorganization.service;

import com.example.comento_legacy2reorganization.dao.MovieMapper;
import com.example.comento_legacy2reorganization.vo.MovieVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{
    private final MovieMapper movieMapper;

    @Override
    @Transactional
    public List<MovieVO> getMovieList() throws Exception {
        log.info("정상적으로 영화 리스트를 조회합니다.");
        return movieMapper.findAll();
    }
}
