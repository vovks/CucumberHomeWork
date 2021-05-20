package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waiters;

import java.time.Duration;

public class BasketPage extends AbstractPage{
    public BasketPage() {
        super();
    }

    @Override
    public void waitForLoadableElement() {
        Waiters.waitForElementToBeVisible(selectAmountProductsInBasket);
    }

    @FindBy(css = "[alt=\"Hair Care Panda Vegan Gummies\"]")
    private WebElement selectNameProductInBasket;

    @FindBy(css = ".quantity-box>input")
    private WebElement selectAmountProductsInBasket;

    @FindBy(css = ".hidden-xs>.delete")
    private WebElement selectDeleteProduct;

    @FindBy(css = ".px20")
    private WebElement sadEmptyBasket;

    @FindBy(css = ".plus")
    private WebElement addQuantityOfProduct;

    @FindBy(css = "[src$= \"shopping-purse-icon.svg\"]")
    private WebElement refreshBasket;

    @FindBy(css = ".pull-right>.hidden-xs")
    private WebElement price;

    public String checkNameProductInBasket(){
        return selectNameProductInBasket.getAttribute("alt");
    }

    public String checkAmountProductsInBasket(){
        return selectAmountProductsInBasket.getAttribute("value");
    }

    public void deleteProduct(){
        selectDeleteProduct.click();
        ProviderForDriver.INSTANCE.getDriver().switchTo().alert().accept();
    }

    public String checkSadEmptyBasket(){
        new WebDriverWait(ProviderForDriver.INSTANCE.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".px20")));
        return sadEmptyBasket.getText();
    }

    public void increaseQuantityOfProducts(){
        addQuantityOfProduct.click();
    }

    public void clickToRefreshBasket() {
        refreshBasket.click();
    }

    public String checkPrice(){
        return price.getText();
    }
}
