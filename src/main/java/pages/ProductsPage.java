package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waiters;

import java.time.Duration;

public class ProductsPage extends AbstractPage{

    public ProductsPage() {
        super();
    }

    @Override
    public void waitForLoadableElement() {
        Waiters.waitForElementToBeVisible(selectBuyNow);
        Waiters.waitForElementToBeVisible(selectBasket);
    }

    @FindBy(css = "[href$=\"vegan-gummies\"]")
    private WebElement selectGummiesProduct;

    @FindBy(css = "[href$=\"vegan-gummies\"]>.txt>.btn.btn-primary")
    private WebElement selectBuyNow;

    @FindBy(css = "[src$= \"shopping-purse-icon.svg\"]")
    private WebElement selectBasket;

    @FindBy(css = ".btn-rounded-smaller.no-animation")
    private WebElement selectMyBasket;

    public void moveToProduct(){
        Actions a = new Actions(ProviderForDriver.INSTANCE.getDriver());
        a.moveToElement(selectGummiesProduct).build().perform();
    }

    public void scrollToProduct(){
        ((JavascriptExecutor) ProviderForDriver.INSTANCE.getDriver()).executeScript("arguments[0].scrollIntoView(true);", selectBuyNow);
        ((JavascriptExecutor) ProviderForDriver.INSTANCE.getDriver()).executeScript("arguments[0].checked = true;", selectBuyNow);
        ((JavascriptExecutor) ProviderForDriver.INSTANCE.getDriver()).executeScript("arguments[0].click();", selectBuyNow);
    }


    public void clickOnBasket(){
        selectBasket.click();;
    }

    public BasketPage clickOnMyBasket() {
        new WebDriverWait(ProviderForDriver.INSTANCE.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".btn-rounded-smaller.no-animation")));
        selectMyBasket.click();
        return new BasketPage();
    }
}
