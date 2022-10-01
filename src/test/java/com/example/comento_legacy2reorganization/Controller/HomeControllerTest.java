package com.example.comento_legacy2reorganization.Controller;

import com.example.comento_legacy2reorganization.service.MovieService;
import com.example.comento_legacy2reorganization.vo.MovieVO;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class)
class HomeControllerTest {
    @MockBean
    private MovieService mockMovieService;
    @Autowired
    private MockMvc mock;

    @Test
    public void CompleteLoadData() throws Exception {
        given(mockMovieService.getMovieList()).willReturn(getFakeData());

        MockHttpServletRequestBuilder request = get("/");

        mock.perform(request)
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("movieList"))
                .andExpect(model().attribute("movieList", IsCollectionWithSize.hasSize(4)))
                .andDo(print());
    }

    private List<MovieVO> getFakeData() {
        List<MovieVO> fakeData = new ArrayList<>();
        fakeData.add(new MovieVO("강릉", "익명1", "느와르"));
        fakeData.add(new MovieVO("국제시장", "익명2", "감동"));
        fakeData.add(new MovieVO("수리남", "익명3", "로맨스"));
        fakeData.add(new MovieVO("한마바키", "익명4", "어린이"));

        return fakeData;
    }
}