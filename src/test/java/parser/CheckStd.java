package parser;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import pl.parser.nbp.utils.MathUtil;

public class CheckStd {

	@Test
	public void dataChecker() {

		DecimalFormat df = new DecimalFormat("#.####");

		List<Double> list01 = Arrays.asList(4.15, 4.20, 4.44);
		List<Double> list02 = Arrays.asList(4.15);
		List<Double> list03 = Arrays.asList(0.0, 4.15);

		assertEquals(0.1266, Double.valueOf(df.format(MathUtil.getStdDev(list01))), 0);
		assertEquals(0.0000, Double.valueOf(df.format(MathUtil.getStdDev(list02))), 0);
		assertEquals(2.075, Double.valueOf(df.format(MathUtil.getStdDev(list03))), 0);

	}

}
