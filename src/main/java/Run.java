public class Run {
    public static void main(String[] args) {
        try {
            System.out.println(ProgramForTest.factorial(13));
        } catch (WrongArgumentException e) {
            e.printStackTrace();
        }
    }
}
