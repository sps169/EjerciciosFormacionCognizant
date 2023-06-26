package driverManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.List;

public class EdgeDriverManager extends DriverManager{
    @Override
    protected WebDriver createDriver() {
        EdgeDriver driver = new EdgeDriver(getEdgeOptions());
        driver.manage().window().maximize();
        return driver;
    }

    private EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        return options;
    }
}
