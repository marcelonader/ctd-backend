package dao;

public interface IDao <T>{
    T salvar(T t);
    T buscar(Integer t);
    void deletar(T t);
    T modificar(T t);
}
