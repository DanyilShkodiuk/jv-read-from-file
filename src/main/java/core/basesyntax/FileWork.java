package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String TARGET_LETTER = "w";
    private static final String SPLIT_REGEX = "[\\s\\p{Punct}]+";

    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
            String[] words = content.toString().split(SPLIT_REGEX);
            List<String> result = new ArrayList<>();
            for (String word : words) {
                String lowerWord = word.toLowerCase();
                if (lowerWord.startsWith(TARGET_LETTER)) {
                    result.add(lowerWord);
                }
            }
            Collections.sort(result);
            return result.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Cant read the file", e);
        }
    }
}
