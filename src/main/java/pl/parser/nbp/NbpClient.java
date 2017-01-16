package pl.parser.nbp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

import pl.parser.nbp.currency.Currency;
import pl.parser.nbp.currency.CurrencyParser;

public class NbpClient {

	private static final Logger LOGGER = Logger.getLogger(NbpClient.class.getName());

	private Currency currency;

	public void connect(String urlString) {

		try {

			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();

			CurrencyParser currencyParser = new CurrencyParser(conn);

			currency = currencyParser.getCurrency();

		}

		catch (MalformedURLException e) {

			LOGGER.log(Level.SEVERE, "URL is bad" + urlString, e);
		}

		catch (IOException e) {

			LOGGER.log(Level.SEVERE, "Exception occur", e);
		}

	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
