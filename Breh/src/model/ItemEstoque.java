package model;

public class ItemEstoque {
    private String descricao;
    private double preco;
    private int quantidade;

    public ItemEstoque(String descricao, double preco, int quantidade) {
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void diminuirQuantidade(int quantidade) {
        this.quantidade -= quantidade;
    }
}

