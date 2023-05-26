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
    void searchWordInText_Success() {
        String text = "My findings of word is important";
        String wordToFind = "word";
        assertEquals(15, StringUtils.search(text, wordToFind, 0));
    }

    @Test
    void searchWordInText_NoOccurences() {
        String text = "My findings of word is important";
        String wordToFind = "weird";
        assertEquals(Integer.MIN_VALUE, StringUtils.search(text, wordToFind, 0));
    }

    @Test
    void searchSecondWordInText() {
        String text = "My findings of word is important, every word waits for it";
        String wordToFind = "word";
        assertEquals(40, StringUtils.search(text, wordToFind, 16));
    }

    @Test
    void searchWordInText_TooBigOffset() {
        String text = "My findings of word is important, every word waits for it";
        String wordToFind = "word";
        assertEquals(Integer.MIN_VALUE, StringUtils.search(text, wordToFind, 1000));
    }
}
