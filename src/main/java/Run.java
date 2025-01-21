import java.math.BigInteger;

public class Run {
    public static void main(String[] args) {
        try {
            System.out.println(ProgramForTest.factorial(new BigInteger("10")));
        } catch (WrongArgumentException e) {
            e.printStackTrace();
        }
    }
}
