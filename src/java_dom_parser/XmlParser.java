package java_dom_parser;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParser {

	public static void main(String[] args) {
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc=builder.parse("call.xml");
			NodeList methodList=doc.getElementsByTagName("methodCall");
			for(int i=0; i<methodList.getLength(); i++) {
				Node p=methodList.item(i);
				if(p.getNodeType()==Node.ELEMENT_NODE) {
					Element method = (Element) p;
					String id = method.getAttribute("methodName");
					NodeList nameList=method.getChildNodes();
					for(int j=0; j<nameList.getLength(); j++) {
						Node n=nameList.item(j);
						if(n.getNodeType()==Node.ELEMENT_NODE) {
							Element name=(Element) n;
							System.out.println("methodCall" + id + ":" + name.getTagName() + "=" + name.getTextContent());
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
