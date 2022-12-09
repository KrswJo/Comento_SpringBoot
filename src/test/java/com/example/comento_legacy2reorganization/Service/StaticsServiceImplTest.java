package com.example.comento_legacy2reorganization.Service;

import com.example.comento_legacy2reorganization.Dto.Term;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class StaticsServiceImplTest {
    @Autowired
    private StaticsService staticsService;

    @Test
    @DisplayName("해당 연도 로그인 횟수 성공")
    void getYearLoginCnt_success() {
        String param = "20";
        HashMap<String, Object> actual = staticsService.getYearLoginCnt(param);

        HashMap<String, Object> expected = new HashMap<>();
        expected.put("totCnt", 3L);
        expected.put("year", param);
        expected.put("is_success", true);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("해당 연도 로그인 횟수 실패")
    void getYearLoginCnt_fail() {
        String param = "abce";
        HashMap<String, Object> actual;
        HashMap<String, Object> expected;

        actual = staticsService.getYearLoginCnt(param);
        expected = new HashMap<>();
        expected.put("totCnt", -999);
        expected.put("year", param);
        expected.put("is_success", false);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void geMonthlyLoginCnt() {
    }

    @Test
    void getDayLoginCnt() {
    }

    @Test
    void getAvgDailyLoginCnt() {
    }

    @Test
    void getExcludeMonthlyLoginCnt() {
    }

    @Test
    void getGroupByDepartLoginCnt() {
    }
}