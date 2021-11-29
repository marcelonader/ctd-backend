package dev.nader.mesaintegradora1911.service.impl;

import dev.nader.mesaintegradora1911.model.Paciente;
import dev.nader.mesaintegradora1911.repository.impl.PacienteRepositoryImpl;
import dev.nader.mesaintegradora1911.service.IOdontoService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PacienteServiceImpl implements IOdontoService<Paciente> {
    private PacienteRepositoryImpl pacienteRepository;

    public PacienteServiceImpl() {
        this.pacienteRepository = new PacienteRepositoryImpl();
    }

    @Override
    public Paciente salvar(Paciente paciente) {
        return pacienteRepository.salvar(paciente);
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        return  pacienteRepository.buscarPorId(id);
    }

    @Override
    public void deletar(Integer id) {
        pacienteRepository.deletar(id);
    }

    @Override
    public Map<Integer, Paciente> buscarTodos() {
        return pacienteRepository.buscarTodos();
    }

    @Override
    public Paciente atualizar(Integer id, Paciente paciente) {
        return pacienteRepository.atualizar(id, paciente);
    }
}
