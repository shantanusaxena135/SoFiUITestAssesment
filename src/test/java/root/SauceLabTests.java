package root;

import browser.Browser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.CartPage;
import pages.LandingPage;
import pages.LoginPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SauceLabTests {

    private LoginPage login_page;
    private LandingPage landing_page;
    private CartPage cart_page;


    @Before
    public void setup(){
        login_page = new LoginPage();
        landing_page = new LandingPage();
        cart_page = new CartPage();
    }


    @Test
    public void testLogin (){
        /**
         * Perform UI tests on saucedemo.com. Following steps are performed:
         * 1. log in as standarduser
         * 2. verifies cart to have no items added
         * 3. Adds 'Sauce Labs Onesie' to cart
         * 4. Verifies item count in cart
         * 5. Adds 'Sauce Labs Bike Light' to cart
         * 6. Verifies item count in cart
         * 7. Goes to the cart page
         * 8. Verifies all items are added in cart
         */

        login_page.login();

        // Checking if landing page loaded correctly"
        assertThat(landing_page.getLandingPageTitle(), is("Swag Labs"));

        // Checking if cart count is correct
        assertThat(landing_page.shoppingCartCount(), is(0));

        // Adding Sauce Labs Onesie to the cart"
        landing_page.addItemToCart("Sauce Labs Onesie");

        // wait for 1 second
        landing_page.driverWait(1);

        // Checking if cart count is correct
        assertThat(landing_page.shoppingCartCount(), is(1));

        // "Adding Sauce Labs Bike Light to the cart"
        landing_page.addItemToCart("Sauce Labs Bike Light");

        // wait for 1 second
        landing_page.driverWait(1);

        // Checking if cart count is correct
        assertThat(landing_page.shoppingCartCount(), is(2));

        //go to shopping cart page
        landing_page.goToCart();

        // verify the items were added in the cart
        assertThat(cart_page.IsItemAdded("Sauce Labs Onesie"), is(true));
        assertThat(cart_page.IsItemAdded("Sauce Labs Bike Light"), is(true));

    }

    @After
    public void teardown(){
        /**
         * Tear down the browser instance opened
         */
        Browser.tearInstance();
    }
}