package dev.nader.api_films.controller;

import dev.nader.api_films.Model.Film;
import dev.nader.api_films.dto.FilmDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import dev.nader.api_films.service.impl.FilmServiceImpl;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/")
public class FilmController {

    @Autowired
    FilmServiceImpl filmService;

    @GetMapping("/films")
    @ResponseBody
    public List<FilmDTO> getAll(){
        return filmService.getAll();
    }

    @GetMapping("/save/{title}/{category}/{awards}")
    public String save(@PathVariable String title, @PathVariable String category, @PathVariable Integer awards){
        Film film1 = new Film(title, category, awards);
        filmService.save(film1);
        return "Filme salvo com sucesso";
    }

    @GetMapping("/{id}")
    public String deleteById(@PathVariable Integer id) {
        filmService.deleteById(id);
        return "Filme deletado";
    }
}
