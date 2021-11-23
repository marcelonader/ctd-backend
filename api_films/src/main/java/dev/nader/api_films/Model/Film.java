package dev.nader.api_films.Model;

import dev.nader.api_films.dto.FilmDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Film {

    private Integer id;
    private String title;
    private String category;
    private Integer awards;

    public Film(FilmDTO filmDTO){
        this.title = filmDTO.getTitle();
        this.category = filmDTO.getCategory();
    }

    public Film(String title, String category, Integer awards) {
        this.title = title;
        this.category = category;
        this.awards = awards;
    }
}
