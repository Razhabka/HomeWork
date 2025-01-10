public class Run {

    public static void main(String[] args) {
        String[][] array = new String[][]{{"4", "7", "100", "24"},
                                    {"54", "73", "46", "52"},
                                    {"9", "63", "23", "73"},
                                    {"2", "28", "45", "35",}};
        try {
            System.out.println(arraySum(array));
        }catch (MyArraySizeException e){
            e.printStackTrace();
        }catch (MyArrayDataException e){
            e.printStackTrace();
        }
    }

    public static int arraySum(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if(arr.length != 4 || arr[0].length != 4 || arr[1].length != 4 || arr[2].length != 4 || arr[3].length != 4 ) throw new MyArraySizeException("Неверная длинна массива");
        int result = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                try {
                    result += Integer.parseInt(arr[i][j]);
                }catch (NumberFormatException e){
                   throw new MyArrayDataException("Неверный формат данный в", i, j);
                }

            }
        }
        return result;
    }

}

class MyArraySizeException extends Exception{

    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception{
    public MyArrayDataException(String message, int index1, int index2) {
        super(message + " ячейках массивов под индексами " + index1 + " " + index2 );
    }

}
