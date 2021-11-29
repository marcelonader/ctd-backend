package dev.nader.mesaintegradora.service.impl;

import dev.nader.mesaintegradora.model.Paciente;
import dev.nader.mesaintegradora.repository.impl.PacienteRepositoryImpl;
import dev.nader.mesaintegradora.service.OdontoService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PacienteServiceImpl implements OdontoService<Paciente> {
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
