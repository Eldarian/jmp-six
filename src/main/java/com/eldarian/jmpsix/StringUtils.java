package com.eldarian.jmpsix;

public class StringUtils {
    /**
     * Returns first character of appearance in a substring
     * @param message the original string to search in
     * @param substring the string to search for
     * @param offset the starting offset of the subregion in the original string
     * @return index of first occurrence of the word or Integer.MIN_VALUE if there is no such string or
     * the offset is incorrect
     */
    public static int search(String message, String substring, int offset) {
        if (offset < 0) return Integer.MIN_VALUE;
        for(int i = offset; i < message.length() - substring.length() + 1; i++) {
//            for(int j = 0; j < substring.length(); j++) {
                if(message.regionMatches(i, substring, 0, substring.length())) {
                    return i;
                }

//                if(j == substring.length() - 1) {
//                    return i;
//                }
//            }
        }
        return Integer.MIN_VALUE;
    }

    /**
     * Replaces substring in a string to provided
     * @param originalString String to edit
     * @param substring string to insert instead
     * @param start start point of replacement
     * @param end end point of replacement, exclusive
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
