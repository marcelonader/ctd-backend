package com.example.aula25integradora.repository.impl;

import com.example.aula25integradora.model.Consulta;
import com.example.aula25integradora.model.Dentista;
import com.example.aula25integradora.model.Paciente;
import com.example.aula25integradora.dto.ConsultaDTO;
import com.example.aula25integradora.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ConsultaRepositoryImpl implements IRepository<Consulta> {

    private static Map<Integer, ConsultaDTO> consultaDTOMap = new HashMap<>();
    private static Integer idGlobal = 1;

    private DentistaRepositoryImpl dentistaRepository;
    private PacienteRepositoryImpl pacienteRepository;

    public ConsultaRepositoryImpl(){
        this.dentistaRepository = new DentistaRepositoryImpl();
        this.pacienteRepository = new PacienteRepositoryImpl();

    }

    @Override
    public Consulta salvar(Consulta consulta) {
        Paciente paciente = pacienteRepository.buscarPorId(consulta.getPaciente().getId());
        if(paciente == null){
            return null;
        }
       Dentista dentista =  dentistaRepository.buscarPorId(consulta.getDentista().getId());
        if(dentista == null){
            return null;
        }
        consulta.setId(idGlobal);
        consulta.setPaciente(paciente);
        consulta.setDentista(dentista);

        consultaDTOMap.put(idGlobal, new ConsultaDTO(consulta));
        idGlobal++;
        return consulta;
    }

    @Override
    public Consulta buscarPorId(Integer id) {
        ConsultaDTO consultaDTO = consultaDTOMap.get(id);
        if(consultaDTO == null){
            return null;
        }
        return new Consulta(consultaDTO,
                pacienteRepository.buscarPorId(consultaDTO.getId()),
                dentistaRepository.buscarPorId(consultaDTO.getId()));
    }

    @Override
    public void deletar(Integer id) {
        consultaDTOMap.remove(id);
    }

    @Override
    public Map<Integer, Consulta> buscarTodos() {
        Map<Integer, Consulta> consultas = new HashMap<>();
        for(Map.Entry<Integer, ConsultaDTO> entry : consultaDTOMap.entrySet()){
            consultas.put(entry.getKey(), new Consulta(entry.getValue(),
                    pacienteRepository.buscarPorId(entry.getValue().getId()),
                    dentistaRepository.buscarPorId(entry.getValue().getId())));
        }
        return consultas;
    }

    @Override
    public Consulta atualizar(Integer id, Consulta consulta) {
        ConsultaDTO consultaDTO = consultaDTOMap.get(id);
        if(consultaDTO == null){
            return null;
        }

       Paciente paciente = pacienteRepository.buscarPorId(consultaDTO.getIdPaciente());
       pacienteRepository.atualizar(paciente.getId(), consulta.getPaciente());
       Dentista dentista = dentistaRepository.buscarPorId(consultaDTO.getIdDentista());
       dentistaRepository.atualizar(dentista.getId(), consulta.getDentista());

       consultaDTOMap.put(id, new ConsultaDTO(consulta));

       return consulta;
    }
}
