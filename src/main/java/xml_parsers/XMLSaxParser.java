package xml_parsers;

import org.xml.sax.SAXException;
import xml_parsers.handlers.SonnetHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class XMLSaxParser implements XMLParser{

    SonnetHandler handler = new SonnetHandler();

    public XMLSaxParser(File file) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(file, handler);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String getValueByTagName(String tagName) {
        return switch (tagName) {
            case "lastName" -> handler.getLastName();
            case "firstName" -> handler.getFirstName();
            case "title" -> handler.getTitle();
            default -> throw new IllegalStateException("Unexpected value: " + tagName);
        };
    }

    @Override
    public List<String> getListValuesByTagName(String tagName) {
        return switch (tagName){
            case "line" -> handler.getLines();
            default -> throw new IllegalStateException("Unexpected value: " + tagName);
        };
    }
}
