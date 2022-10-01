package com.example.comento_legacy2reorganization.dao;

import com.example.comento_legacy2reorganization.vo.MovieVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface MovieMapper {
    public List<MovieVO> findAll() throws Exception;
}
