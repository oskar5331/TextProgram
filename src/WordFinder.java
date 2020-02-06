import textTools.MostCommonWord;
import textTools.TheLongestWord;
import util.ReadIn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordFinder {

    public static final int MIN_COMMON_WORD_LENGTH = 8;
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

    public static void printResults() {
        System.out.println("Longest word(s): ");
        for (Object word :
                longestWord.returnLongestWords()) {
            System.out.println(word);
        }

        System.out.println("Most common word is " + commonWord.getMostCommonWord());
    }
}
