package com.eldarian.jmpsix;

import java.util.HashMap;
import java.util.Map;

public class Template {
    private String message;

    private Map<String, String> keyValuePairs;

    public Template() {
        keyValuePairs = new HashMap<>();
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

    public String getValueForKey(String key) {
        return keyValuePairs.get(key);
    }
}
