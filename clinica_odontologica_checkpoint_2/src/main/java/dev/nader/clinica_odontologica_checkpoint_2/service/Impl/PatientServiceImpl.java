package dev.nader.clinica_odontologica_checkpoint_2.service.Impl;
import dev.nader.clinica_odontologica_checkpoint_2.persistence.entities.PatientEntity;
import dev.nader.clinica_odontologica_checkpoint_2.persistence.repository.IAddressRepository;
import dev.nader.clinica_odontologica_checkpoint_2.persistence.repository.IPatientRepository;
import dev.nader.clinica_odontologica_checkpoint_2.service.IDentalService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class PatientServiceImpl implements IDentalService<PatientEntity> {

    final static Logger log = Logger.getLogger(PatientServiceImpl.class);

    @Autowired
    IAddressRepository addressRepository;
    @Autowired
    IPatientRepository patientRepository;

    @Override
    public PatientEntity save(PatientEntity patient){
        log.debug("Registrando um novo paciente: " + patient.toString());
            patient.setAddress(addressRepository.save(patient.getAddress()));
//            addressRepository.save(patient.getAddress());
            return patientRepository.save(patient);
    }


    @Override
    public PatientEntity getById(Integer id) {
        log.debug("Buscando paciente: " + patientRepository.findById(id).get());
        return patientRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        log.debug("Deletando paciente: " + patientRepository.findById(id).get());
        patientRepository.deleteById(id);
    }

    @Override
    public List<PatientEntity> getAll() {
        log.debug("Buscando lista de todos os pacientes");
        return patientRepository.findAll();
    }

    @Override
    public PatientEntity update(PatientEntity patient) {
        log.debug("Atualizando dados do paciente: " + patient);
        PatientEntity patientBase = patientRepository.findById(patient.getId()).get();
        if(patient.getName() != null)
            patientBase.setName(patient.getName());
        if(patient.getLastname() != null)
            patientBase.setLastname(patient.getLastname());
        if(patient.getAddress() != null)
            patientBase.setAddress(patient.getAddress());
        return patientRepository.saveAndFlush(patientBase);
    }
}
