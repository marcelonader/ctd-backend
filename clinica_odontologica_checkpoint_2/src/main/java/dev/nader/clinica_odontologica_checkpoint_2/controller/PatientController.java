package dev.nader.clinica_odontologica_checkpoint_2.controller;
import dev.nader.clinica_odontologica_checkpoint_2.dto.PatientDTO;
import dev.nader.clinica_odontologica_checkpoint_2.persistence.entities.PatientEntity;
import dev.nader.clinica_odontologica_checkpoint_2.service.Impl.AddressServiceImpl;
import dev.nader.clinica_odontologica_checkpoint_2.service.Impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    @PostMapping
    public ResponseEntity<PatientDTO> save (@RequestBody PatientEntity patient){
        patientService.save(patient);
        PatientDTO patientDTO = new PatientDTO(patient);
        return ResponseEntity.ok(patientDTO);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity getPatient(@PathVariable Integer patientId){
        PatientEntity patientBase = patientService.getById(patientId);
        PatientDTO patientDTO = new PatientDTO(patientBase);
        return patientBase == null
                ? ResponseEntity.badRequest().body("Paciente não encontrado")
                : ResponseEntity.ok(patientDTO);
    }

    @GetMapping("/listPatients")
    public ResponseEntity<List<PatientDTO>> getAll(){
        List<PatientDTO> listPatientsDTO =
                patientService.getAll().stream().map(PatientDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(listPatientsDTO);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody PatientEntity patient){
        PatientEntity patientBase = patientService.getById(patient.getId());
        if(patientBase == null)
            return ResponseEntity.badRequest().body("Paciente não encontrado");
        patientService.delete(patientBase.getId());
        return ResponseEntity.ok("Paciente deletado com sucesso");
    }

    @PutMapping
    public ResponseEntity update(@RequestBody PatientEntity patient){
        return patient == null
                ? ResponseEntity.badRequest().body("Paciente não encontrado")
                : ResponseEntity.ok(patientService.update(patient));
    }
}
