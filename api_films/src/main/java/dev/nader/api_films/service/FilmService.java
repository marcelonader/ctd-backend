package dev.nader.api_films.service;

import dev.nader.api_films.Model.Film;
import dev.nader.api_films.dto.FilmDTO;

import java.util.List;

public interface FilmService {

    Film save(Film film);
    void deleteById(Integer id);
    List<FilmDTO> getAll();
}
