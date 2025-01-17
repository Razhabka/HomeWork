public class ProgramForTesting {
    public static int factorial(int num) throws WrongArgumentException {
        try {
            if (num == 1) {
                return 1;
            }
            return factorial(num - 1) * num;
        } catch (StackOverflowError e) {
            throw new WrongArgumentException("Передан неверный аргумент");
        }
    }
}
