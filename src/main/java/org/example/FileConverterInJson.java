package org.example;

import com.google.gson.Gson;

import java.io.*;
import java.util.*;

public class FileConverterInJson {

    public static void main(String[] args) {


        List<User> userList = new ArrayList<>();

        try (
                BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
        ) {
            String line = "";
            line = reader.readLine();
            String[] valuesName = line.split(" ");
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(" ");
                User user=new User();

                for (int i = 0; i < valuesName.length; i++) {
                    user.addValue(valuesName[i],values[i]);
                }
                userList.add(user);
            }

        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

        Gson gson = new Gson();
        String json = gson.toJson(userList);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user.json"))) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(userList);
    }
}
class User {
    private Map<String, String> user;
    public User() {
        user = new LinkedHashMap<>();;
    }
    public void addValue(String valuesName, String value) {
        user.put(valuesName, value);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : user.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.toString();
    }
}


