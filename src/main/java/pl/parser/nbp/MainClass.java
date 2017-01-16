package pl.parser.nbp;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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

			List<Double> askList = nbpClient.getCurrency().getRates().stream().map(a -> a.getAsk().doubleValue())
					.collect(Collectors.toList());

			List<Double> bidList = nbpClient.getCurrency().getRates().stream().map(b -> b.getBid().doubleValue())
					.collect(Collectors.toList());

			System.out.printf("Average bid: %.4f\n", MathUtil.getAverage(bidList));
			System.out.printf("Standard deviation for ask: %.4f\n", MathUtil.getStdDev(askList));

		} catch (ClientCreationCurrencyError | ClientCreationDateError e) {

			LOGGER.log(Level.WARNING, "Wrong currency code or datas", e);

		} catch (ArrayIndexOutOfBoundsException e) {

			LOGGER.log(Level.SEVERE, "There is no valid number of arguments. The correct number is 3", e);

		}

	}

}
