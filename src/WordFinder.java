import textTools.MostCommonWord;
import textTools.TheLongestWord;
import util.ReadIn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordFinder {

    /**
     * Minimum required length to count in the common words list.
     */
    public static final int MIN_COMMON_WORD_LENGTH = 8;

    /**
     * Source file path.
     */
    public static final String FILENAME = "./raamat.txt";

    public static TheLongestWord longestWord = new TheLongestWord();
    public static MostCommonWord commonWord = new MostCommonWord();

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();

        try {
            list = ReadIn.getLines(FILENAME);
        } catch (IOException e) {
            System.out.println(e);
        }


        // goes through each word and calls out functions that are needed with this task.
        for (List<String> stringList : list) {
            for (String word : stringList) {

                longestWord.checkWord(word);
                if (word.length() >= MIN_COMMON_WORD_LENGTH) {
                    commonWord.checkWord(word);
                }

            }
        }
        printResults();

    }

    /**
     * Prints out the results from the data it has collected.
     */
    public static void printResults() {
        System.out.println("Longest word(s): ");
        for (Object word :
                longestWord.getLongestWords()) {
            System.out.println(word);
        }

        System.out.println("Most common word is " + commonWord.getMostCommonWord());
    }
}
