package pl.parser.nbp.currency;

import java.util.List;

public class Currency {

	private String currrency;
	private String code;
	private List<Rate> rates;

	public String getCurrrency() {
		return currrency;
	}

	public void setCurrrency(String currrency) {
		this.currrency = currrency;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Rate> getRates() {
		return rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

}
