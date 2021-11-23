package dev.nader.api_films.service.impl;

import dev.nader.api_films.Model.Film;
import dev.nader.api_films.dto.FilmDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.nader.api_films.repository.impl.FilmRepositoryImpl;
import dev.nader.api_films.service.FilmService;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    FilmRepositoryImpl filmRepository;

    @Override
    public Film save(Film film) {
        FilmDTO filmDTO = new FilmDTO(film);
        filmRepository.save(film);
        return film;
    }

    @Override
    public void deleteById(Integer id) {
       filmRepository.deleteById(id);
    }

    @Override
    public List<FilmDTO> getAll() {
        return filmRepository.getAll();
    }




}
