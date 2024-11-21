package model;

import java.util.ArrayList;
import java.util.List;

public class Sale {
	private List<SaleItem> items = new ArrayList<>();
	private PaymentMethod paymentMethod;

	public void setPaymentMethod(String payment) {
		paymentMethod = DataBase.selectPayment(payment);
	}

	public String getPaymentMethod() {
		return paymentMethod.toString();
	}

	public void createSaleItem(String code, int quantity, EstoqueRepository estoque) {
		ItemEstoque itemEstoque = estoque.buscarItem(code);
		if (itemEstoque == null) {
			throw new RuntimeException("Produto não encontrado no estoque.");
		}

		SaleItem item = new SaleItem();
		item.setProduct(new Product(itemEstoque.getDescricao(), itemEstoque.getPreco()));
		item.setQuantity(quantity);

		items.add(item);
	}

	public double getTotal() {
		return items.stream().mapToDouble(SaleItem::getSubtotal).sum();
	}

	public List<String> getItems() {
		List<String> itemsStr = new ArrayList<>();
		for (SaleItem saleItem : items) {
			itemsStr.add(saleItem.toString());
		}
		return itemsStr;
	}

	public double getFinalPrice() {
		return paymentMethod.calculate(getTotal());
	}
}
