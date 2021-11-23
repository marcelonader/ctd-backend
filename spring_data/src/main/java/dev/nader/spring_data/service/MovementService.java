package dev.nader.spring_data.service;

import dev.nader.spring_data.persistence.entities.MovementEntity;
import dev.nader.spring_data.persistence.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementService {

    @Autowired
    MovementRepository movementRepository;

    public String save(MovementEntity movement){
        if(movementRepository.save(movement) != null)
            return "OK";
        else{
            return null;
        }
    }

    public List<MovementEntity> getAll(){
        return movementRepository.findAll();
    }
}
