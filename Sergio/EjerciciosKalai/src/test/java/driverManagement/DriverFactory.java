package driverManagement;

import org.openqa.selenium.edge.EdgeDriver;

public enum DriverFactory {
    CHROME {
        @Override
        public DriverManager getDriverManager() {
            return new ChromeDriverManager();
        }
    },
    FIREFOX {
        @Override
        public DriverManager getDriverManager() {
            return new FirefoxDriverManager();
        }
    },

    EDGE {
        @Override
        public DriverManager getDriverManager() {
            return new EdgeDriverManager();
        }
    };

    public abstract DriverManager getDriverManager();
}
