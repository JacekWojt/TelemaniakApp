package pl.jw.telemaniak.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.jw.telemaniak.domain.movie.MovieDtoMapper;
import pl.jw.telemaniak.domain.movie.MovieRepository;
import pl.jw.telemaniak.domain.movie.dto.MovieShortDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
class MovieRestController {

    private final MovieRepository movieRepository;

    public MovieRestController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/api/movie-genre/{genreName}")
    public List<MovieShortDto> getMovieByGenre(@PathVariable String genreName) {
        return movieRepository.findAllByGenre_NameIgnoreCase(genreName)
                .stream()
                .map(movie -> new MovieShortDto(
                movie.getId(),
                movie.getTitle(),
                movie.getShortDescription()
        )).collect(Collectors.toList());
    }

    @GetMapping("/api/movie-id/{id}")
    public MovieShortDto getMovieByIp(@PathVariable Long id) {
        return movieRepository.findById(id).map(MovieDtoMapper::map)
                .map(movie -> new MovieShortDto(
                        movie.getId(),
                        movie.getTitle(),
                        movie.getShortDescription()
                )).orElseThrow();
    }
}
