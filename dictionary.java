package Dictionary;

//Imports
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class dictionary {
    public static void main(String[] args) throws Exception {
        ArrayList<String> dictionaryWordsArray = new ArrayList<String>();
        ArrayList<String> userWordsArray = new ArrayList<String>();
        BufferedReader inputStream = null;
        String dictionaryLine = null;
        int count = 1; //track number of words in sentence 

        //Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Spelling Checker\nThis program will validate each word in a sentence.\nEnter your sentence:");
        String sentence = scanner.nextLine(); 
        StringTokenizer sentenceTokens = new StringTokenizer(sentence);
        System.out.println();
        scanner.close();
        //Store words in an ArrayList
        do{
            userWordsArray.add(sentenceTokens.nextToken());
        } while(sentenceTokens.hasMoreTokens());
        try{
            inputStream = new BufferedReader(new FileReader("C:\\Users\\ursod\\Desktop\\Dictionary.txt"));
            do{
                dictionaryLine = inputStream.readLine(); 
                dictionaryWordsArray.add(dictionaryLine); 
            } while(dictionaryLine != null);
            System.out.println("Spell check of your sentence");
            for(String word : userWordsArray) { //Check each word/index in array 
                if(dictionaryWordsArray.contains(word.toLowerCase())) { //validate word
                    System.out.println(count + ") " + word + " <valid>");
                    count++;
                } else {
                    System.out.println(count + ") " + word + " <invalid>");
                    count++;
                }
            }
        } catch(FileNotFoundException exception) {
            System.out.println("An error occurred while opening the file");
        } catch(Exception exception) {
            System.out.println("An error has occured.");
            exception.printStackTrace();
        } finally {
            if(inputStream != null) {
                inputStream.close();
            }
        }
    }
}
