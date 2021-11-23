package com.example.aula25integradora.service.impl;

import com.example.aula25integradora.model.Dentista;
import com.example.aula25integradora.repository.impl.DentistaRepositoryImpl;
import com.example.aula25integradora.service.OdontoService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DentistaServiceImpl implements OdontoService<Dentista> {
    private DentistaRepositoryImpl dentistaRepository;

    public DentistaServiceImpl() {
        this.dentistaRepository = new DentistaRepositoryImpl();
    }

    @Override
    public Dentista salvar(Dentista dentista) {
        return dentistaRepository.salvar(dentista);
    }

    @Override
    public Dentista buscarPorId(Integer id) {
        return dentistaRepository.buscarPorId(id);
    }

    @Override
    public void deletar(Integer id) {
        dentistaRepository.deletar(id);
    }

    @Override
    public Map<Integer, Dentista> buscarTodos() {
        return dentistaRepository.buscarTodos();
    }

    @Override
    public Dentista atualizar(Integer id, Dentista dentista) {
        return dentistaRepository.atualizar(id, dentista);
    }
}
