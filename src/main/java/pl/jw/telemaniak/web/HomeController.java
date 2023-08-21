package pl.jw.telemaniak.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.jw.telemaniak.domain.movie.MovieService;
import pl.jw.telemaniak.domain.movie.dto.MovieDto;

import java.util.List;

@Controller
class HomeController {
    private final MovieService movieService;

    public HomeController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<MovieDto> promotedMovies = movieService.findAllPromotedMovies();
        model.addAttribute("heading", "Promowane filmy");
        model.addAttribute("description", "Filmy polecane przez nasz zespół");
        model. addAttribute("movies", promotedMovies);
        return "movie-listing";
    }
}
