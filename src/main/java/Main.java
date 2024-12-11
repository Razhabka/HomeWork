import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        printTree();
        checkSumSing();
        printColor();
        compareNumbers();
        System.out.println(withinNumbers(10, 7) + "\n");
        positiveOrNegativeNum(-10);
        System.out.println(positiveOrNegativeNumBool(10));
        printStrings("Hello", 5);
        System.out.println(checkYear(1600) + "\n");
        lst01();
        lst02();
        lst03();
        arrayOfNumber();
        System.out.println(Arrays.toString(createArray(10, 5)));

    }


    public static void printTree() {

        System.out.println("Задание №1");
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple\n");

    }

    public static void checkSumSing() {

        System.out.println("Задание №2");
        int a = 23;
        int b = 78;

        if (a + b >= 0) {
            System.out.println("Сумма положительная\n");
        } else {
            System.out.println("Сумма отрицательная\n");
        }

    }

    public static void printColor() {

        System.out.println("Задание №3");
        int value = 143;

        if (value == 0) {
            System.out.println("Красный\n");
        } else if ((value > 0) && (value <= 100)) {
            System.out.println("Желтый\n");
        } else {
            System.out.println("Зеленый\n");
        }
    }

    public static void compareNumbers() {

        System.out.println("Задание №4");
        int a = -10;
        int b = 34;

        if (a >= b) {
            System.out.println("a >=b \n");
        } else {
            System.out.println("a < b \n");
        }

    }

    public static boolean withinNumbers(int num1, int num2) {

        System.out.println("Задание №5");
        return (num1 + num2 >= 10) && (num1 + num2 <= 20);

    }

    public static void positiveOrNegativeNum(int num) {

        System.out.println("Задание №6");
        if (num >= 0) {
            System.out.println("Число положительное\n");
        } else {
            System.out.println("Число отрицательное\n");
        }

    }


    public static boolean positiveOrNegativeNumBool(int num) {

        System.out.println("Задание №7");
        return num < 0;

    }

    public static void printStrings(String str, int num) {

        System.out.println();
        System.out.println("Задание №8");
        for (int i = 0; i < num; i++) {
            System.out.print(str + " ");
        }
        System.out.println("\n");

    }

    public static boolean checkYear(int year) {

        System.out.println("Задание №9");
        if ((year % 4 == 0) && (year % 100 != 0)) {
            return true;
        } else if (year % 400 == 0) {
            return true;
        } else {
            return false;
        }

    }

    public static void lst01() {

        System.out.println("Задание №10");
        int[] binaryCode = new int[]{0, 1, 0, 0, 1, 0, 1, 1};
        System.out.println(Arrays.toString(binaryCode));

        for (int i = 0; i < binaryCode.length; i++) {
            if (binaryCode[i] == 0) {
                binaryCode[i] = 1;
            } else {
                binaryCode[i] = 0;
            }
        }
        System.out.println(Arrays.toString(binaryCode) + "\n");

    }

    public static void lst02() {

        System.out.println("Задание №11");
        int[] lst = new int[100];
        for (int i = 0; i < lst.length; i++) {
            lst[i] = i + 1;
        }
        System.out.println(Arrays.toString(lst) + "\n");

    }

    public static void lst03() {

        System.out.println("Задание №12");
        int[] lst = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(lst));
        for (int i = 0; i < lst.length; i++) {
            if (lst[i] < 6) {
                lst[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(lst) + "\n");

    }

    public static void arrayOfNumber() {

        System.out.println("Задание №13");
        int size = 7;
        int[][] arr = new int[size][size];

        for (int i = 0; i < size; i++) {
            arr[i][i] = 1;
            arr[i][size - 1 - i] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }


    }

    public static int[] createArray(int len, int initialValue) {

        System.out.println();
        System.out.println("Задание №14");
        int[] lst = new int[len];
        for (int i = 0; i < lst.length; i++) {
            lst[i] = initialValue;
        }
        return lst;

    }
}


