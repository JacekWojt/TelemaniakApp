package pl.jw.telemaniak.domain.movie.dto;

public class MovieShortDto {
    private Long id;
    private String title;
    private String shortDescription;

    public MovieShortDto(Long id, String title, String shortDescription) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
