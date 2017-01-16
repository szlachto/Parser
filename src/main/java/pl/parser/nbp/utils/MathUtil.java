package pl.parser.nbp.utils;

import java.util.List;

public class MathUtil {

	public static double getAverage(List<Double> list) {

		return list.stream().mapToDouble(i -> i).average().orElse(0.0);
	}

	public static double getStdDev(List<Double> list) {

		return Math.sqrt(getVariance(list));
	}

	public static double getVariance(List<Double> list) {
		double[] data = list.stream().mapToDouble(d -> d).toArray();
		int size = data.length;
		double mean = getAverage(list);
		double temp = 0;
		for (double a : data)
			temp += (a - mean) * (a - mean);
		return (size != 0) ? (temp / size) : 0;
	}

}
