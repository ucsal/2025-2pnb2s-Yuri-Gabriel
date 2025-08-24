package br.com.mariojp.solid.srp;

import java.util.Optional;

public class TaxCalculator {
    public static double calculate(double subtotal) {
        double tax = subtotal * Double.parseDouble(
            Optional.ofNullable(System.getProperty("tax.rate")).orElse("0.0")
        );
		return subtotal + tax;
    }
}
