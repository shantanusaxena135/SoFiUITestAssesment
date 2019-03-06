package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage() {
        super();
    }

    public Boolean IsItemAdded(String item_name) {
        /**
         * Checks if the item passed in argument is added in the cart on cart page
         *  @param  item_name   title of the item to be checked
         *  @return true if item is found in cart, false otherwise
         */

        Boolean found = false;
        List<WebElement> item_list = driver.findElements(By.className("inventory_item_name"));
        for (WebElement item : item_list) {
            if (item.getText().equals(item_name)) {
                found = true;
            }
        }
        return found;
    }
}