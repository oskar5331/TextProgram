package textTools;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class for sorting out the most common word from the source file.
 */
public class MostCommonWord {

    /**
     * For storing all the words and how much they have occurred.
     * Words themselves act as a key and value is the number of appearance.
     */
    HashMap<String, Integer> commonMap = new HashMap<>();

    /**
     * Getter for commonMap.
     * @return String of the most common word.
     */
    public String getMostCommonWord() {
        List<String> sortedList = commonMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return sortedList.get(0);
    }

    /**
     * Checks if the word is registered. If it is then it will increase the value by one.
     * If not then it adds new word with value of 1.
     * @param word what needs to be checked.
     * @return true when the word is new and false if it has appeared before. Not used at the moment.
     */
    public boolean checkWord(String word) {
        if (commonMap.containsKey(word)) {
            Integer temp = commonMap.get(word);
            commonMap.put(word, temp + 1);
            return false;
        } else {
            commonMap.put(word, 1);
            return true;
        }
    }
}
