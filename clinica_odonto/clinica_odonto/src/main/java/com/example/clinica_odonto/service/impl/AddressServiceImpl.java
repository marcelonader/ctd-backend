package com.example.clinica_odonto.service.impl;

import com.example.clinica_odonto.model.Address;
import com.example.clinica_odonto.model.Patient;
import com.example.clinica_odonto.service.OdontoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AddressServiceImpl implements OdontoService<Address> {
    private static Map<Integer, Address> addressMap = new HashMap<>();
    private static Integer idGlobal = 1;

    @Override
    public Address create(Address address) {
        address.setId(idGlobal);
        addressMap.put(idGlobal++, address);
        return address;
    }

    @Override
    public Map<Integer, Address> listAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Address search(Integer id) {
        return addressMap.get(id);
    }

    @Override
    public Address update(Address address) {
        return null;
    }
}
