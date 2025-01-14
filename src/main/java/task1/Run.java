package task1;

import java.util.*;

public class Run {

    public static void main(String[] args) {

        String[] words = new String[]{"Поскакать", "Бурить", "Водород", "Дивертисмент", "Изделие", "Имажинизм", "Овощехранилище", "Подсуетиться", "Предначертание", "Раздуться",
                "Поскакать", "Дивертисмент", "Расстилка", "Водород", "Болтаться", "Имажинизм", "Поскакать", "Инвалюта", "Поскакать", "Водород"};

        ExerciseWithWords ex = new ExerciseWithWords(words);
        ex.printWordsList();
        System.out.println();
        ex.uniqueWordsList();
        System.out.println();
        ex.countWord();

    }

}
