package pl.parser.nbp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import pl.parser.nbp.errors.ClientCreationCurrencyError;
import pl.parser.nbp.errors.ClientCreationDateError;
import pl.parser.nbp.utils.CurrencySymbols;
import pl.parser.nbp.utils.DateUtil;
import pl.parser.nbp.utils.UrlUtil;
import pl.parser.nbp.utils.XmlParser;

public class NbpClient {

	private static final Logger LOGGER = Logger.getLogger(NbpClient.class.getName());

	private String currency;
	private String startTime;
	private String stopTime;
	private List<Double> currencyBidList, currencyAskList;

	public NbpClient(String currency, String startTime, String stopTime)
			throws ClientCreationCurrencyError, ClientCreationDateError {

		setCurrency(currency);
		setDates(startTime, stopTime);

	}

	public void connect() {

		try {
			URL url = new URL(UrlUtil.buildURL(currency, startTime, stopTime));
			URLConnection conn = url.openConnection();
			XmlParser xmlParser = new XmlParser(conn);

			currencyBidList = xmlParser.getListOfSpecificTag("Bid");
			currencyAskList = xmlParser.getListOfSpecificTag("Ask");

		}

		catch (MalformedURLException e) {

			LOGGER.log(Level.SEVERE, "Exception occur", e);
		}

		catch (IOException e) {

			LOGGER.log(Level.SEVERE, "Exception occur", e);
		}

	}

	public void setDates(String startDate, String stopDate) throws ClientCreationDateError {
		if (DateUtil.validateDates(startDate, stopDate)) {
			startTime = startDate;
			stopTime = stopDate;

		} else {
			throw new ClientCreationDateError("date input error");
		}

	}

	public String getCurrency() {
		return currency;
	}

	private void setCurrency(String currency) throws ClientCreationCurrencyError {

		if (CurrencySymbols.contains(currency)) {
			this.currency = currency;
		} else {
			throw new ClientCreationCurrencyError("wrong currency symbol");
		}
	}

	public String getStartTime() {
		return startTime;
	}

	private void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStopTime() {
		return stopTime;
	}

	private void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	public List<Double> getCurrencyBidList() {
		return currencyBidList;
	}

	public List<Double> getCurrencyAskList() {
		return currencyAskList;
	}

}
