package pl.parser.nbp;

import java.util.logging.Level;
import java.util.logging.Logger;

import pl.parser.nbp.errors.ClientCreationCurrencyError;
import pl.parser.nbp.errors.ClientCreationDateError;
import pl.parser.nbp.utils.MathUtil;

public class MainClass {

	private static final Logger LOGGER = Logger.getLogger(MainClass.class.getName());

	public static void main(String[] args) {

		try {

			NbpClient nbpClient = new NbpClient(args[0], args[1], args[2]);
			nbpClient.connect();

			System.out.printf("Average bid: %.4f\n", MathUtil.getAverage(nbpClient.getCurrencyBidList()));
			System.out.printf("Standard deviation for ask: %.4f\n", MathUtil.getStdDev(nbpClient.getCurrencyAskList()));

		} catch (ClientCreationCurrencyError | ClientCreationDateError e) {

			LOGGER.log(Level.WARNING, "Exception occur", e);

		} catch (ArrayIndexOutOfBoundsException e) {

			LOGGER.log(Level.SEVERE, "Exception occur", e);

		}

	}

}
