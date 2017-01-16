package parser;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import pl.parser.nbp.utils.MathUtil;

public class CheckVariance {

	@Test
	public void checkData() {

		DecimalFormat df = new DecimalFormat("#.####");

		List<Double> list01 = Arrays.asList(4.15, 4.20, 4.44);
		List<Double> list02 = Arrays.asList(4.15);
		List<Double> list03 = Arrays.asList(0.0, 4.15);

		assertEquals(0.0160, Double.valueOf(df.format(MathUtil.getVariance(list01))), 0);
		assertEquals(0.0000, Double.valueOf(df.format(MathUtil.getVariance(list02))), 0);
		assertEquals(4.3056, Double.valueOf(df.format(MathUtil.getVariance(list03))), 0);

	}

}
