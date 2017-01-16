package pl.parser.nbp.utils;

import pl.parser.nbp.currency.CurrencySymbols;
import pl.parser.nbp.errors.ClientCreationCurrencyError;
import pl.parser.nbp.errors.ClientCreationDateError;

public class InputValidator {

	private String currencyCode;
	private String startDate;
	private String stopDate;

	public InputValidator(String currencyCode, String startDate, String stopDate) {

		this.currencyCode = currencyCode;
		this.startDate = startDate;
		this.stopDate = stopDate;
	}

	public boolean validate() throws ClientCreationCurrencyError, ClientCreationDateError {

		if (validateDates() && validateCurrency()) {
			return true;
		}

		return false;
	}

	private boolean validateDates() throws ClientCreationDateError {

		if (!DateValidator.validateDates(startDate, stopDate)) {
			throw new ClientCreationDateError("Invalid Dates");
		}

		return true;

	}

	private boolean validateCurrency() throws ClientCreationCurrencyError {

		if (!CurrencySymbols.contains(currencyCode)) {
			throw new ClientCreationCurrencyError("Invalid currency code");
		}

		return true;

	}

}
