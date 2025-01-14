package task1;

import java.util.*;

public class ExerciseWithWords {

    private String[] words;

    public ExerciseWithWords(String[] words) {
        this.words = words;
    }

    public void printWordsList() {
        System.out.println(Arrays.toString(words));
    }

    public void uniqueWordsList() {
        HashSet<String> wordSet = new HashSet<>(List.of(words));
        System.out.println(wordSet);
    }

    public void countWord() {
        List<String> example = new ArrayList<>(List.of(words));
        example.sort(String::compareTo);

        while (!example.isEmpty()) {
            if (example.lastIndexOf(example.get(0)) != 0) {
                int lastIndex = example.lastIndexOf(example.get(0));
                System.out.printf("Слово %s встречается: %d раз(а)\n", example.get(0), lastIndex + 1);
                for (int i = 0; i <= lastIndex; i++) {
                    example.remove(i);
                }
            } else {
                System.out.printf("Слово %s встречается: 1 раз\n", example.get(0));
                example.remove(0);
            }
        }
    }
}
