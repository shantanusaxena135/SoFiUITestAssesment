package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LandingPage extends BasePage {


    public LandingPage() {
        super();
    }


    public void addItemToCart(String item_name) {
        /**
         * Adds the item in the cart.
         *  @param  item_name   The title of the item to be added
         */
        parentNode(parentNode(parentNode(getItemTitleDiv(item_name)))).findElement(By.tagName("button")).click();
    }

    private WebElement getItemTitleDiv(String item_name) {
        /**
         * Finds and return the Webelement of the Add To Card container of the item
         *  @param  item_name   The title of the item to be added
         *  @return Webelement of the Add To Card Button of the item
         */
        return driver.findElement(By.xpath("//div[text()=\"" + item_name + "\"]"));
    }

    public String getLandingPageTitle() {
        /**
         * Gets the title of the landing page
         *  @return title of the lan ding page
         */
        return driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]")).getText();
    }

    private WebElement parentNode(WebElement element) {
        /**
         * Finds and return the parent Webelement Web element passed
         *  @param  element   Web element whose parent node needs to be returned
         *  @return parent Webelement of the element passed in argument
         */
        return element.findElement(By.xpath(".."));
    }

    public Integer shoppingCartCount() {
        /**
         * Gets the count of the items added in the cart on landing page
         *  @return count of the items added in the cart on landing page
         */
        if (shoppingCartLink().findElements(By.tagName("span")).size() > 0) {
            return Integer.parseInt(shoppingCartLink().findElement(By.tagName("span")).getText());
        }

        return 0;
    }

    private WebElement shoppingCartLink() {
        /**
         * Gets the Webelement of the shopping cart on the landing page
         *  @return Webelement of the shopping cart on the landing page
         */
        return driver.findElement(By.id("shopping_cart_container"));
    }

    public void goToCart() {
        /**
         * Directs to the cart page
         */
        shoppingCartLink().click();
    }

}
