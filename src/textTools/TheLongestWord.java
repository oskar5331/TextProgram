package textTools;

import java.util.HashSet;

public class TheLongestWord {

    HashSet<String> longestWords;
    int longestWordLength = 0;

    public Object[] returnLongestWords() {
        return longestWords.toArray();
    }

    public boolean checkWord(String word) {
        if (word.length() < longestWordLength) {
            return false;
        } else if (word.length() > longestWordLength) {
            longestWordLength = word.length();
            longestWords = new HashSet<>();
            longestWords.add(word);
//            System.out.println(word);
        } else {
            longestWords.add(word);
//            System.out.println(word);
        }
        return true;
    }

}
