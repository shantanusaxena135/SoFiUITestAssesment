package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
    private static Browser singleton_browser;
    public static WebDriver driver;

    private Browser() {
        if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_mac");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_windows.exe");
        }

        driver = new ChromeDriver();
    }


    public static Browser getInstance() {
        /**
         * Returns a singleton instance of the Browser class
         *  @return singleton instance of the Browser class
         */
        if (singleton_browser == null)
            singleton_browser = new Browser();

        return singleton_browser;
    }

    public static void tearInstance() {
        /** Closes the selenium driver and sets singleton browser as null
         */
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        singleton_browser = null;
    }

}