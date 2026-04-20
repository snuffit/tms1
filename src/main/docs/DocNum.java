package main.docs;

import java.util.Objects;

/**
 * @author Pstyga Stas
 * @created 20.04.2026
 */
public class DocNum {

    private String docnum;
    private boolean isValid;
    private String description;
    private static final String DELIMITER = " - ";

    public DocNum(String docnum, boolean isValid) {
        this(docnum, isValid, null);
    }

    public DocNum(String docnum, boolean isValid, String description) {
        this.docnum = docnum;
        this.isValid = isValid;
        this.description = description;
    }

    public boolean isValid() {
        return isValid;
    }

    public static String getDelimiter() {
        return DELIMITER;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DocNum docNum)) return false;
        return Objects.equals(docnum, docNum.docnum);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(docnum);
    }

    @Override
    public String toString() {
        if (this.description == null || this.description.isEmpty()) {
            return docnum;
        }
        return docnum + DELIMITER + description;
    }
}
