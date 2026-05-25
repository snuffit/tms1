package xml_parsers.handlers;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class SonnetHandler extends DefaultHandler {
    private String currentTag;
    private StringBuilder value = new StringBuilder();

    private String lastName;
    private String firstName;
    private String title;
    private List<String> lines = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentTag = qName;
        value.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        value.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case "lastName":
                lastName = value.toString().trim();
                break;
            case "firstName":
                firstName = value.toString().trim();
                break;
            case "title":
                title = value.toString().trim();
                break;
            case "line":
                lines.add(value.toString().trim());
                break;
        }
    }

    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getTitle() { return title; }
    public List<String> getLines() { return lines; }
}
