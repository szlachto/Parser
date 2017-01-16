package parser;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import pl.parser.nbp.utils.MathUtil;

public class CheckAverage {

	@Test
	public void dataChecker() {
		List<Double> list = Arrays.asList(4.0, 2.0, 3.0);

		double avg = MathUtil.getAverage(list);
		assertEquals(3.0, avg, 0);

	}

}
