package pl.parser.nbp.currency;

import java.util.List;

public class Currency {

	private String currrency;
	private String code;
	private List<Double> bid;
	private List<Double> ask;

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

	public List<Double> getBid() {
		return bid;
	}

	public void setBid(List<Double> bid) {
		this.bid = bid;
	}

	public List<Double> getAsk() {
		return ask;
	}

	public void setAsk(List<Double> ask) {
		this.ask = ask;
	}

}
