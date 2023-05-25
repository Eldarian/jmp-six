package com.eldarian.jmpsix;

import org.junit.jupiter.api.Test;

public class TemplateGeneratorTest {

    private TemplateGenerator templateGenerator;
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

    @Test
    void processMessageTest() {
        //basic test
        //consumes initial placeholder-value pairs
        //consumes mock text with placeholder
        //replaces all occurences
    }
}
