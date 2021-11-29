package dev.nader.clinica_odontologica_checkpoint_2.service.Impl;

import dev.nader.clinica_odontologica_checkpoint_2.persistence.entities.AddressEntity;
import dev.nader.clinica_odontologica_checkpoint_2.persistence.entities.PatientEntity;
import dev.nader.clinica_odontologica_checkpoint_2.persistence.repository.IAddressRepository;
import dev.nader.clinica_odontologica_checkpoint_2.service.IDentalService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressServiceImpl implements IDentalService<AddressEntity> {

    final static Logger log = Logger.getLogger(PatientServiceImpl.class);

    @Autowired
    IAddressRepository addressRepository;

    @Override
    public AddressEntity save(AddressEntity addressEntity) {
        log.debug("Registrando um novo endereço: " + addressEntity.toString());
        return addressRepository.save(addressEntity);
    }

    @Override
    public AddressEntity getById(Integer id) {
        log.debug("Buscando endereço: " + addressRepository.getById(id));
        return addressRepository.getById(id);
    }

    @Override
    public void delete(Integer id) {
        log.debug("Deletando endereço: " + addressRepository.getById(id));
        addressRepository.deleteById(id);
    }

    @Override
    public List<AddressEntity> getAll() {
        log.debug("Buscando lista de todos os endereços");
        return addressRepository.findAll();
    }

    @Override
    public AddressEntity update(AddressEntity addressEntity) {
        log.debug("Atualizando dados do endereço: " + addressEntity);
        AddressEntity addressBase = addressRepository.getById(addressEntity.getId());
        if(addressEntity.getStreet() != null)
            addressBase.setStreet(addressEntity.getStreet());
        if(addressEntity.getNumber() != null)
            addressBase.setNumber(addressEntity.getNumber());
        return addressRepository.saveAndFlush(addressBase);
    }
}
