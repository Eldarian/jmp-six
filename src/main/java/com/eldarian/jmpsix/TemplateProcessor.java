package com.eldarian.jmpsix;

import java.util.HashMap;
import java.util.Map;

public class TemplateProcessor {

    public Map<String, String> getVariableMap() {
        return variableMap;
    }

    public void setVariableMap(Map<String, String> variableMap) {
        this.variableMap = variableMap;
    }

    private Map<String, String> variableMap = new HashMap<>();

    public String processMessage(Template template) throws NullValueException{
        variableMap = template.getKeyValuePairs();
        return processMessage(template.getMessage());
    }

    /**
     * transforms template to message
     * @param template text with placeholders like '#{key}'
     * @return message with replaced placeholders
     */
    public String processMessage(String template) throws NullValueException{
        for(String key : variableMap.keySet()) {
            String keyWithBrackets = "#{" + key + "}";
            int cursor = StringUtils.search(template, keyWithBrackets, 0);;
            while (cursor >= 0) {
                String value = variableMap.get(key);
                if(value == null) {
                    throw new NullValueException();
                }
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
