package com.eldarian.jmpsix;

public class NullValueException extends Exception {
    public NullValueException() {
        super();
    }

    public NullValueException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Value is missing";
    }
}
