package parser;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import pl.parser.nbp.MathUtil;

public class CheckAverage {

	@Test
	public void DataChecker() {
		ArrayList<Double> list = new ArrayList<>(Arrays.asList(4.0, 2.0, 3.0));

		double avg = MathUtil.getAverage(list);
		assertEquals(3.0, avg, 0);

	}

}
