package Ex_02_json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GsonTest {
    public static void main(String[] args) throws IOException {
        File file = new File("userFile.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(fileInputStream);

        List<User> userList = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            String regex = "^\\D+\\s\\d+";

            if (string.matches(regex)) {
                String[] userString = string.split(" ");
                int userAge = Integer.parseInt(userString[1]);

                User user = new User(userString[0], userAge);
                userList.add(user);
            }
        }
        fileInputStream.close();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(userList);

        System.out.println(json);

        File newFile = new File("user.json");
        try (FileWriter writer = new FileWriter(newFile)){
            writer.write(json);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
