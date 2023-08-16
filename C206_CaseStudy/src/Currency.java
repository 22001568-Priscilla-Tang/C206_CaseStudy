
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 22020959, Aug 7, 2023 4:24:12 PM
 */

public class Currency {
	public String currencyCode;
	public String currencyCode2;
	public String currencyPair;
	public double exchangerate;


	public Currency(String currencyPair,String currencyCode,String currencyCode2, double exchangerate) {
		this.currencyPair = currencyPair;
		this.currencyCode = currencyCode;
		this.currencyCode2 = currencyCode2;
		this.exchangerate = exchangerate;
	

	}

	public String getCurrencyCode() {
		return currencyCode;
	}
	public String getCurrencyCode2() {
		return currencyCode2;
	}
	public String getCurrencyPair() {
		return currencyPair;
	}
	public double getExchangeRate() {
		return exchangerate;
	}

}
