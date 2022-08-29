package txtToJson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UsersList {
    public static Gson gson = (new GsonBuilder()).create();

    public UsersList() {
    }

    public static String userToJson(User user) {
        return gson.toJson(user);
    }

    public static void main(String[] args) {
        String outputFileName = getString();
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
                File file = new File("usersList.cvs");
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] values = line.split(",");
                    User user = new User(values[0], values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]));
                    String json = userToJson(user);
                    writer.write(json + "\n");
                }

                bufferedReader.close();

            } catch (IOException e) {
                throw new RuntimeException(e);

            }
        } finally {
            System.out.println("Файл создан, пожалуйста, проверьте JsonList. Спасибо.");
        }
    }

    private static String getString() {
        String outputFileName = "jsonList.cvs";
        return outputFileName;
    }
}

