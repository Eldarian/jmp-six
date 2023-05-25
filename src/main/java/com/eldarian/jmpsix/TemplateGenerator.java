package com.eldarian.jmpsix;

import java.util.HashMap;
import java.util.Map;

public class TemplateGenerator {

    public Map<String, String> getVariableMap() {
        return variableMap;
    }

    public void setVariableMap(Map<String, String> variableMap) {
        this.variableMap = variableMap;
    }

    private Map<String, String> variableMap = new HashMap<>();

    public String processMessage(String rawMessage) {
        //transforms template to message
        return "";
    }

    public void putVariable(String key, String value) {
        variableMap.put(key, value);
    }
}
