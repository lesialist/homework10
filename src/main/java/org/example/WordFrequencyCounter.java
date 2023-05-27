package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        HashMap<String, Integer> wordFrequency = new HashMap<>();

        try (
                BufferedReader reader = new BufferedReader(new FileReader("words.txt"));
        ) {
           String line ="";
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
            for(String word:words){
                if (wordFrequency.containsKey(word)){
                    wordFrequency.put(word, wordFrequency.get(word) + 1);
                }
                else {
                    wordFrequency.put(word, 1);
                }
            }
            }
            List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordFrequency.entrySet());
            Collections.sort(entryList, Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));
            LinkedHashMap<String, Integer> sortedHashMap = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entry : entryList) {
                sortedHashMap.put(entry.getKey(), entry.getValue());
            }
            for (Map.Entry<String, Integer> entry : sortedHashMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }


        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
}
