package textTools;

import java.util.HashSet;

/**
 * Class for sorting out the longest word from the source file.
 */
public class TheLongestWord {

    /**
     * For storing the longest words from the source file. Good because it does not store duplicate values.
     */
    HashSet<String> longestWords;
    /**
     * Keeps the longest word length for comparing with the new ones.
     */
    int longestWordLength = 0;

    /**
     * Getter for the longestWords.
     * @return Object array of longest words.
     */
    public Object[] getLongestWords() {
        if (longestWords != null)
            return longestWords.toArray();
        return null;
    }

    /**
     * Checks the length of the word and acts as follows:
     *  if length is shorter the does returns false.
     *  if length is equal then adds it to the list with others.
     *  if longer then starts a new list and adds the word in there.
     * @param word what needs to be checked.
     * @return true if the word was equal/longer or false if shorter. At the moment it is not used.
     */
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
