package pl.parser.nbp;

import java.io.IOException;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser {

	private Document document;

	public XMLParser(URLConnection conn) {

		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			document = builder.parse(conn.getInputStream());
		} catch (ParserConfigurationException | SAXException | IOException e) {

			System.out.println("Not data found");

		}

	}

	public ArrayList<Double> getListOfSpecificTag(String tag) {

		ArrayList<Double> list = new ArrayList<Double>();

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
			System.out.println("empty list");
		}

		return list;
	}

}
