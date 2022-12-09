package com.example.comento_legacy2reorganization.Dao;

import com.example.comento_legacy2reorganization.Dto.Term;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface StaticsMapper {
    public List<Object> selectYearLoginList(@Param("year") String year);

    // 연도별 접속자 수
    public HashMap<String, Object> selectYearLoginCnt(@Param("year") String year);

    //  월별 접속자 수
    public HashMap<String, Object> selectMonthlyLoginCnt(Term term);

    //  일별 접속자 수
    public HashMap<String, Object> selectDayLoginCnt(Term term);

    //  평균 하루 로그인 수
    public HashMap<String, Object> selectLoginAvgDailyCnt(Term term);

    //  휴일을 제외한 로그인 수
    public HashMap<String, Object> selectExcludeYearLoginCnt(Term term);

    //  부서별 월별 접속자 수
    public HashMap<String, Object> selectGroupByDepartLoginCnt(String month);
}
