package com.eldarian.jmpsix;

public class StringUtils {
    /**
     * Returns first character of appearance in a substring
     * @param message
     * @param substring
     * @return
     */
    public static long search(String message, String substring) {
        int cursor = 0;
        return 0L;
    }

    /**
     * Replaces substring in a string to provided
     * @param originalString String to edit
     * @param substring string to insert instead
     * @param start start point of replacement
     * @param end end point of replacement
     * @return new string
     */
    public static String replace(String originalString, String substring, int start, int end) {
        StringBuilder builder = new StringBuilder(originalString);
        builder.delete(start, end);
        builder.insert(start, substring);
        builder.replace(start, start + substring.length(), substring);
        return builder.toString();
    }
}
