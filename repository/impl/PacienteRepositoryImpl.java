package com.example.aula25integradora.repository.impl;

import com.example.aula25integradora.model.Endereco;
import com.example.aula25integradora.model.Paciente;
import com.example.aula25integradora.dto.PacienteDTO;
import com.example.aula25integradora.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PacienteRepositoryImpl implements IRepository<Paciente> {
    private static Map<Integer, PacienteDTO> pacienteDTOMap = new HashMap<>();
    private static Integer idGlobal = 1;

    private EnderecoRepositoryImpl enderecoRepository;

    public PacienteRepositoryImpl() {
        this.enderecoRepository = new EnderecoRepositoryImpl();
    }

    @Override
    public Paciente salvar(Paciente paciente) {
        paciente.setEndereco(enderecoRepository.salvar(paciente.getEndereco()));
        paciente.setId(idGlobal);
        PacienteDTO pacienteDTo = new PacienteDTO(paciente);
        pacienteDTOMap.put(idGlobal, pacienteDTo);
        idGlobal++;
        return paciente;
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        PacienteDTO pacienteDTO = pacienteDTOMap.get(id);
        if(pacienteDTO == null) {
            return null;
        }
        return new Paciente(pacienteDTO, enderecoRepository.buscarPorId(pacienteDTO.getIdEndereco()));
    }

    @Override
    public void deletar(Integer id) {
        PacienteDTO pacienteDTO = pacienteDTOMap.get(id);
        enderecoRepository.deletar(pacienteDTO.getIdEndereco());
        pacienteDTOMap.remove(pacienteDTO.getId());
    }

    @Override
    public Map<Integer, Paciente> buscarTodos() {
        Map<Integer, Paciente> pacientes = new HashMap<>();
        for(Map.Entry<Integer, PacienteDTO> entry : pacienteDTOMap.entrySet()) {
            pacientes.put(entry.getKey(), new Paciente(entry.getValue(), enderecoRepository.buscarPorId(entry.getValue().getIdEndereco())));
        }
        return pacientes;
    }

    @Override
    public Paciente atualizar(Integer id, Paciente paciente) {
        PacienteDTO pacienteDTO = pacienteDTOMap.get(id);
        if(pacienteDTO == null) {
            return null;
        }
        paciente.setId(id);
        Endereco endereco = enderecoRepository.buscarPorId(pacienteDTO.getIdEndereco());
        paciente.getEndereco().setId(endereco.getId());
        enderecoRepository.atualizar(paciente.getEndereco().getId(), paciente.getEndereco());
        PacienteDTO pacienteDTOAtualizado = new PacienteDTO(paciente);
        pacienteDTOMap.put(id, pacienteDTOAtualizado);
        return paciente;
    }
}
