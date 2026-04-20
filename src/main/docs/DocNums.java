package main.docs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;

/**
 * @author Pstyga Stas
 * @created 20.04.2026
 */
public class DocNums {

    private HashSet<DocNum> docNums;
    private static DocNums instance;

    private DocNums(HashSet<DocNum> docNums) {
        this.docNums = docNums;
    }

    public static DocNums getInstance() {
        if (instance == null) {
            instance = new DocNums(loadAllDocuments());
        }
        return instance;
    }

    // Новый метод для перезагрузки из файлов
    public static void reload() {
        instance = new DocNums(loadAllDocuments());
    }

    private static HashSet<DocNum> loadAllDocuments() {
        HashSet<DocNum> docnums = new HashSet<>();
        loadValidReport(docnums);
        loadInvalidReport(docnums);
        return docnums;
    }

    private static void loadValidReport(HashSet<DocNum> docnums) {
        if (Files.exists(Path.of(Constants.DOCNUMS_VALID_PATH))) {
            try (BufferedReader validDocnums = new BufferedReader(new FileReader(Constants.DOCNUMS_VALID_PATH))) {
                String line;
                while ((line = validDocnums.readLine()) != null) {
                    docnums.add(new DocNum(line, true));
                }
            } catch (IOException e) {
                throw new RuntimeException("Ошибка загрузки валидных документов", e);
            }
        }
    }

    private static void loadInvalidReport(HashSet<DocNum> docnums) {
        if (Files.exists(Path.of(Constants.DOCNUMS_INVALID_PATH))) {
            try (BufferedReader invalidDocnums = new BufferedReader(new FileReader(Constants.DOCNUMS_INVALID_PATH))) {
                String line;
                while ((line = invalidDocnums.readLine()) != null) {
                    int delimiterIndex = line.indexOf(DocNum.getDelimiter());
                    docnums.add(
                            new DocNum(line.substring(0, delimiterIndex),
                                    false,
                                    line.substring(delimiterIndex + 3)));
                }
            } catch (IOException e) {
                throw new RuntimeException("Ошибка загрузки невалидных документов", e);
            }
        }
    }

    public void add(DocNum docNum) {
        this.docNums.add(docNum);
    }

    public HashSet<DocNum> get() {
        return this.docNums;
    }
}
