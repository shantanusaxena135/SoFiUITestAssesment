package pages;

import browser.Browser;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        driver = Browser.getInstance().driver;
    }

    public void driverWait(Integer wait_time) {
        /**
         * Puts the selenium driver on wait
         * @param  wait_time   time in seconds to wait
         */
        driver.manage().timeouts().implicitlyWait(wait_time, TimeUnit.SECONDS);

    }


}
