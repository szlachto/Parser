package pl.parser.nbp;

import java.util.ArrayList;

public class MathUtil {

	public static boolean checkDate(String date) {
		return false;
	}

	public static double getAverage(ArrayList<Double> list) {

		return list.stream().mapToDouble(i -> i).average().orElse(0.0);
	}

	public static double getStdDev(ArrayList<Double> list) {

		return Math.sqrt(getVariance(list));
	}

	static double getVariance(ArrayList<Double> list) {
		double[] data = list.stream().mapToDouble(d -> d).toArray();
		int size = data.length;
		double mean = getMean(data, size);
		double temp = 0;
		for (double a : data)
			temp += (a - mean) * (a - mean);
		return (size != 0) ? (temp / size) : 0;
	}

	static double getMean(double[] data, int size) {
		double sum = 0.0;
		for (double a : data)
			sum += a;
		return (size != 0) ? (sum / size) : 0;
	}

}
