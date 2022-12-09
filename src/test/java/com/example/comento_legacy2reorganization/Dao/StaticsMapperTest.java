package com.example.comento_legacy2reorganization.Dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
@SpringBootTest
class StaticsMapperTest {
    @Autowired
    private StaticsMapper staticsMapper;

    @Test
    @DisplayName("로그인 횟수 성공 여부")
    void selectYearLoginCnt() {
        String param = "20";
        HashMap<String, Object> result = staticsMapper.selectYearLoginCnt(param);
        assertThat(result).isNotNull();
        Object actual = result.get("totCnt");
        assertThat(actual).isEqualTo(3L);
        System.out.println(actual);
    }

    @Test
    @DisplayName("로그인 횟수 리스트 출력")
    void selectYearLoginList() {
        String param = "20";
        List<Object> result = staticsMapper.selectYearLoginList(param);
        for (Object value : result){
            System.out.println(value);
        };
    }
}