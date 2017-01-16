package pl.parser.nbp.currency;

import java.io.IOException;
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

			LOGGER.log(Level.WARNING, "Exception occur", e);

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
			List<Double> ask = new ArrayList<>();
			List<Double> bid = new ArrayList<>();

			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					ask.add(new Double(eElement.getElementsByTagName("Ask").item(0).getTextContent()));
					bid.add(new Double(eElement.getElementsByTagName("Bid").item(0).getTextContent()));
				}
			}

			currency.setAsk(ask);
			currency.setBid(bid);

		} catch (NullPointerException e) {

			LOGGER.log(Level.WARNING, "Exception occur", e);
		}

		return currency;
	}

}
