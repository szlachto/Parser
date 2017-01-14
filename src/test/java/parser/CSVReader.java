package parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

	public static ArrayList<InputData> reader() {

		ArrayList<InputData> inputList = new ArrayList<>();
		String csvFile = "src/test/resources/InputTest.csv";
		String line;
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] input = line.split(cvsSplitBy, -1);
				InputData in = new InputData(input[0], input[1], input[2]);
				inputList.add(in);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return inputList;

	}

}
