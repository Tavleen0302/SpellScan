import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
    public static void main(String[] args) {

        BufferedReader reader;
        int counter;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a sentence:\n");
        String input = scanner.nextLine();
        System.out.print("\n");
        String[] original = input.split("[ ?!.]");
        String sentenceLowercase = input.toLowerCase();
        String[] numWords = sentenceLowercase.split("[ ?!.]");
        System.out.println("Spell check your sentence:\n");

        try {
            reader = new BufferedReader(new FileReader("Dictionary.txt"));
            String line = " ";
            ArrayList<String> list = new ArrayList<String>();

            for (int i = 0; i < numWords.length; i++) {
                counter = i + 1;
                while ((line = reader.readLine()) != null) {
                    list.add(line);
                }
                if (list.contains(numWords[i])) {
                    System.out.println(counter + ". " + original[i] + " <valid>");
                } else {
                    System.out.println(counter + ". " + original[i] + " <invalid> ");
                }
            }
        } catch (Exception e) {
            System.out.println("Error, please check file or IO ");
        }
    }
}