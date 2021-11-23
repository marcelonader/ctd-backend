package com.example.Aula20.service.impl;

import com.example.Aula20.model.Dentista;
import com.example.Aula20.service.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DentistaServiceImpl implements OdontoService<Dentista> {
    private static Map<Integer, Dentista> dentistaMap = new HashMap<>();

    private static Integer idGlobal = 1;

    @Autowired
    private PacienteServiceImpl pacienteService;


    @Override
    public Dentista salvar(Dentista dentista) {
        dentista.setIdPaciente(pacienteService.salvar(dentista.getPaciente()).getId());
        dentista.setId(idGlobal);
        dentistaMap.put(idGlobal, dentista);
        idGlobal++;
        return dentista;
    }

    @Override
    public Map<Integer, Dentista> buscarTodos() {
        dentistaMap.forEach((chave, dentista) -> {
            dentista.setPaciente(pacienteService.buscarPorId(dentista.getIdPaciente()));
        });
        return dentistaMap;
    }

    @Override
    public void deletar(Integer id) {
        pacienteService.deletar(buscarPorId(id).getIdPaciente());
        dentistaMap.remove(id);
    }

    @Override
    public Dentista buscarPorId(Integer id) {
        Dentista dentista = new Dentista();
        try {
            dentista = dentistaMap.get(id);
            dentista.setPaciente(pacienteService.buscarPorId(dentista.getIdPaciente()));
        } catch (Exception e){
            return null;
        }
        return dentista;
    }

    @Override
    public Dentista atualizar(Dentista dentista) {
        pacienteService.atualizar(dentista.getPaciente());
        dentistaMap.put(dentista.getId(), dentista);
        return dentista;
    }
}
