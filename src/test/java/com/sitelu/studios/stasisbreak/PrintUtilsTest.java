package com.sitelu.studios.stasisbreak;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrintUtilsTest {

    @Test
    public void testFormatStringBasic() {
        String input = "This is a test string for formatting.";
        int lineLength = 10;
        String expected = "This is a\ntest\nstring for\nformatting.";
        String result = PrintUtils.formatString(input, lineLength);
        assertEquals(expected, result, "The formatted string should match the expected output.");
    }

    @Test
    public void testFormatStringWithEmptyInput() {
        String input = "";
        int lineLength = 10;
        String result = PrintUtils.formatString(input, lineLength);
        assertEquals(input, result, "Empty input should return an empty string.");
    }

    @Test
    public void testFormatStringWithNullInput() {
        String input = null;
        int lineLength = 10;
        String result = PrintUtils.formatString(input, lineLength);
        assertNull(result, "Null input should return null.");
    }

    @Test
    public void testFormatStringWithZeroLineLength() {
        String input = "This is a test string.";
        int lineLength = 0;
        String result = PrintUtils.formatString(input, lineLength);
        assertEquals(input, result, "Zero line length should return the original string.");
    }

    @Test
    public void testFormatStringWithStartStringAndNullInput() {
        String input = null;
        int lineLength = 15;
        String startString = ">> ";
        String result = PrintUtils.formatString(input, lineLength, startString);
        assertNull(result, "Null input should return null.");
    }

    @Test
    public void testFormatStringWithStartStringAndEmptyInput() {
        String input = "";
        int lineLength = 15;
        String startString = ">> ";
        String result = PrintUtils.formatString(input, lineLength, startString);
        assertEquals(input, result, "Empty input should return an empty string.");
    }

    @Test
    public void testPrintFormatted() {
        String input = "This is a test string for formatting.";
        int lineLength = 10;
        // This test is for coverage purposes; manual verification is needed for console
        // output.
        PrintUtils.printFormatted(input, lineLength);
    }

    @Test
    public void testPrintFormattedWithStartString() {
        String input = "This is a test string for formatting.";
        int lineLength = 15;
        String startString = ">> ";
        // This test is for coverage purposes; manual verification is needed for console
        // output.
        PrintUtils.printFormatted(input, lineLength, startString);
    }

    @Test
    public void testPrintBreakWithCharacter() {
        int length = 10;
        char character = '-';
        // This test is for coverage purposes; manual verification is needed for console
        // output.
        PrintUtils.printBreak(length, character);
    }

    @Test
    public void testPrintBreakWithCenteredText() {
        int length = 20;
        char character = '*';
        String text = "Centered";
        // This test is for coverage purposes; manual verification is needed for console
        // output.
        PrintUtils.printBreak(length, character, text);
    }

    @Test
    public void testPrintBreakWithCenteredTextAndNullText() {
        int length = 20;
        char character = '*';
        String text = null;
        // This test is for coverage purposes; manual verification is needed for console
        // output.
        PrintUtils.printBreak(length, character, text);
    }

    @Test
    public void testPrintBreakWithCenteredTextAndEmptyText() {
        int length = 20;
        char character = '*';
        String text = "";
        // This test is for coverage purposes; manual verification is needed for console
        // output.
        PrintUtils.printBreak(length, character, text);
    }
}