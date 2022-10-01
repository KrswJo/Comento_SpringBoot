package com.example.comento_legacy2reorganization.Controller;

import com.example.comento_legacy2reorganization.service.MovieService;
import com.example.comento_legacy2reorganization.vo.MovieVO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Locale;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {
    private final MovieService movieService;

    @GetMapping("/")
    public String home(Locale locale, Model model) throws Exception {
        log.info("Home 화면에 진입합니다.");
        List<MovieVO> movieList = movieService.getMovieList();
        model.addAttribute("movieList", movieList);
        return "home";
    }
}

