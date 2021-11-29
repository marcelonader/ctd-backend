package dev.nader.mesaintegradora1911.service;

import java.util.Map;

public interface IOdontoService<T> {
    T salvar(T t);
    T buscarPorId(Integer id);
    void deletar(Integer id);
    Map<Integer, T> buscarTodos();
    T atualizar(Integer id, T t);
}
