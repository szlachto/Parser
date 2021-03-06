package pl.parser.nbp.currency;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CurrencyParser {

	private static final Logger LOGGER = Logger.getLogger(CurrencyParser.class.getName());

	private Document document;

	public CurrencyParser(URLConnection conn) {

		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			document = builder.parse(conn.getInputStream());
		} catch (ParserConfigurationException | SAXException | IOException e) {

			LOGGER.log(Level.WARNING, "Cannot parse xml ", e);

		}

	}

	public Currency getCurrency() {

		Currency currency = new Currency();

		try {

			NodeList nList = document.getElementsByTagName("ExchangeRatesSeries");
			Node node = nList.item(0);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				currency.setCurrrency(eElement.getElementsByTagName("Currency").item(0).getTextContent());
				currency.setCode(eElement.getElementsByTagName("Code").item(0).getTextContent());

			}

			nList = document.getElementsByTagName("Rate");
			List<Rate> rates = new ArrayList<>();

			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Rate rate = new Rate();
					Element eElement = (Element) nNode;

					rate.setAsk(new BigDecimal(eElement.getElementsByTagName("Ask").item(0).getTextContent()));
					rate.setBid(new BigDecimal(eElement.getElementsByTagName("Bid").item(0).getTextContent()));
					rate.setEffectiveDate(eElement.getElementsByTagName("EffectiveDate").item(0).getTextContent());
					rate.setNumber(eElement.getElementsByTagName("No").item(0).getTextContent());
					rates.add(rate);

				}
			}

			currency.setRates(rates);

		} catch (NullPointerException e) {

			LOGGER.log(Level.WARNING, "There is no element by tag name", e);
		}

		return currency;
	}

}
