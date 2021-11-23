package dev.nader.api_films.repository.impl;

import dev.nader.api_films.Model.Film;
import dev.nader.api_films.dto.FilmDTO;
import dev.nader.api_films.repository.FilmRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FilmRepositoryImpl implements FilmRepository {
    private static Map<Integer, FilmDTO> mapFilmsDTO = new HashMap<>();
    private static Integer idGlobal = 1;

    @Override
    public Film save(Film film) {
        film.setId(idGlobal);
        FilmDTO filmDTO = new FilmDTO(film);
        mapFilmsDTO.put(idGlobal++, filmDTO);
        return film;
    }

    @Override
    public void deleteById(Integer id) {
        mapFilmsDTO.remove(id);
    }

    @Override
    public List<FilmDTO> getAll() {
        List<FilmDTO> listFilms = new ArrayList<>();
        mapFilmsDTO.values().forEach(filmDTO -> {
            listFilms.add(filmDTO);
        });
        return listFilms;
    }
}
