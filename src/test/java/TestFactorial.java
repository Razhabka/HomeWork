import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFactorial {
    @Test
    public void factorialOneTest() {
        try {
            Assert.assertEquals(1, ProgramForTest.factorial(1));
        } catch (WrongArgumentException e) {
        }
    }
    @Test
    public void factorialZeroTest(){
        try {
            ProgramForTest.factorial(0);
        } catch (WrongArgumentException e) {
        }
    }
    @Test
    public void someValueTest() throws WrongArgumentException {
        Assert.assertEquals(24, ProgramForTest.factorial(4));
        Assert.assertEquals(720, ProgramForTest.factorial(6));
        Assert.assertEquals(40320, ProgramForTest.factorial(8));
    }

    @Test
    public void negativeNumberTest(){
        try {
            ProgramForTest.factorial(-3);
        } catch (WrongArgumentException e) {
        }
    }
}
