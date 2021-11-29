package dev.nader.mesaintegradora.repository;

import java.util.Map;

public interface IRepository<T> {
    T salvar(T t);
    T buscarPorId(Integer id);
    void deletar(Integer id);
    Map<Integer, T> buscarTodos();
    T atualizar(Integer id, T t);

}
