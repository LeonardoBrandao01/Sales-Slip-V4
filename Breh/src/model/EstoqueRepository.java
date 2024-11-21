package model;

public interface EstoqueRepository {
    boolean verificarDisponibilidade(String codigo, int quantidade);
    void darBaixa(String codigo, int quantidade);
    ItemEstoque buscarItem(String codigo);
}
