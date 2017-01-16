package pl.parser.nbp.utils;

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

public class XmlParser {

	private static final Logger LOGGER = Logger.getLogger(XmlParser.class.getName());

	private Document document;

	public XmlParser(URLConnection conn) {

		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			document = builder.parse(conn.getInputStream());
		} catch (ParserConfigurationException | SAXException | IOException e) {

			LOGGER.log(Level.WARNING, "Exception occur", e);

		}

	}

	public List<Double> getListOfSpecificTag(String tag) {

		List<Double> list = new ArrayList<>();

		try {
			NodeList nList = document.getElementsByTagName("Rate");

			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					list.add(new Double(eElement.getElementsByTagName(tag).item(0).getTextContent()));
				}
			}
		} catch (NullPointerException e) {

			LOGGER.log(Level.WARNING, "Exception occur", e);
		}

		return list;
	}

}
