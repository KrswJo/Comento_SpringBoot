## Comment Back-End 직무체험

***
### 0. 프로젝트 환경
#### Spring Boot + Mybatis
#### MariaDB
#### Gradle

***
### 1. API 설계

* 접속자수 (LoginStaticsController)
    * 월별 접속자 수
      ```java
      @GetMapping("/month/login-cnt")
      public HashMap<String, Object> getMonthlyLoginCnt(Term term)
      ```
    * 일자별 접속자 수
      ```java
      @GetMapping("/day/login-cnt")
      public HashMap<String, Object> getDayLoginCnt(Term term) 
      ```
    * 평균 하루 로그인 수
      ```java
      @GetMapping("/month/login-avg-cnt")
      public HashMap<String, Object> getAvgDailyLoginCnt(Term term)
      ```
    * 휴일을 제외한 로그인 수
      ```java
      @GetMapping("/month/exclude-dayoff-login")
      public HashMap<String, Object> getExcludeOffDayMonthlyLoginCnt(Term term)
      ```
    * 부서별 월별 로그인 수
      ```java
      @GetMapping("/month/groupby-login")
      public HashMap<String, Object> getGroupByDepartLoginCnt(String month)
      ```

***
### 2. 구현과정
#### (1) 3주차
##### 사용자 리스트 출력
![Mapper Test](File/Image/이미지%203.png)
##### 20년도 사용자 횟수 테스트
1. Mapper(Repository) Test
```java
package com.example.comento_legacy2reorganization.Dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

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
}
```
![Mapper Test](File/Image/이미지%20001.png)

2. Service Test
```java
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
}

```
![Mapper Test](File/Image/이미지%202.png)
***
##### SQL 작성
[SQL](File/Query.sql)