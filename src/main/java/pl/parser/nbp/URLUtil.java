package pl.parser.nbp;

public class URLUtil {

	public static String buildURL(String currency, String startTime, String stopTime) {

		StringBuilder s = new StringBuilder();
		s.append("http://api.nbp.pl/api/exchangerates/rates/C/");
		s.append(currency);
		s.append("/");
		s.append(startTime);
		s.append("/");
		s.append(stopTime);
		s.append("/?format=xml");

		return s.toString();

	}

}
