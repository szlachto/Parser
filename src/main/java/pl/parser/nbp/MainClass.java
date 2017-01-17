package pl.parser.nbp;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import pl.parser.nbp.errors.ClientCreationCurrencyError;
import pl.parser.nbp.errors.ClientCreationDateError;
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

			DescriptiveStatistics dsAsk = new DescriptiveStatistics(
					nbpClient.getCurrency().getRates().stream().mapToDouble(b -> b.getAsk().doubleValue()).toArray());
			DescriptiveStatistics dsBid = new DescriptiveStatistics(
					nbpClient.getCurrency().getRates().stream().mapToDouble(b -> b.getBid().doubleValue()).toArray());

			System.out.printf("Standard deviation for ask: %.4f\n", dsAsk.getStandardDeviation());
			System.out.printf("Average bid: %.4f\n", dsBid.getMean());

		} catch (ClientCreationCurrencyError | ClientCreationDateError e) {

			LOGGER.log(Level.WARNING, "Wrong currency code or datas", e);

		} catch (ArrayIndexOutOfBoundsException e) {

			LOGGER.log(Level.SEVERE, "There is no valid number of arguments. The correct number is 3", e);

		}

	}

}
