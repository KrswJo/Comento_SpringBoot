package com.example.comento_legacy2reorganization.Service;

import com.example.comento_legacy2reorganization.Dao.StaticsMapper;
import com.example.comento_legacy2reorganization.Dto.Term;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StaticsServiceImpl implements StaticsService{
    private final StaticsMapper staticsMapper;

    public List<Object> getYearLoginList(String year){
        return staticsMapper.selectYearLoginList(year);
    }

    @Override
    public HashMap<String, Object> getYearLoginCnt(String year) {
        HashMap<String, Object> result;

        try {
            int isInt = Integer.parseInt(year);
            result = staticsMapper.selectYearLoginCnt(year);
            result.put("year", year);
            result.put("is_success", true);
        } catch (Exception e){
            result = new HashMap<>();
            result.put("totCnt", -999);
            result.put("year", year);
            result.put("is_success", false);
        }
        return result;
    }

    @Override
    public HashMap<String, Object> geMonthlyLoginCnt(Term term) {
        return null;
    }

    @Override
    public HashMap<String, Object> getDayLoginCnt(Term term) {
        return null;
    }

    @Override
    public HashMap<String, Object> getAvgDailyLoginCnt(Term term) {
        return null;
    }

    @Override
    public HashMap<String, Object> getExcludeMonthlyLoginCnt(Term term) {
        return null;
    }

    @Override
    public HashMap<String, Object> getGroupByDepartLoginCnt(String month) {
        return null;
    }

}
