package pl.jw.telemaniak.api;

import org.springframework.web.bind.annotation.*;
import pl.jw.telemaniak.domain.genre.GenreService;
import pl.jw.telemaniak.domain.genre.dto.GenreDto;

import java.util.List;
import java.util.Optional;

@RestController
class GenreRestController {
    private final GenreService genreService;

    public GenreRestController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/api/all-genres")
    public List<GenreDto> getGenreList() {
        List<GenreDto> genres = genreService.findAllGenres();
        return genres;
    }

    @GetMapping("/api/find-genre/{name}")
    public Optional<GenreDto> findGenreByName(@PathVariable String name) {
        Optional<GenreDto> genreByName = genreService.findGenreByName(name);
        return genreByName;
    }
}
