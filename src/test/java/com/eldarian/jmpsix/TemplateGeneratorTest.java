package com.eldarian.jmpsix;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemplateGeneratorTest {
    private TemplateGenerator templateGenerator;


    @BeforeEach
    void setUp() {
        templateGenerator = new TemplateGenerator();
    }
    private static Stream<Arguments> testData() {
        Map<String, String> vars = new HashMap<>();
        vars.put("name", "John");
        vars.put("age", "30");
        String template1 = "Hello #{name}! Your age is #{age}.";
        String expectedMessage1 = "Hello John! Your age is 30.";

        Map<String, String> variables2 = new HashMap<>();
        variables2.put("city", "London");
        String template2 = "Welcome to #{city}.";
        String expectedMessage2 = "Welcome to London.";

        return Stream.of(
                Arguments.of(vars, template1, expectedMessage1),
                Arguments.of(variables2, template2, expectedMessage2)
        );
    }
    /*
        test cases:
    note: PH stands for placeholder (like #{key})


    //   Simple success tests (all placeholders in text do have values in a map, values have no PH-like brackets)
    //   1. template contains only one placeholder, no additional text. The result has to contain only value for placeholder
    //   2. template contains one placeholder and some text. The result should have plain text with replaced PH.
    //   3. template contains 3 placeholders and some text. The result should have plain text with replaced PHs.
    //   4. template contains 3 placeholders one by one. The result string has to contain replaced PHs.

    //Plain text tests (no placeholders in a test)
    //   5. template is an empty string. The result should return an empty string without any exceptions.
    //   6. template contains no placeholders, just plain text. The result should be the same

    //Exception tests
    //   7. template contain placeholder that has a NULL value in map. The result should be an exception.

    //Bracket tests:
    //   8. value of PH has brackets #{value}, result should be the text with this #{value} instead PH.
    //   9. There is a #{key}:#{value} and #{value}:key pairs in the map and text like "Hey #{key}! How's your #{value}?".
    //  The result string has to be like Hey #{value}, how's your key? (No double replacement)

    //Encoding tests:
    //  10. Latin-1 character set text should be processed as usual.
     */

    @ParameterizedTest
    @MethodSource("testData")
    void processMessageTest_Parametrized(Map<String, String> vars, String template, String expectedMessage) {
        templateGenerator.setVariableMap(vars);
        assertEquals(expectedMessage, templateGenerator.processMessage(template));
    }


    @Test
    void processMessageTest() {
        //basic test
        //consumes initial placeholder-value pairs
        //consumes mock text with placeholder
        //replaces all occurences
        templateGenerator.putVariable("key", "value");
        templateGenerator.putVariable("name", "Dmitry");
        assertEquals("Hey value! Nice name! And mine is Dmitry.",
                templateGenerator.processMessage("Hey #{key}! Nice name! And mine is #{name}."));
    }
}
