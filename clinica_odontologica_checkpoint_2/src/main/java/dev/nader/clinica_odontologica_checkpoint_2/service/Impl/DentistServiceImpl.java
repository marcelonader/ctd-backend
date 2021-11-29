package dev.nader.clinica_odontologica_checkpoint_2.service.Impl;

import dev.nader.clinica_odontologica_checkpoint_2.persistence.entities.DentistEntity;
import dev.nader.clinica_odontologica_checkpoint_2.persistence.repository.IDentistRepository;
import dev.nader.clinica_odontologica_checkpoint_2.service.IDentalService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistServiceImpl implements IDentalService<DentistEntity> {

    final static Logger log = Logger.getLogger(DentistServiceImpl.class);

    @Autowired
    IDentistRepository dentistRepository;

    @Override
    public DentistEntity save(DentistEntity dentistEntity) {
        log.info("Registrando um novo dentista: " + dentistEntity.toString());
        return dentistRepository.save(dentistEntity);
    }

    @Override
    public DentistEntity getById(Integer id) {
        log.debug("Buscando dentista: " + dentistRepository.findById(id).get());
        return dentistRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        log.debug("Deletando dentista: " + dentistRepository.findById(id).get());
        dentistRepository.deleteById(id);
    }

    @Override
    public List<DentistEntity> getAll() {
        log.debug("Buscando lista de todos os dentistas");
        return dentistRepository.findAll();
    }

    @Override
    public DentistEntity update(DentistEntity dentist) {
        log.debug("Atualizando dados do dentista: " + dentist);
        DentistEntity dentistBase = dentistRepository.findById(dentist.getId()).get();
        if(dentist.getName() != null)
            dentistBase.setName(dentist.getName());
        if(dentist.getLastname() != null)
            dentistBase.setLastname(dentist.getLastname());
        if(dentist.getRegisterNumber() != null)
            dentistBase.setRegisterNumber(dentist.getRegisterNumber());
        return dentistRepository.saveAndFlush(dentistBase);
    }
}
