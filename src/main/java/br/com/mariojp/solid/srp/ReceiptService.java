package br.com.mariojp.solid.srp;

import java.util.Optional;

public class ReceiptService {
	public String generate(Order order) {
		double subtotal = order.getItems().stream().mapToDouble(i -> i.getUnitPrice() * i.getQuantity()).sum();

		double taxa = Double.parseDouble(
            Optional.ofNullable(System.getProperty("tax.rate")).orElse("0.0")
        ) * subtotal;

		double total = TaxCalculator.calculate(subtotal);

		String receipt = ReceiptFormatter.format(
			order,
			subtotal,
			taxa,
			total
		);
		return receipt;
	}
}
