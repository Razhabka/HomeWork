import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigInteger;

public class TestFactorial {

    @Test
    @Description("Тестирование факториала 1")
    public void factorialOneTest() throws WrongArgumentException {
        Assertions.assertEquals(new BigInteger("1"), ProgramForTesting.factorial(new BigInteger("1")));
    }

    @Test
    @Description("Тестирования факториала 0")
    public void zeroFactorialTest() throws WrongArgumentException {
        Assertions.assertEquals(new BigInteger("1"), ProgramForTesting.factorial(new BigInteger("0")));
    }

    @Test
    @Description("Тестирования небольших значений")
    public void someValueTest() {
        Assertions.assertAll("factorials",
                () -> Assertions.assertEquals(new BigInteger("24"), ProgramForTesting.factorial(new BigInteger("4"))),
                () -> Assertions.assertEquals(new BigInteger("720"), ProgramForTesting.factorial(new BigInteger("6"))),
                () -> Assertions.assertEquals(new BigInteger("2432902008176640000"), ProgramForTesting.factorial(new BigInteger("20")))
        );
    }

    @Test
    @Description("Тестирование отрицательных значений")
    public void negativeNumberTest() throws WrongArgumentException {
        Assertions.assertThrows(WrongArgumentException.class, (Executable) ProgramForTesting.factorial(new BigInteger("-1")));
    }

}
