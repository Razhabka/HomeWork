import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.math.BigInteger;

public class TestFactorial {
    @Test
    public void factorialOneTest() throws WrongArgumentException {
        Assert.assertEquals(new BigInteger("1"), ProgramForTest.factorial(new BigInteger("0")));
    }

    @Test
    public void factorialZeroTest() throws WrongArgumentException {
        Assert.assertEquals(new BigInteger("1"), ProgramForTest.factorial(new BigInteger("0")));
    }

    @Test
    public void someValueTest() throws WrongArgumentException {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(new BigInteger("24"), ProgramForTest.factorial(new BigInteger("4")));
        softAssert.assertEquals(new BigInteger("720"), ProgramForTest.factorial(new BigInteger("6")));
        softAssert.assertEquals(new BigInteger("40320"), ProgramForTest.factorial(new BigInteger("8")));
        softAssert.assertAll();
    }

    @Test
    public void negativeNumberTest() throws WrongArgumentException {
        Assert.assertThrows(WrongArgumentException.class, () -> ProgramForTest.factorial(new BigInteger("-5")));
    }
}
