package com.sitelu.studios.stasisbreak;

public class PrintUtils {

    /**
     * Formats string by adding newline at whitespace when the line limit reached
     * specified character limit
     *
     * @param input      string to format
     * @param lineLength maximum number of characters per line
     * @return formatted string with newlines
     */
    public static String formatString(String input, int lineLength) {
        if (input == null || input.isEmpty() || lineLength <= 0) {
            return input;
        }

        StringBuilder formatted = new StringBuilder();
        String[] words = input.split(" ");
        int currentLineLength = 0;

        for (String word : words) {
            if (currentLineLength + word.length() + 1 > lineLength) {
                // add newline if adding the next word exceeds the line length limt
                formatted.append("\n");
                currentLineLength = 0;
            } else if (currentLineLength > 0) {
                // add space between words if not the start of a new line
                formatted.append(" ");
                currentLineLength++;
            }
            formatted.append(word);
            currentLineLength += word.length();
        }

        return formatted.toString();
    }

    /**
     * Prints a formatted string to console
     *
     * @param input      The input string to print
     * @param lineLength The maximum number of characters per line
     */
    public static void printFormatted(String input, int lineLength) {
        System.out.println(formatString(input, lineLength));
    }

    /**
     * Formats string by adding newline at whitespace when the line limit reached &
     * prepends a custom start string
     *
     * @param input       string to format
     * @param lineLength  maximum number of characters per line
     * @param startString the string to prepend at the start of each line
     * @return formatted string with newlines and custom start string
     */
    public static String formatString(String input, int lineLength, String startString) {
        if (input == null || input.isEmpty() || lineLength <= 0 || startString == null) {
            return input;
        }

        StringBuilder formatted = new StringBuilder();
        String[] words = input.split(" ");
        int currentLineLength = startString.length();

        String nextStartString = " ".repeat(startString.length());
        formatted.append(startString); // first line add start string

        for (String word : words) {
            if (currentLineLength + word.length() + 1 > lineLength) {
                // add newline and next start string
                formatted.append("\n").append(nextStartString);
                currentLineLength = nextStartString.length();
            } else if (currentLineLength > nextStartString.length()) {
                // add space between words
                formatted.append(" ");
                currentLineLength++;
            }
            formatted.append(word);
            currentLineLength += word.length();
        }

        return formatted.toString();
    }

    /**
     * Prints a formatted string to console with a custom start string
     *
     * @param input       The input string to print
     * @param lineLength  The maximum number of characters per line
     * @param startString The string to prepend at the start of each line
     */
    public static void printFormatted(String input, int lineLength, String startString) {
        System.out.println(formatString(input, lineLength, startString));
    }

    /**
     * Prints a break line with a specified character
     *
     * @param length    The length of the break line
     * @param character The character to use for the break line
     */
    public static void printBreak(int length, char character) {
        System.out.println(String.valueOf(character).repeat(length));
    }

    /**
     * Prints a break line with centered text
     *
     * @param text      The text to center
     * @param length    The total length of the break line
     * @param character The character to use for padding
     */
    public static void printBreak(int length, char character, String text) {
        if (text == null || text.isEmpty()) {
            printBreak(length, character);
            return;
        }

        int padding = ((length - text.length()) / 2) - 1;
        if (padding > 0) {
            System.out.print(String.valueOf(character).repeat(padding));
        }
        System.out.print(" " + text + " ");
        if (padding > 0) {
            System.out.println(String.valueOf(character).repeat(padding));
        }
    }
}
