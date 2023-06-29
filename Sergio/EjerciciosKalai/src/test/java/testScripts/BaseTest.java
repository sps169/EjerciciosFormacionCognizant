package testScripts;

import driverManagement.DriverFactory;
import driverManagement.DriverManager;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public abstract class BaseTest {

    public DriverManager driverManager;

    public BaseTest(String browser) {
        this.driverManager = DriverFactory.valueOf(browser).getDriverManager();
    }
    @Parameterized.Parameters
    public static Collection<String> data() {
        return List.of(
                "CHROME",
                "EDGE"
//                "FIREFOX"
        );
    }

    @After
    public void closeDriver() {
        driverManager.quitDriver();
    }
}
