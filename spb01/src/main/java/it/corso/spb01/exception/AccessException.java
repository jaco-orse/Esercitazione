package it.corso.spb01.exception;

public class AccessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AccessException(String msg) {
        super(msg);
    }
}