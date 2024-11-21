package model;

import java.util.HashMap;
import java.util.Map;

public class Estoque implements EstoqueRepository {
    private Map<String, ItemEstoque> itens = new HashMap<>();

    public Estoque() {
        inicializarEstoque();
    }

    private void inicializarEstoque() {
        itens.put("at", new ItemEstoque("Arroz Tatiana", 30.0, 50));
        itens.put("ff", new ItemEstoque("Feijão Fejó", 20.0, 100));
        itens.put("msa", new ItemEstoque("Macarrão Santa Amália", 15.0, 75));
    }

    @Override
    public boolean verificarDisponibilidade(String codigo, int quantidade) {
        ItemEstoque item = itens.get(codigo);
        return item != null && item.getQuantidade() >= quantidade;
    }

    @Override
    public void darBaixa(String codigo, int quantidade) {
        if (verificarDisponibilidade(codigo, quantidade)) {
            itens.get(codigo).diminuirQuantidade(quantidade);
        } else {
            throw new RuntimeException("Quantidade insuficiente no estoque.");
        }
    }

    @Override
    public ItemEstoque buscarItem(String codigo) {
        return itens.get(codigo);
    }
}
