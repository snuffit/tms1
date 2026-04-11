package main.exception;

/**
 * @author Pstyga Stas
 * @created 11.04.2026
 */
public class WrongLoginException extends RuntimeException{

    public WrongLoginException() {
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
