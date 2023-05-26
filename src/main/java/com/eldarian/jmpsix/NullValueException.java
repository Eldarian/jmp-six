package com.eldarian.jmpsix;

public class NullValueException extends Exception {
    public NullValueException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Value is missing";
    }
}
