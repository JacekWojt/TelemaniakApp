package pl.jw.telemaniak.domain.genre.dto;

public class GenreNewDto {
    private String name;
    private String description;

    public GenreNewDto() {
    }

    public GenreNewDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
