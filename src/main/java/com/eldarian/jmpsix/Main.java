package com.eldarian.jmpsix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Messenger messenger;

    public static void main(String[] args) {
        // Check if console mode is specified
        if (args.length == 0) {
            runConsoleMode();
        } if (args.length == 2) {
            String inputFile = args[0];
            String outputFile = args[1];
            runFileMode(inputFile, outputFile);
        } else {
            System.out.println("Invalid mode. Please run the application with input and output file names as parameters.");
        }
    }


    public static void runConsoleMode() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter key-value pairs for placeholders (format: key1=value1 key2=value2 ...):");
        String input = scanner.nextLine();

        // Process the input and extract key-value pairs
        String[] keyValuePairs = input.split(" ");
        Map<String, String> variables = new HashMap<>();
        for (String pair : keyValuePairs) {
            String[] parts = pair.split("=");
            if (parts.length == 2) {
                String key = parts[0];
                String value = parts[1];
                variables.put(key, value);
            } else {
                System.out.println("Invalid input format. Please provide key-value pairs in the correct format.");
                return;
            }
        }
        System.out.println("Enter the message:");
        String message = scanner.nextLine();

        TemplateProcessor templateProcessor = new TemplateProcessor();
        templateProcessor.setVariableMap(variables);


        scanner.close();

        try {
            System.out.println(templateProcessor.processMessage(message));
        } catch (NullValueException e) {
            System.out.println(e.getMessage());
        }
    }


    private static void runFileMode(String inputFile, String outputFile) {
        try (Scanner scanner = new Scanner(new File(inputFile));
             PrintWriter writer = new PrintWriter(new File(outputFile))) {
            while (scanner.hasNextLine()) {
                String expression = scanner.nextLine();

                // Process the expression and write the result to the output file
                String result = processExpression(expression);
                writer.println("Expression: " + expression);
                writer.println("Result: " + result);
                writer.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static String processExpression(String expression) {
        Template template = new Template(expression);
        String message = messenger.sendMessage("homework", "karpau.aliaksei@email.com", template);

        return message;
    }
}
