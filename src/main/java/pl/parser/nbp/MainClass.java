package pl.parser.nbp;

import java.util.logging.Level;
import java.util.logging.Logger;

import pl.parser.nbp.errors.ClientCreationCurrencyError;
import pl.parser.nbp.errors.ClientCreationDateError;
import pl.parser.nbp.utils.MathUtil;
import pl.parser.nbp.utils.UrlCreator;
import pl.parser.nbp.validator.InputValidator;

public class MainClass {

	private static final Logger LOGGER = Logger.getLogger(MainClass.class.getName());

	public static void main(String[] args) {

		try {

			String code = args[0];
			String startDate = args[1];
			String stopDate = args[2];

			InputValidator inputValidator = new InputValidator();
			inputValidator.validate(code, startDate, stopDate);

			String url = UrlCreator.buildURL(code, startDate, stopDate);

			NbpClient nbpClient = new NbpClient();
			nbpClient.connect(url);

			System.out.printf("Average bid: %.4f\n", MathUtil.getAverage(nbpClient.getCurrency().getBid()));
			System.out.printf("Standard deviation for ask: %.4f\n",
					MathUtil.getStdDev(nbpClient.getCurrency().getAsk()));

		} catch (ClientCreationCurrencyError | ClientCreationDateError e) {

			LOGGER.log(Level.WARNING, "Exception occur", e);

		} catch (ArrayIndexOutOfBoundsException e) {

			LOGGER.log(Level.SEVERE, "Exception occur", e);

		}

	}

}
