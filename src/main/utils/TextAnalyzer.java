package main.utils;

import main.docs.Constants;
import main.docs.DocNum;
import main.docs.DocNums;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pstyga Stas
 * @created 20.04.2026
 */
public class TextAnalyzer {

    public static void extractBiggestWord(String path) {
        String content = getStringFromFile(path);
        String biggestWord = getBiggestWord(content);
        writeStrToFile(biggestWord, Constants.OUTPUT_PATH);
    }

    public static void extractDocNum(String path) {

        DocNums.reload();
        deserializeReport(path);
        serializeReports();
    }

    private static void serializeReports() {
        try (BufferedWriter fileValid = new BufferedWriter(new FileWriter(Constants.DOCNUMS_VALID_PATH));
             BufferedWriter fileInvalid = new BufferedWriter(new FileWriter(Constants.DOCNUMS_INVALID_PATH))) {
            for (DocNum docNum : DocNums.getInstance().get()) {
                if(docNum.isValid()) {
                    fileValid.write(docNum.toString());
                    fileValid.newLine();
                } else {
                    fileInvalid.write(docNum.toString());
                    fileInvalid.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка сохранения отчётов", e);
        }
    }

    private static void deserializeReport(String path) {
        for (String docnum : getStringListFromFile(path)) {
            StringBuilder description = new StringBuilder("");
            boolean isValid = true;
            if (!docnum.startsWith("docnum") && !docnum.startsWith("contract")) {
                isValid = false;
                description.append("Документ не начинается с docnum или contract; ");
            }
            if (docnum.length() != 15) {
                isValid = false;
                description.append("Длина документа не равна 15;");
            }
            DocNums.getInstance().add(new DocNum(docnum, isValid, description.toString()));
        }
    }

    private static List<String> getStringListFromFile(String path) {
        List<String> list = new ArrayList<>();
        try (BufferedReader fileIn = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = fileIn.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + path, e);
        }
        moveFileToArchive(Path.of(path));
        return list;
    }

    private static String getStringFromFile(String path) {
        StringBuilder str = new StringBuilder();
        try (BufferedReader fileIn = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = fileIn.readLine()) != null) {
                str.append(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + path, e);
        }
        moveFileToArchive(Path.of(path));
        return str.toString();
    }

    private static void moveFileToArchive(Path sourcePath) {
        try {
            Files.move(
                    sourcePath,
                    Path.of(Constants.ARCHIVE_PATH + sourcePath.getFileName()),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка перемещения файла в архив: " + sourcePath, e);
        }
    }

    private static String getBiggestWord(String str) {
        String[] words = str.split("[\\s\\p{Punct}]+");
        int indexOfBiggestWord = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > words[indexOfBiggestWord].length()) {
                indexOfBiggestWord = i;
            }
        }
        return words[indexOfBiggestWord];
    }

    private static void writeStrToFile(String str, String path) {
        try (BufferedWriter fileOut = new BufferedWriter(new FileWriter(path))) {
            fileOut.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
