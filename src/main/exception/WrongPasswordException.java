package main.exception;

/**
 * @author Pstyga Stas
 * @created 11.04.2026
 */
public class WrongPasswordException extends RuntimeException{

    public WrongPasswordException() {
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
