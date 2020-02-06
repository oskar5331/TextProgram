package textTools;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostCommonWord {

    HashMap<String, Integer> commonMap = new HashMap<>();

    public String getMostCommonWord() {
        List<String> sortedList = commonMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return sortedList.get(0);
    }

    public void checkWord(String word) {
        if (commonMap.containsKey(word)) {
            Integer temp = commonMap.get(word);
            commonMap.put(word, temp + 1);
        } else {
            commonMap.put(word, 1);
        }
    }
}
