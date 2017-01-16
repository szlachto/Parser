package parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pl.parser.nbp.utils.MathUtil;

public class CheckMean {

	@Test
	public void checkData() {

		double[] data = { 2.0, 1.0, 3.0 };

		double avg = MathUtil.getMean(data, data.length);
		assertEquals(2.0, avg, 0);

	}

}
