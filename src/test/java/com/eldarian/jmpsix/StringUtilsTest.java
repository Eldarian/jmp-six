package com.eldarian.jmpsix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilsTest {
    @Test
    void replaceWordInText() {
        String text = "I want to replace boredom to new word";
        String wordToReplace = "boredom";
        String replacement = "fun";
        String result = StringUtils.replace(text, replacement, 18, 18 + wordToReplace.length());
        assertEquals("I want to replace fun to new word", result);
    }

    @Test
    void searchWordInText() {
        String text = "My findings of word is important";
        String wordToFind = "word";
        assertEquals(11, StringUtils.search(text, wordToFind));
    }
}
