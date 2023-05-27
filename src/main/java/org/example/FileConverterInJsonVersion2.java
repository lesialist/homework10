package org.example;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FileConverterInJsonVersion2 {
    public static void main(String[] args) {
        List<User2> userList = new ArrayList<>();

        try (
                BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
        ) {
            String line = "";
            line = reader.readLine();
            String[] valuesName = line.split(" ");
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(" ");
                User2 user=new User2();

                for (int i = 0; i < valuesName.length; i++) {
                    if (valuesName[i].equalsIgnoreCase("name")) {
                        user.setName(values[i]);
                    } else if (valuesName[i].equalsIgnoreCase("age")) {
                        user.setAge(Integer.parseInt(values[i]));
                    } else if (valuesName[i].equalsIgnoreCase("sex")) {
                        user.setSex(values[i]);
                    } else if (valuesName[i].equalsIgnoreCase("isVerified")) {
                        user.setVerified(Boolean.parseBoolean(values[i]));
                    }
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
class User2 {
    private String name;
    private int age;
    private String sex;
    private boolean isVerified;

    public User2() {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.isVerified = isVerified;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", isVerified=" + isVerified +
                '}';
    }
}




