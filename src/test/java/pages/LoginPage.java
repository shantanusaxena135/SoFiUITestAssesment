package pages;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoginPage extends BasePage {

    private String url;
    private String username;
    private String password;


    public LoginPage(){
        super();
        loadProperties();
    }

    private void loadProperties(){
        /**
         * Loads page url, username and password from configuration file
         */

        Properties prop = new Properties();
        InputStream properties = null;

        try {
            properties = new FileInputStream("src/test/resources/config.properties");
            prop.load(properties);

            url = prop.getProperty("saucedemo_url");
            username = prop.getProperty("sauceuser");
            password = prop.getProperty("saucepassword");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (properties != null) {
                try {
                    properties.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void login(){
        /**
         * Logins in as standard user
         */
        driver.navigate().to(url);
        driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
}
