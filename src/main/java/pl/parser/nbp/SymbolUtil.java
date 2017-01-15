package pl.parser.nbp;

import java.util.Arrays;
import java.util.HashSet;

public class SymbolUtil {

	final static private HashSet<String> SYMBOLS = new HashSet<String>(Arrays.asList("USD", "EUR", "CHF", "GBP"));

	public static boolean contains(String s) {

		return SYMBOLS.contains(s);
	}

}
