package com.example.Aula20.service;

import com.example.Aula20.model.Paciente;

import java.util.Map;

public interface OdontoService<T> {
    T salvar(T t);
    Map<Integer, T> buscarTodos();
    void deletar(Integer id);
    T buscarPorId(Integer id);
    T atualizar(T t);
}
