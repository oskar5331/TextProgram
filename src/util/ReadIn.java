package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadIn {

    private static final int AsciiMin = 96;
    private static final int AsciiMax = 123;

    /**
     * Reads in the lines from the source file.
     * @param fileName path to source file.
     * @return List of all the words in rows, separated from each other.
     */
    public static List<List<String>> getLines(String fileName) throws IOException
    {
        File file = new File(fileName);

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        List<List<String>> list = new ArrayList<>();

        String line;
        while((line = br.readLine()) != null)
        {

            if (line.length() == 0)
                continue;

            list.add(filterNonChar(line));
        }
        br.close();
        fr.close();
        return list;
    }

    /**
     * Filters out all the separators (including spaces).
     * @param line one line from source file.
     * @return List of separated words.
     */
    private static List<String> filterNonChar(String line) {
        line = line.toLowerCase();

        List<String> words = new ArrayList<>();
        int startIndex = 0;
        for (int i = 0; i < line.length(); i++) {
            int c = line.charAt(i);
            if (c < AsciiMin || c > AsciiMax) {
                String temp = line.substring(startIndex, i);
                if (temp.length() != 0) {
//                    System.out.println(temp);
                    words.add(temp);
                }
                startIndex = i + 1;
            }
        }
        return words;
    }

}
