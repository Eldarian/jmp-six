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

    /**
     * transforms template to message
     * @param template text with placeholders like '#{key}'
     * @return message with replaced placeholders
     */
    public String processMessage(String template) {
        //TODO - prevent replacement of past values that are like keys
        for(String key : variableMap.keySet()) {
            String keyWithBrackets = "#{" + key + "}";
            int cursor = StringUtils.search(template, keyWithBrackets, 0);;
            while (cursor >= 0) {
                String value = variableMap.get(key);
                template = StringUtils.replace(template, value, cursor, cursor + keyWithBrackets.length());
                cursor = StringUtils.search(template, keyWithBrackets, cursor + 1);
            }
        }
        return template;
    }

    public void putVariable(String key, String value) {
        variableMap.put(key, value);
    }
}
