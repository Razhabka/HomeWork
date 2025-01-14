package task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        PhoneDirectory dir = new PhoneDirectory();

        dir.add("Ivanov", 892342);
        dir.add("Petrov", 903523);
        dir.add("Horykov", 2935232);
        dir.add("Jackovich", 834523);
        dir.add("Petrov", 89345);

        dir.get("Petrov");

        dir.printAll();

    }
}
