package com.example.aula25integradora.repository.impl;

import com.example.aula25integradora.model.Endereco;
import com.example.aula25integradora.dto.EnderecoDTO;
import com.example.aula25integradora.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EnderecoRepositoryImpl implements IRepository<Endereco> {
    private static Map<Integer, EnderecoDTO> enderecoDTOMap = new HashMap<>();
    private static Integer idGlobal = 1;

    @Override
    public Endereco salvar(Endereco endereco) {
        endereco.setId(idGlobal);
        EnderecoDTO enderecoDTO = new EnderecoDTO(endereco);
        enderecoDTOMap.put(idGlobal, enderecoDTO);
        idGlobal++ ;
        return endereco;
    }

    @Override
    public Endereco buscarPorId(Integer id) {
        EnderecoDTO enderecoDTO = enderecoDTOMap.get(id);
        if(enderecoDTO == null){
            return null;
        }
        return new Endereco(enderecoDTO);
    }

    @Override
    public void deletar(Integer id) {
        enderecoDTOMap.remove(id);
    }

    @Override
    public Map<Integer, Endereco> buscarTodos() {
        Map<Integer, Endereco> enderecos = new HashMap<>();
        for(Map.Entry<Integer, EnderecoDTO> entry : enderecoDTOMap.entrySet()){
            enderecos.put(entry.getKey(), new Endereco(entry.getValue()));
        }
        return enderecos;
    }

    @Override
    public Endereco atualizar(Integer id, Endereco endereco) {
        EnderecoDTO enderecoDTO = enderecoDTOMap.get(id);
        if(enderecoDTO == null){
            return null;
        }
        endereco.setId(id);
        enderecoDTOMap.put(id, new EnderecoDTO(endereco));
        return endereco;
    }


}
