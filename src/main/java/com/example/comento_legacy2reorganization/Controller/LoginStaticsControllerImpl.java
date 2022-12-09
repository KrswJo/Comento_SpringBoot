package com.example.comento_legacy2reorganization.Controller;

import com.example.comento_legacy2reorganization.Dao.StaticsMapper;
import com.example.comento_legacy2reorganization.Dto.Term;
import com.example.comento_legacy2reorganization.Service.StaticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoginStaticsControllerImpl implements LoginStaticsController{
    private final StaticsService staticsService;
    private final StaticsMapper staticsMapper;

    @Override
    @GetMapping("/year/login-cnt")
    public HashMap<String, Object> getYearLoginCnt(@RequestParam("year") String year) {
        return staticsService.getYearLoginCnt(year);
    }

    @GetMapping("/year/login-list")
    public List<Object> getYearLoginList(@RequestParam("year") String year) {
        return staticsMapper.selectYearLoginList(year);
    }

    @Override
    @GetMapping("/month/login-cnt")
    public HashMap<String, Object> getMonthlyLoginCnt(Term term) {
        return null;
    }

    @Override
    @GetMapping("/day/login-cnt")
    public HashMap<String, Object> getDayLoginCnt(Term term) {
        return null;
    }

    @Override
    @GetMapping("/month/login-avg-cnt")
    public HashMap<String, Object> getAvgDailyLoginCnt(Term term) {
        return null;
    }

    @Override
    @GetMapping("/month/exclude-dayoff-login")
    public HashMap<String, Object> getExcludeOffDayMonthlyLoginCnt(Term term) {
        return null;
    }

    @Override
    @GetMapping("/month/groupby-login")
    public HashMap<String, Object> getGroupByDepartLoginCnt(String month) {
        return null;
    }
}