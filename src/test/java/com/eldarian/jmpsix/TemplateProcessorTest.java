package com.eldarian.jmpsix;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Tags({
        @Tag("basic"),
        @Tag("exception")
})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TemplateProcessorTest {
    private TemplateProcessor templateProcessor;


    @BeforeEach
    void setUp() {
        templateProcessor = new TemplateProcessor();
    }

    @Tag("basic")
    private static Stream<Arguments> testData() {
        Map<String, String> vars1 = new HashMap<>();
        vars1.put("name", "John");
        vars1.put("age", "30");
        String template1 = "Hello #{name}! Your age is #{age}.";
        String expectedMessage1 = "Hello John! Your age is 30.";

        Map<String, String> vars2 = new HashMap<>();
        vars2.put("city", "London");
        String template2 = "Welcome to #{city}.";
        String expectedMessage2 = "Welcome to London.";

        Map<String, String> vars3 = new HashMap<>();
        vars3.put("name", "John");
        String template3 = "#{name}";
        String expectedMessage3 = "John";

        Map<String, String> vars4 = new HashMap<>();
        vars4.put("key", "value");
        vars4.put("value", "key");
        String template4 = "Hey #{key}! How's your #{value}?";
        String expectedMessage4 = "Hey value! How's your key?";

        Map<String, String> vars5 = new HashMap<>();
        vars5.put("key", "#{value}");
        vars5.put("value", "key");
        String template5 = "Hey #{key}! How's your #{value}?";
        String expectedMessage5 = "Hey #{value}! How's your key?";

        Map<String, String> vars6 = new HashMap<>();
        vars6.put("key", "value");
        vars6.put("value", "key");
        String template6 = "Hey #{key}! Hey #{key}! Hey #{key}! Hey #{key}! Hey #{key}!";
        String expectedMessage6 = "Hey value! Hey value! Hey value! Hey value! Hey value!";

        Map<String, String> vars7 = new HashMap<>();
        String template7 = "Nothing to replace";
        String expectedMessage7 = "Nothing to replace";

        Map<String, String> vars8 = new HashMap<>();
        String template8 = "";
        String expectedMessage8 = "";

        Map<String, String> vars9 = new HashMap<>();
        vars9.put("key", "#{key}");
        vars9.put("value", "key");
        String template9 = "Hey #{key}! Hey #{key}! Hey #{key}! Hey #{key}! Hey #{key}!";
        String expectedMessage9 = "Hey #{key}! Hey #{key}! Hey #{key}! Hey #{key}! Hey #{key}!";

        return Stream.of(
                Arguments.of(vars1, template1, expectedMessage1),
                Arguments.of(vars2, template2, expectedMessage2),
                Arguments.of(vars3, template3, expectedMessage3),
                Arguments.of(vars4, template4, expectedMessage4),
                Arguments.of(vars5, template5, expectedMessage5),
                Arguments.of(vars6, template6, expectedMessage6),
                Arguments.of(vars7, template7, expectedMessage7),
                Arguments.of(vars8, template8, expectedMessage8),
                Arguments.of(vars9, template9, expectedMessage9)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void processMessageTest_Parametrized(Map<String, String> vars, String template, String expectedMessage) throws NullValueException {
        templateProcessor.setVariableMap(vars);
        assertEquals(expectedMessage, templateProcessor.processMessage(template));
    }

    @Tag("basic")
    @Test
    void processMessageTest() throws NullValueException {
        //basic test
        //consumes initial placeholder-value pairs
        //consumes mock text with placeholder
        //replaces all occurences
        templateProcessor.putVariable("key", "value");
        templateProcessor.putVariable("name", "Dmitry");
        assertEquals("Hey value! Nice name! And mine is Dmitry.",
                templateProcessor.processMessage("Hey #{key}! Nice name! And mine is #{name}."));
    }

    @Tag("basic")
    @Test
    void processMessageTemplateTest() throws NullValueException {
        //basic test
        //consumes initial placeholder-value pairs
        //consumes mock text with placeholder
        //replaces all occurences
        Template template = new Template();
        template.setMessage("Hey #{key}! Nice name! And mine is #{name}.");
        template.addKeyValuePair("key", "value");
        template.addKeyValuePair("name", "Dmitry");
        assertEquals("Hey value! Nice name! And mine is Dmitry.",
                templateProcessor.processMessage(template));
    }

    @Tag("exception")
    @Test
    void processMessage_NullValueInMap() {
        templateProcessor.putVariable("name", null);
        NullValueException exception = assertThrows(NullValueException.class,
                () -> templateProcessor.processMessage("Hey #{name}! What's up?"));
        assertEquals("Value is missing", exception.getMessage());
    }
}
