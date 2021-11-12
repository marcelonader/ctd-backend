package br.com.age_api.service;

import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class AgeService {
    private LocalDate dateToday = LocalDate.now();

    public Integer getAge(Integer day, Integer month, Integer year){
        Integer age = dateToday.getYear() - year;
        return age;
    }
}
