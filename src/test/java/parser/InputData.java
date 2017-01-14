package parser;

class InputData {
	String currency;
	String startDate;
	String stopDate;

	public InputData(String currency, String startDate, String stopDate) {

		this.currency = currency;
		this.startDate = startDate;
		this.stopDate = stopDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String tartDate) {
		this.startDate = tartDate;
	}

	public String getStopDate() {
		return stopDate;
	}

	public void setStopDate(String stopDate) {
		stopDate = stopDate;
	}
}
