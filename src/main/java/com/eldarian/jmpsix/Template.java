package com.eldarian.jmpsix;

import java.util.HashMap;
import java.util.Map;

public class Template {
    private String message;

    private Map<String, String> keyValuePairs;

    public Template() {
        keyValuePairs = new HashMap<>();
    }

    public Template(String expression) {
        String delimiter = "|";
        keyValuePairs = new HashMap<>();
        String[] parts = expression.split(delimiter);
        for (String part : parts) {
            String[] keyValue = part.split(":");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();
                if (key.equalsIgnoreCase("$MSG")) {
                    message = value;
                } else {
                    keyValuePairs.put(key, value);
                }
            }
        }
    }

    public Map<String, String> getKeyValuePairs() {
        return keyValuePairs;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void addKeyValuePair(String key, String value) {
        keyValuePairs.put(key, value);
    }
}
