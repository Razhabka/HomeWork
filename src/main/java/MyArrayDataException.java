class MyArrayDataException extends Exception {
    public MyArrayDataException(String message, int index1, int index2) {
        super(message + " ячейках массивов под индексами " + index1 + " " + index2);
    }

}