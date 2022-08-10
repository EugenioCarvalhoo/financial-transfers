package br.com.bank.utils;

import java.math.BigDecimal;

public class Calculate {
    
    public static final BigDecimal ONE_HUNDRED = new BigDecimal("100");

	public static BigDecimal percentage(BigDecimal base, BigDecimal pct) {
		return base.multiply(pct).divide(ONE_HUNDRED);
	}

	public static BigDecimal subtractPercentage(BigDecimal base, BigDecimal pct) {
		return base.subtract(percentage(base, pct)); 
	}
}
