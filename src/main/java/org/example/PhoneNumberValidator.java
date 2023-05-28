package org.example;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhoneNumberValidator {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                Pattern pattern1 = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}");
                Pattern pattern2 = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
                Matcher matcher1 = pattern1.matcher(line);
                Matcher matcher2 = pattern2.matcher(line);
                if (matcher1.matches() || matcher2.matches()) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
