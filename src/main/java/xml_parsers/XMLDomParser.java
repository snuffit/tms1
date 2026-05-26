package xml_parsers;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import org.w3c.dom.Document;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLDomParser implements XMLParser{


    Document document;

    public XMLDomParser(File file) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            this.document = builder.parse(file);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getValueByTagName(String tagName) {
        return this.document.getElementsByTagName(tagName).item(0).getTextContent();
    }

    @Override
    public List<String> getListValuesByTagName(String tagName) {
        NodeList nodes = document.getElementsByTagName(tagName);
        List<String> list = new ArrayList<>(nodes.getLength());
        for (int i = 0; i < nodes.getLength(); i++) {
            list.add(nodes.item(i).getTextContent());
        }
        return list;
    }
}
