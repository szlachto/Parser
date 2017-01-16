package pl.parser.nbp.utils;

public enum CurrencySymbols {

	USD, EUR, CHF, GBP;

	public static boolean contains(String s) {
		try {
			CurrencySymbols.valueOf(s);
			return true;
		} catch (Exception e) {
			return false;
		}

	}
}
