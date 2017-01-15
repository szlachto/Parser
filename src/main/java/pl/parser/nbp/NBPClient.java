package pl.parser.nbp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class NBPClient {

	private String Currency;
	private String StartTime;
	private String StopTime;
	private ArrayList<Double> currencyBidList, currencyAskList;

	public NBPClient(String currency, String startTime, String stopTime)
			throws ClientCreationCurrencyError, ClientCreationDateError {

		setCurrency(currency);
		setDates(startTime, stopTime);

	}

	public void connect() {

		try {
			URL url = new URL(URLUtil.buildURL(Currency, StartTime, StopTime));
			URLConnection conn = url.openConnection();
			XMLParser xmlParser = new XMLParser(conn);

			currencyBidList = xmlParser.getListOfSpecificTag("Bid");
			currencyAskList = xmlParser.getListOfSpecificTag("Ask");

		}

		catch (MalformedURLException e) {
			System.out.println("MalformedURLException");
		}

		catch (IOException e) {
			System.out.println("IOException");
		}

	}

	public void setDates(String startDate, String stopDate) throws ClientCreationDateError {
		if (DateUtil.validateDates(startDate, stopDate)) {
			StartTime = startDate;
			StopTime = stopDate;

		} else {
			throw new ClientCreationDateError("date input error");
		}

	}

	public String getCurrency() {
		return Currency;
	}

	private void setCurrency(String currency) throws ClientCreationCurrencyError {

		if (SymbolUtil.contains(currency)) {
			Currency = currency;
		} else {
			throw new ClientCreationCurrencyError("wrong currency symbol");
		}
	}

	public String getStartTime() {
		return StartTime;
	}

	private void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public String getStopTime() {
		return StopTime;
	}

	private void setStopTime(String stopTime) {
		StopTime = stopTime;
	}

	public ArrayList<Double> getCurrencyBidList() {
		return currencyBidList;
	}

	public ArrayList<Double> getCurrencyAskList() {
		return currencyAskList;
	}

	class ClientCreationDateError extends Exception {

		private static final long serialVersionUID = -4503858229362821778L;

		public ClientCreationDateError(String message) {
			super(message);

		}

	}

	class ClientCreationCurrencyError extends Exception {

		private static final long serialVersionUID = -4503858229362821778L;

		public ClientCreationCurrencyError(String message) {
			super(message);

		}

	}

}
