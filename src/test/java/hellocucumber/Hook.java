package hellocucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.ProviderForDriver;

import static utils.Constants.BASIC_CATEGORY_URL;

public class Hook {
    @Before
    public void beforeMethod(Scenario scenario){
        ProviderForDriver.INSTANCE.getDriver().get(BASIC_CATEGORY_URL);
        ProviderForDriver.INSTANCE.getDriver().manage().window().maximize();
    }

    @After
    public void afterMethod(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) ProviderForDriver.INSTANCE.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Page screenshot");
        }
        ProviderForDriver.INSTANCE.removeDriver();
    }
}
