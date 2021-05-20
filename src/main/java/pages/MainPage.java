package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage{

    public MainPage() {
        super();
    }

    @Override
    public void waitForLoadableElement() {

    }

    @FindBy(css = "[href$=\"zelki\"]>.button")
    private WebElement gummiesButton;

    @FindBy(css = "button[onclick]")
    private WebElement acceptCookies;

    //button[onclick]

    public void clickAcceptCookies(){
        acceptCookies.click();
    }

    public ProductsPage clickOnGummiesButton(){
        gummiesButton.click();
        return new ProductsPage();
    }


    //category “gummies”
    //[href$="zelki"]>.button
    //перешла на продуктс
    //[href$="vegan-gummies"]
    //[href$="vegan-gummies"]>.txt>.btn.btn-primary>strong
    //[src$= "shopping-purse-icon.svg"]
    //.quantity-box>input

}
