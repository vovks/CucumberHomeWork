package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    public AbstractPage() {
        PageFactory.initElements(ProviderForDriver.INSTANCE.getDriver(), this);
    }

    public abstract void waitForLoadableElement();
}
