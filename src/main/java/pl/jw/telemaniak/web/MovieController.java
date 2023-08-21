package pl.jw.telemaniak.web;


import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import pl.jw.telemaniak.domain.movie.MovieService;
import pl.jw.telemaniak.domain.movie.dto.MovieDto;
import pl.jw.telemaniak.domain.rating.RatingService;

import java.util.List;

@Controller
public class MovieController {
    private final MovieService movieService;
    private final RatingService ratingService;

    public MovieController(MovieService movieService, RatingService ratingService) {
        this.movieService = movieService;
        this.ratingService = ratingService;
    }

    @GetMapping("/film/{id}")
    public String getMovie(@PathVariable Long id, Model model, Authentication authentication) {
        MovieDto movie = movieService.findMovieById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("movie", movie);
        if(authentication != null) {
            String currentUserEmail = authentication.getName();
            Integer rating = ratingService.getUserRatingForMovie(currentUserEmail, id).orElse(0);
            model.addAttribute("userRating", rating);
        }
        return "movie";
    }

    @GetMapping("/top10")
    public String findTop10(Model model) {
        List<MovieDto> top10Movies = movieService.findTopMovies(10);
        model.addAttribute("heading", "FilmoweTOP10");
        model.addAttribute("description", "Filmy najlepiej oceniane przez użytkowników");
        model.addAttribute("movies", top10Movies);
        return "movie-listing";
    }
}