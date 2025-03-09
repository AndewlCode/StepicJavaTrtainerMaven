package org.example;

import com.google.gson.Gson;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> tags = readInput();
        HashSet<String> stringHashSet = new HashSet<>(tags);
        List<String> uniqueData = new ArrayList<>(stringHashSet.stream().toList());
        Collections.sort(uniqueData);
        String result = String.join(", ", uniqueData);
        System.out.println(result);
    }


    public static List<String> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input;
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
            Gson gson = new Gson();
            String[] dataArray = gson.fromJson(input, String[].class);
            return Arrays.asList(dataArray);
        }
        scanner.close();
        return null;
    }
}