package parser;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import pl.parser.nbp.utils.MathUtil;

public class CheckStd {

	@Test
	public void dataChecker() {
		ArrayList<Double> list = new ArrayList<>(Arrays.asList(4.0, 2.0, 3.0));

		double avg = MathUtil.getStdDev(list);
		assertEquals(3.0, avg, 0);

	}

}
