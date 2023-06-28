import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class CalculatorTest {

    private Calculator calc;

    @BeforeTest
    public void setUpCalculator() {
        calc = new Calculator();
    }
    @Test
    public void testSumValid(){
        Assert.assertEquals(calc.sum(1, 2), 1 + 2);
    }

    @Test
    public void testSubstractValid() {
        Assert.assertEquals(calc.substract(1, -1), 2);
    }

    @Test
    public void testMultiplyValid() {
        Assert.assertEquals(calc.multiply(2, 5), 10);
    }

    @Test
    public void testDivideValid() {
        Assert.assertEquals(calc.divide(1, 2), 1/2);
    }

}
