package xml_parsers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class XMLParserController {



    public static void makeTxtFileFromXML(String file) {
        XMLParser parser = chooseParserType(new File(file));
        String fileName = String.format("%s_%s_%s.txt",
                parser.getValueByTagName("firstName"),
                parser.getValueByTagName("lastName"),
                parser.getValueByTagName("title"));
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(String.format("src/main/resources/output/%s", fileName)))) {
            Iterator<String> iterator = parser.getListValuesByTagName("line").iterator();
            while (iterator.hasNext()) {
                bufferedWriter.write(iterator.next());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Не удалось сконвертировать файл");
            throw new RuntimeException(e);
        }
        System.out.println("Файл успешно сконвертирован");
    }

    private static XMLParser chooseParserType(File file) {
        try(Scanner input = new Scanner(System.in)) {
            System.out.println("Как вы хотите спарсить файл? \n" +
                    "1 - с помощью SAX \n" +
                    "2 - с помощью DOM");
            return switch (input.nextInt()){
                case 1 -> new XMLSaxParser(file);
                case 2 -> new XMLDomParser(file);
                default -> throw new IllegalStateException("Unexpected value: " + input.nextInt());
            };
        }
    }

}