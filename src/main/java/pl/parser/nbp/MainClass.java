package pl.parser.nbp;

import pl.parser.nbp.NBPClient.ClientCreationCurrencyError;
import pl.parser.nbp.NBPClient.ClientCreationDateError;

public class MainClass {

	public static void main(String[] args) {

		if (args.length == 3) {

			try {

				NBPClient nbpClient = new NBPClient(args[0], args[1], args[2]);
				nbpClient.connect();

				System.out.printf("Average bid: %.4f\n", MathUtil.getAverage(nbpClient.getCurrencyBidList()));
				System.out.printf("Standard deviation for ask: %.4f\n",
						MathUtil.getStdDev(nbpClient.getCurrencyAskList()));

			} catch (ClientCreationCurrencyError e) {

				System.out.println("Cannot proceed; Check the currency input");

			} catch (ClientCreationDateError e) {

				System.out.println("Cannot proceed; Check the date input");
			}

		} else {

			System.out.println(
					"The number of arguments should be 3. The correct argument list is e.g. EUR 2013-01-28 2013-01-31");
		}

	}

}
