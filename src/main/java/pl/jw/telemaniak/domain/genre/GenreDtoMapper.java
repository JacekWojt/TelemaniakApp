package pl.jw.telemaniak.domain.genre;

import pl.jw.telemaniak.domain.genre.dto.GenreDto;

public class GenreDtoMapper {
    static GenreDto map(Genre genre) {
        return new GenreDto(
                genre.getId(),
                genre.getName(),
                genre.getDescription()
        );
    }
}
