import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class CalculatorTest {
    @Test
    public void testSumValid(){
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.sum(1, 2), 1 + 2);
    }

    @Test
    public void testSum() {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.sum(Integer.MAX_VALUE, 1), Integer.MAX_VALUE + 1);
    }
}
