import xml_parsers.XMLParserController;

public class Main {
    public static void main(String[] args) {
        //Задача 1:
        //Написать программу для парсинга xml документа. Необходимо распарсить xml документ и
        //содержимое тегов line записать в другой документ. Название файла для записи должно
        //состоять из значений тегов и имеет вид: <firstName>_<lastName>_<title>.txt
        XMLParserController.makeTxtFileFromXML("src/main/resources/input/test.xml");
        //Задача *:
        //Дополнительно реализовать следующий функционал: если с консоли введено значение 1
        //- распарсить документ с помощью SAX, если с консоли введено значение 2 - распарсить
        //документ с помощью DOM
    }
}
