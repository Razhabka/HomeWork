import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFactorial {

    @Test
    @Description("Тестирование факториала 1")
    public void factorialOneTest() {
        try {
            Assertions.assertEquals(1, ProgramForTesting.factorial(1));
        } catch (WrongArgumentException e) {

        }
    }

    @Test
    @Description("Тестирования факториала 0")
    public void zeroFactorialTest() {
        try {
            ProgramForTesting.factorial(0);
        } catch (WrongArgumentException e) {
        }
    }

    @Test
    @Description("Тестирования небольших значений")
    public void someValueTest() {
        Assertions.assertAll("factorials",
                () -> Assertions.assertEquals(24, ProgramForTesting.factorial(4)),
                () -> Assertions.assertEquals(720, ProgramForTesting.factorial(6)),
                () -> Assertions.assertEquals(40320, ProgramForTesting.factorial(8))
        );
    }

    @Test
    @Description("Тестирование отрицательных значений")
    public void negativeNumberTest() {
        try {
            ProgramForTesting.factorial(-5);
        } catch (WrongArgumentException e) {

        }
    }

}
