package dev.nader.mesaintegradora1911.service.impl;

import dev.nader.mesaintegradora1911.model.Dentista;
import dev.nader.mesaintegradora1911.repository.impl.DentistaRepositoryImpl;
import dev.nader.mesaintegradora1911.service.IOdontoService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DentistaServiceImpl implements IOdontoService<Dentista> {
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
