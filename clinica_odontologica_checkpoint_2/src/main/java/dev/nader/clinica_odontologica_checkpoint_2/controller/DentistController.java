package dev.nader.clinica_odontologica_checkpoint_2.controller;

import dev.nader.clinica_odontologica_checkpoint_2.dto.DentistDTO;
import dev.nader.clinica_odontologica_checkpoint_2.dto.PatientDTO;
import dev.nader.clinica_odontologica_checkpoint_2.persistence.entities.DentistEntity;
import dev.nader.clinica_odontologica_checkpoint_2.persistence.entities.PatientEntity;
import dev.nader.clinica_odontologica_checkpoint_2.service.Impl.DentistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dentist")
public class DentistController {
    @Autowired
    private DentistServiceImpl dentistService;

    @PostMapping
    public ResponseEntity<DentistDTO> save (@RequestBody DentistEntity dentist){
        dentistService.save(dentist);
        DentistDTO dentistDTO = new DentistDTO(dentist);
        return ResponseEntity.ok(dentistDTO);
    }
    @GetMapping("/{dentistId}")
    public ResponseEntity getById (@PathVariable Integer dentistId){
        DentistEntity dentistBase = dentistService.getById(dentistId);
        DentistDTO dentistDTO = new DentistDTO(dentistBase);
        return dentistBase == null
            ? ResponseEntity.badRequest().body("Dentista não encontrado")
            : ResponseEntity.ok(dentistDTO);
    }

    @GetMapping("/listDentists")
    public ResponseEntity<List<DentistDTO>> getAll(){
        List<DentistDTO> listDentistsDTO =
                dentistService.getAll().stream().map(DentistDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(listDentistsDTO);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody DentistEntity dentist){
        DentistEntity dentistBase = dentistService.getById(dentist.getId());
        if(dentistBase == null)
            return ResponseEntity.badRequest().body("Dentista não encontrado");
        dentistService.delete(dentistBase.getId());
        return ResponseEntity.ok("Dentista deletado com sucesso");
    }

    @PutMapping
    public ResponseEntity update(@RequestBody DentistEntity dentist){
        return dentist == null
            ? ResponseEntity.badRequest().body("Dentista não encontrado")
            : ResponseEntity.ok(dentistService.update(dentist));
    }
}
