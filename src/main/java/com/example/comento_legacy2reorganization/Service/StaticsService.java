package com.example.comento_legacy2reorganization.Service;

import com.example.comento_legacy2reorganization.Dto.Term;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface StaticsService {
    // 연도별 접속자 수
    public HashMap<String, Object> getYearLoginCnt(String year);

    //  월별 접속자 수
    public HashMap<String, Object> geMonthlyLoginCnt(Term term);

    //  일별 접속자 수
    public HashMap<String, Object> getDayLoginCnt(Term term);

    //  평균 하루 로그인 수
    public HashMap<String, Object> getAvgDailyLoginCnt(Term term);

    //  휴일을 제외한 로그인 수
    public HashMap<String, Object> getExcludeMonthlyLoginCnt(Term term);

    //  부서별 월별 접속자 수
    public HashMap<String, Object> getGroupByDepartLoginCnt(String month);
}
