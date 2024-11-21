package view;

import model.*;

public class Main {
	public static void main(String[] args) {
		EstoqueRepository estoque = new Estoque(); // Usando a implementação concreta
		GerenciadorVenda gerenciador = new GerenciadorVenda(estoque);

		try {
			Sale venda = gerenciador.criarVenda("at", 2, "cc");
			System.out.println("Venda realizada com sucesso!");
			System.out.println("Itens: " + venda.getItems());
			System.out.println("Total: R$" + venda.getTotal());
			System.out.println("Preço final (com pagamento): R$" + venda.getFinalPrice());
		} catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
		}
	}
}
