package pl.parser.nbp.validator;

import pl.parser.nbp.currency.CurrencySymbols;
import pl.parser.nbp.errors.ClientCreationCurrencyError;
import pl.parser.nbp.errors.ClientCreationDateError;

public class InputValidator {

	public boolean validate(String currencyCode, String startDate, String stopDate)
			throws ClientCreationCurrencyError, ClientCreationDateError {

		if (validateDates(startDate, stopDate) && validateCurrency(currencyCode)) {
			return true;
		}

		return false;
	}

	private boolean validateDates(String startDate, String stopDate) throws ClientCreationDateError {

		if (!DateValidator.validateDates(startDate, stopDate)) {
			throw new ClientCreationDateError("Invalid Dates");
		}

		return true;

	}

	private boolean validateCurrency(String currencyCode) throws ClientCreationCurrencyError {

		if (!CurrencySymbols.contains(currencyCode)) {
			throw new ClientCreationCurrencyError("Invalid currency code");
		}

		return true;

	}

}
