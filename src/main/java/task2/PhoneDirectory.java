package task2;

import javax.swing.plaf.SplitPaneUI;
import java.util.*;

public class PhoneDirectory {
    private HashMap<String, List<Integer>> phoneDirectory = new HashMap<>();

    public void add(String lastname, Integer phones) {
        if (phoneDirectory.containsKey(lastname)) {
            List<Integer> oldNumbers = phoneDirectory.get(lastname);
            oldNumbers.add(phones);
            phoneDirectory.put(lastname, new ArrayList<>(oldNumbers));
        } else {
            phoneDirectory.put(lastname, new ArrayList<>(Arrays.asList(phones)));
        }
    }

    public void get(String lastName) {
        System.out.println(phoneDirectory.get(lastName));
    }

    public void printAll() {
        for (Map.Entry<String, List<Integer>> item : phoneDirectory.entrySet()) {
            System.out.printf("По ключу %s лежит значение: %s\n", item.getKey(), item.getValue());
        }
    }

}
