public class Run {
    public static void main(String[] args) {
        try {
            System.out.println(ProgramForTesting.factorial(-1));
        } catch (WrongArgumentException e) {
            e.printStackTrace();
        }
    }
}
