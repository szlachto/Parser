package parser;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import pl.parser.nbp.utils.MathUtil;

public class CheckAverage {

	@Test
	public void dataChecker() {

		DecimalFormat df = new DecimalFormat("#.####");

		List<Double> list01 = Arrays.asList(4.0, 2.0, 3.0);
		List<Double> list02 = Arrays.asList(4.0);
		List<Double> list03 = Arrays.asList(0.0);

		assertEquals(3.0, Double.valueOf(df.format(MathUtil.getAverage(list01))), 0);
		assertEquals(4.0, Double.valueOf(df.format(MathUtil.getAverage(list02))), 0);
		assertEquals(0.0, Double.valueOf(df.format(MathUtil.getAverage(list03))), 0);

	}

}
