
import java.util.*;
import java.io.*;

/**
 *Kade Tambo
 * C202
 * Assignment 4
 */
public class A4Test {

 /**
     *This method outs puts the results for MyLinkedList methods. 
     * It displaying the averages and comparison of words found and words not found
     */
    public static void main(String[] args) {

        long WordsFound = 0;
       long WordsNotFound = 0;
        long ComparisonsofWordsFound = 0;
      long ComparisonsofWordsNotFound = 0;
        String wordToBeSearched = "1";
        int i = 0;
        int[] count = new int[1];

        MyLinkedList[] list = new MyLinkedList[26];
        for (i = 0; i < list.length; i++) {
            list[i] = new MyLinkedList<String>();
        }

        try {
            File file = new File("random_dictionary.txt");
            Scanner f = new Scanner(file);
            while (f.hasNext() != false) {
                String word = f.next();
                word = word.toLowerCase();
                list[word.charAt(0) - 97].add(word);
            }
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        try {
            File file = new File("oliver.txt");
            Scanner f = new Scanner(file);
            while (f.hasNext() == true) {
                String word = f.next();
                wordToBeSearched = word.toLowerCase();
                wordToBeSearched = wordToBeSearched.replaceAll("[^A-Za-z]", "");
                if (!wordToBeSearched.isEmpty()) {
                    if (list[wordToBeSearched.charAt(0) - 97].contains(wordToBeSearched, count)) {
                        WordsFound++;
                        ComparisonsofWordsFound += count[0];
                    } else {
                        WordsNotFound++;
                        ComparisonsofWordsNotFound += count[0];
                    }
                }
            }
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        int AverageComparisonsofWordsFound = (int)(ComparisonsofWordsFound / WordsFound);
        int AverageComparisonofWordsNotFound = (int)(ComparisonsofWordsNotFound / WordsNotFound);
        System.out.println("The amount of words found: " + WordsFound);
        System.out.println("The amount of comparisons of words found: " + ComparisonsofWordsFound);
        System.out.println("The amount of words not found: " + WordsNotFound);
        System.out.println("The amount of comparisons of words not found: " + ComparisonsofWordsNotFound);
        System.out.println("The average amount of words found to comparisons of words: "
               + AverageComparisonsofWordsFound);
        System.out.println("The average amount of words not found to comparisons of words: "
               + AverageComparisonofWordsNotFound);
    }
}