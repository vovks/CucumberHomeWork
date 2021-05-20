package hellocucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import pages.BasketPage;
import pages.MainPage;
import pages.ProductsPage;


public class StepDefinitions {
    MainPage mainPage;
    ProductsPage productsPage;
    BasketPage basketPage;

    @Given("I login as non registered user on haircarepanda")
    public void i_login_as_non_registered_user_on_haircarepanda() {
        mainPage = new MainPage();
        mainPage.clickAcceptCookies();
    }


    @And("I select category “gummies”")
    public void i_select_category_gummies() {
        productsPage = mainPage.clickOnGummiesButton();
    }

    @And("I put cursor on product")
    public void i_put_cursor_on_product() {
        productsPage.moveToProduct();

    }
    @When("I tap on “Buy now” button")
    public void i_tap_on_buy_now_button() {
        productsPage.scrollToProduct();
    }

    @Then("The basket page is displayed with selected previously product")
    public void the_basket_page_is_displayed_with_selected_previously_product() {
        productsPage.clickOnBasket();
        basketPage = productsPage.clickOnMyBasket();

        Assertions.assertTrue(basketPage.checkNameProductInBasket().contains("Hair Care Panda Vegan Gummies"));
        Assertions.assertTrue(basketPage.checkAmountProductsInBasket().contains("1"));

    }


    @Given("I add product to basket")
    public void i_add_product_to_basket() {
        productsPage = mainPage.clickOnGummiesButton();
        productsPage.moveToProduct();
        productsPage.scrollToProduct();
    }

    @Given("I navigate to basket")
    public void i_navigate_to_basket() {
        productsPage.clickOnBasket();
        basketPage = productsPage.clickOnMyBasket();
    }


    @When("I tap on “delete” icon near product name")
    public void i_tap_on_delete_icon_near_product_name() {
        basketPage.deleteProduct();
    }

    @Then("the message “Your shopping cart is empty An empty basket is a sad basket” is displayed")
    public void the_message_your_shopping_cart_is_empty_an_empty_basket_is_a_sad_basket_is_displayed() {
        Assertions.assertTrue(basketPage.checkSadEmptyBasket().contains("Your shopping cart is empty\n" +
                "An empty basket is a sad basket."));
    }

    @When("I tap on “+” icon near product name")
    public void i_tap_on_icon_near_product_name() {
        basketPage.increaseQuantityOfProducts();
    }

    @Then("the quantity of products is increased")
    public void the_quantity_of_products_is_increased() {
        basketPage.clickToRefreshBasket();
        Assertions.assertTrue(basketPage.checkAmountProductsInBasket().contains("2"));
    }

    @Then("the price is calculated correctly")
    public void the_price_is_calculated_correctly() {
        Assertions.assertTrue(basketPage.checkPrice().contains("76"));
    }

}
