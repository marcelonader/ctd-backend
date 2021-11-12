package br.com.age_api.controller;

import br.com.age_api.service.AgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AgeControler {

    @Autowired
    AgeService ageService;

    @GetMapping("{day}/{month}/{year}")
    public String getAge(Model model, @PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {
        Integer age = ageService.getAge(day, month, year);
        model.addAttribute("age", age);
        return "index";
    }

}
