mport java.io.*;
import java.nio.file.*;

public class FileUtility {

    // Create a new file
    public static void createFile(String filename) {
        try {
            File file = new File(filename);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    // Write content to a file
    public static void writeFile(String filename, String content) {
        try (FileWriter wriiter = new FileWriter(filename)) {
            writer.write(content);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // Read content from a file
    public static void readFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            System.out.println("File content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    // Delete a file
    public static void deleteFile(String filename) {
        try {
            Files.deleteIfExists(Paths.get(filename));
            System.out.println("File deleted: " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while deleting the file.");
            e.printStackTrace();
        }
    }

    // Main method to test the utility
    public static void main(String[] args) {
        String filename = "example.txt";
        String content = "This is a test file.\nJava File Handling Utility.";

        createFile(filename);
        writeFile(filename, content);
        readFile(filename);
        deleteFile(filename);
    }
}
