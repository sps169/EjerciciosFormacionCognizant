package driverManagement;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class DriverManager {
    protected ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    protected abstract WebDriver createDriver();

    public void quitDriver() {
        if (drivers.get() != null) {
            try {
                drivers.get().quit();
                drivers.remove();
            } catch (Exception e) {
                System.err.println("Unable to gracefully quit WebDriver." + e.getMessage()); //TODO replace with logger
            }
        }
    }

    public WebDriver getDriver() {
        if (drivers.get() == null) {
            drivers.set(this.createDriver());
        }
        drivers.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return drivers.get();
    }
}
