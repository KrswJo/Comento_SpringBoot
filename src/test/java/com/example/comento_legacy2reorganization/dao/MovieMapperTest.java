package com.example.comento_legacy2reorganization.dao;

import com.example.comento_legacy2reorganization.vo.MovieVO;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import static org.mockito.BDDMockito.given;

import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class MovieMapperTest {
    @Autowired
    private MovieMapper movieMapper;

    @Mock
    private MovieMapper mockMovieMapper;

    @Test
    void findAll_1() {
        try {
            List<MovieVO> list = movieMapper.findAll();
            assertEquals(list.size(), 3);

            list.stream()
                    .forEach(i -> System.out.println(i));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 사실상 의미없는 DAO 테스트
    @Test
    void findAll_2() throws Exception {
        mockMovieMapper = mock(MovieMapper.class);
        List<MovieVO> fakeData = getFakeData();
        when(mockMovieMapper.findAll()).thenReturn(fakeData);

        List<MovieVO> actual = mockMovieMapper.findAll();
        verify(mockMovieMapper).findAll();
        assertEquals(actual.size(), 2);
    }

    private static List<MovieVO> getFakeData() {
        List<MovieVO> fakeData = new ArrayList<>();
        fakeData.add(new MovieVO("강릉", "익명1", "느와르"));
        fakeData.add(new MovieVO("국제시장", "익명2", "감동"));

        return fakeData;
    }
}