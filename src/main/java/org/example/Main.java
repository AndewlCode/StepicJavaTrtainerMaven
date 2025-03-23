package org.example;

import com.google.gson.Gson;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> tags = readInput();
        if (tags == null || tags.isEmpty()) {
            System.out.println("No valid input provided.");
            return;
        }

        // Use a HashMap to count occurrences of each tag
        Map<String, Integer> tagCounts = new HashMap<>();
        for (String tag : tags) {
            tagCounts.put(tag, tagCounts.getOrDefault(tag, 0) + 1);
        }

        // Build the result string
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : tagCounts.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append(", ");
        }

        // Remove the trailing ", " if the string is not empty
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 2);
        }

        String result = stringBuilder.toString();
        System.out.println(result);
    }

    public static List<String> readInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                Gson gson = new Gson();
                String[] dataArray = gson.fromJson(input, String[].class);
                return Arrays.asList(dataArray);
            }
        } catch (Exception e) {
            System.err.println("Error reading input: " + e.getMessage());
        }
        return null;
    }
}