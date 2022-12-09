# 월.일별 로그인 수
SELECT SUBSTR(createDate, 1, 6) AS date
FROM requestinfo
WHERE requestCode = 'L' AND
      createDate BETWEEN {startDate} AND {endDate}
GROUP BY SUBSTR(createDate, 1, 8)
ORDER BY SUBSTR(createDate, 1, 8)

# 월별 하루 평균 로그인 수
SELECT *
FROM(
    SELECT SUBSTR(createDate, 1, 8) As loginDay, COUNT(*) As loginCnt
    FROM requestinfo
    WHERE requestCode = 'L' AND
        createDate BETWEEN {startDate} AND {endDate}
    GROUP BY SUBSTR(createDate, 1, 8)
    ORDER BY SUBSTR(createDate, 1, 8)
)
GROUP BY SUBSTR(loginDay, 1, 7)

# 월별 휴일 제외 로그인 수
SELECT SUBSTR(createDate, 1, 6) AS date, COUNT(*) AS cnt
FROM (
         SELECT createDate, dayofweek(SUBSTR(createDate, 1, 8)) AS weekday
         FROM REQUESTINFO
         WHERE requestCode = 'L'
           AND createDate BETWEEN {startDate} AND {endDate}
     ) AS tmp
WHERE weekday != 1 AND weekday != 7
GROUP BY SUBSTR(createDate, 1, 6)
ORDER BY date;

# 부서별 월단위 로그인 수
SELECT * , RANK() OVER (ORDER BY totalLoginCnt DESC) AS deptRank
FROM (
         SELECT u.HR_ORGAN, COUNT(*) AS totalLoginCnt
         FROM REQUESTINFO AS r, USER AS u
         WHERE r.userID = u.userID AND r.requestCode = 'L' AND SUBSTR(createDate, 1, 6) = {month}
         GROUP BY u.HR_ORGAN
     ) AS counts
ORDER BY deptRank;
