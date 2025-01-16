public class Run {

    public static void main(String[] args) {
        String[][] array = new String[][]{{"4", "7", "100", "24"},
                                          {"54", "73", "46", "52"},
                                          {"9", "63", "23", "73"},
                                          {"2", "28", "44", "23"}};
        try {
            System.out.println(arraySum(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    public static int arraySum(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4) {
            throw new MyArraySizeException("Неверная длинна массива");
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length != 4)
                    throw new MyArraySizeException("Неверная длина вутренненго масива под индексом " + i);
            }
        }


        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    result += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверный формат данный в", i, j);
                }

            }
        }
        return result;
    }

}




