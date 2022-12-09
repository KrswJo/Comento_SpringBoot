package com.example.comento_legacy2reorganization.Controller;

import com.example.comento_legacy2reorganization.Dto.Term;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public interface LoginStaticsController {
    // 연도별 접속자 수
    public HashMap<String, Object> getYearLoginCnt(String year);

    //  월별 접속자 수
    public HashMap<String, Object> getMonthlyLoginCnt(Term term);

    //  일별 접속자 수
    public HashMap<String, Object> getDayLoginCnt(Term term);

    //  평균 하루 로그인 수
    public HashMap<String, Object> getAvgDailyLoginCnt(Term term);

    //  휴일을 제외한 로그인 수
    public HashMap<String, Object> getExcludeOffDayMonthlyLoginCnt(Term term);

    //  부서별 월별 접속자 수
    public HashMap<String, Object> getGroupByDepartLoginCnt(String month);

}
