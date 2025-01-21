import java.math.BigInteger;

public class ProgramForTesting {
    public static BigInteger factorial(BigInteger num) throws WrongArgumentException {
        if (num.equals(BigInteger.ONE) || num.equals(BigInteger.ZERO)) {
            return BigInteger.valueOf(1);
        } else if (num.longValue() < 0) {
            throw new WrongArgumentException("Передан неверный аргумент");
        }

        return factorial(num.subtract(BigInteger.ONE)).multiply(num);


    }
}
