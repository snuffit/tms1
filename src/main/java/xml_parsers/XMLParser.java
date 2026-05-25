package xml_parsers;

import java.util.List;

public interface XMLParser {

    String getValueByTagName(String tagName);
    List<String> getListValuesByTagName(String tagName);
}
