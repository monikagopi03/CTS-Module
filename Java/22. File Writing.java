
import java.io.*;
import java.util.Scanner;

public class WriteToFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to write to file: ");
        String input = sc.nextLine();
        try (FileWriter fw = new FileWriter("output.txt")) {
            fw.write(input);
            System.out.println("Data written to output.txt");
        } catch (IOException e) {
            System.out.println("File write error: " + e.getMessage());
        }
    }
}
