package dev.nader.mesaintegradora1911.repository.impl;

import dev.nader.mesaintegradora1911.dto.ConsultaDTO;
import dev.nader.mesaintegradora1911.model.Consulta;
import dev.nader.mesaintegradora1911.model.Dentista;
import dev.nader.mesaintegradora1911.model.Paciente;
import dev.nader.mesaintegradora1911.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ConsultaRepositoryImpl implements IRepository<Consulta> {

    private static Map<Integer, ConsultaDTO> consultaDTOMap = new HashMap<>();
    private static Integer idG = 1;

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
        consulta.setId(idG);
        consulta.setPaciente(paciente);
        consulta.setDentista(dentista);

        consultaDTOMap.put(idG, new ConsultaDTO(consulta));
        idG++;
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
        if(consultaDTO == null)
            return null;
        Paciente paciente = pacienteRepository.buscarPorId(consultaDTO.getIdPaciente());
        pacienteRepository.atualizar(paciente.getId(), consulta.getPaciente());
        Dentista dentista = dentistaRepository.buscarPorId(consultaDTO.getIdDentista());
        dentistaRepository.atualizar(dentista.getId(), consulta.getDentista());
        consultaDTOMap.put(id, new ConsultaDTO(consulta));
        return consulta;
    }
}
