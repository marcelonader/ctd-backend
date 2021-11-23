package dev.nader.api_films.dto;

import dev.nader.api_films.Model.Film;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmDTO {
    private String title;
    private String category;

    public FilmDTO(Film film){
        this.title = film.getTitle();
        this.category = film.getCategory();
    }

}
