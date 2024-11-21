package model;

public class GerenciadorVenda {
    private EstoqueRepository estoque;

    public GerenciadorVenda(EstoqueRepository estoque) {
        this.estoque = estoque;
    }

    public Sale criarVenda(String codigoProduto, int quantidade, String metodoPagamento) {
        if (!estoque.verificarDisponibilidade(codigoProduto, quantidade)) {
            throw new RuntimeException("Produto indisponível no estoque.");
        }

        Sale venda = new Sale();
        venda.createSaleItem(codigoProduto, quantidade, estoque);
        venda.setPaymentMethod(metodoPagamento);

        estoque.darBaixa(codigoProduto, quantidade);
        return venda;
    }
}
