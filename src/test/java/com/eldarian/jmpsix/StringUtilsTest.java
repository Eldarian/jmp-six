package com.eldarian.jmpsix;

import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilsTest {

    //TODO make a tests where wordToReplace length <= replacement and some borders like empty strings
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

    @Test
    void searchWordInText_Latin1() {
        String original = "My findings of word is important, every word waits for it";
        String text = new String(original.getBytes(), StandardCharsets.ISO_8859_1);
        String wordToFind = "word";
        assertEquals(Integer.MIN_VALUE, StringUtils.search(text, wordToFind, 1000));
    }
}
