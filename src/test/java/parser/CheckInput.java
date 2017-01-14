package parser;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import pl.parser.nbp.Util;

public class CheckInput {

	@Test
	public void DataChecker() {

		List<InputData> input = CSVReader.reader();
		input.add(new InputData("EUR", "2016-10-10", "2016-01-01"));

		input.stream().forEach(s -> assertTrue(Util.checkDate(s.getCurrency())));

	}

}
