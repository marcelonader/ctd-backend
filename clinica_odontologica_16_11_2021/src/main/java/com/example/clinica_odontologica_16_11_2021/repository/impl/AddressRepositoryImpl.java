package com.example.clinica_odontologica_16_11_2021.repository.impl;

import com.example.clinica_odontologica_16_11_2021.dto.AddressDTO;
import com.example.clinica_odontologica_16_11_2021.model.Address;
import com.example.clinica_odontologica_16_11_2021.repository.IRepository;

import java.util.HashMap;
import java.util.Map;

public class AddressRepositoryImpl implements IRepository<Address> {

    private Map<Integer, AddressDTO> addressMap = new HashMap<>();
    private static Integer idG = 1;

    @Override
    public Address save(Address address) {
        address.setId(idG);
        AddressDTO addressDTO = new AddressDTO(address);
        addressMap.put(idG++, addressDTO);

        return address;
    }

    @Override
    public Address searchById(Integer id) {
        Address address = new Address(addressMap.get(id));
        return address;
    }
}
