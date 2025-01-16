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
        List<String> temporaryList = new ArrayList<>(List.of(words));
        temporaryList.sort(String::compareTo);

        while (!temporaryList.isEmpty()) {
            if (temporaryList.lastIndexOf(temporaryList.get(0)) != 0) {
                int lastIndexWord = temporaryList.lastIndexOf(temporaryList.get(0));
                System.out.printf("Слово %s встречается: %d раз(а)\n", temporaryList.get(0), lastIndexWord + 1);
                for (int i = 0; i <= lastIndexWord; i++) {
                    temporaryList.remove(i);
                }
            } else {
                System.out.printf("Слово %s встречается: 1 раз\n", temporaryList.get(0));
                temporaryList.remove(0);
            }
        }
    }
}
