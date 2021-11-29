package dev.nader.clinica_odontologica_checkpoint_2.controller;

import dev.nader.clinica_odontologica_checkpoint_2.dto.AddressDTO;
import dev.nader.clinica_odontologica_checkpoint_2.dto.PatientDTO;
import dev.nader.clinica_odontologica_checkpoint_2.persistence.entities.AddressEntity;
import dev.nader.clinica_odontologica_checkpoint_2.persistence.entities.PatientEntity;
import dev.nader.clinica_odontologica_checkpoint_2.service.Impl.AddressServiceImpl;
import dev.nader.clinica_odontologica_checkpoint_2.service.Impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
public class AddressController {

        @Autowired
        private AddressServiceImpl addressService;

        @GetMapping("/{addressId}")
        public ResponseEntity getAddress(@PathVariable Integer addressId){
            AddressEntity addressBase = addressService.getById(addressId);
            AddressDTO addressDTO = new AddressDTO(addressBase);
            return addressBase == null
                ? ResponseEntity.badRequest().body("Endereço não encontrado")
                : ResponseEntity.ok(addressDTO);
        }

        @GetMapping("/listAddress")
        public ResponseEntity<List<AddressDTO>> getAll(){
            List<AddressDTO> listAddressDTO =
                    addressService.getAll().stream().map(AddressDTO::new).collect(Collectors.toList());
            return ResponseEntity.ok(listAddressDTO);
        }
}
