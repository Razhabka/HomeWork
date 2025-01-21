import java.math.BigInteger;

public class Run {
    public static void main(String[] args) {
        try {
            System.out.println(ProgramForTesting.factorial(new BigInteger("20")));
        } catch (WrongArgumentException e) {
            e.printStackTrace();
        }
    }
}
