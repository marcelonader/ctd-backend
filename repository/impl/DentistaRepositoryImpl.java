package com.example.aula25integradora.repository.impl;

import com.example.aula25integradora.model.Dentista;
import com.example.aula25integradora.dto.DentistaDTO;
import com.example.aula25integradora.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DentistaRepositoryImpl implements IRepository<Dentista> {
    private static Map<Integer, DentistaDTO> dentistaDTOMap = new HashMap<>();
    private static Integer idGlobal = 1;

    @Override
    public Dentista salvar(Dentista dentista) {
        dentista.setId(idGlobal);
        DentistaDTO dentistaDTO = new DentistaDTO(dentista);
        dentistaDTOMap.put(idGlobal, dentistaDTO);
        idGlobal++;
        return dentista;
    }

    @Override
    public Dentista buscarPorId(Integer id) {
        DentistaDTO dentistaDTO = dentistaDTOMap.get(id);
        if(dentistaDTO == null){
            return null;
        }
        return new Dentista(dentistaDTO);
    }

    @Override
    public void deletar(Integer id) {
        dentistaDTOMap.remove(id);
    }

    @Override
    public Map<Integer, Dentista> buscarTodos() {
        Map<Integer, Dentista> dentistas = new HashMap<>();
        dentistaDTOMap.forEach((key, value) -> dentistas.put(key, new Dentista(value)));
        return dentistas;
    }

    @Override
    public Dentista atualizar(Integer id, Dentista dentista) {
        DentistaDTO dentistaDTO = dentistaDTOMap.get(id);
        if(dentistaDTO == null){
            return null;
        }
        dentista.setId(id);
        dentistaDTOMap.put(id, new DentistaDTO((dentista)));
        return dentista;
    }
}
