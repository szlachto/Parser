package pl.parser.nbp.utils;

public class UrlUtil {

	public static String buildURL(String currency, String startTime, String stopTime) {

		StringBuilder s = new StringBuilder();

		s.append("http://api.nbp.pl/api/exchangerates/rates/C/").append(currency).append("/").append(startTime)
				.append("/").append(stopTime).append("/?format=xml");

		return s.toString();

	}

}
