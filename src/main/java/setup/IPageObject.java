package setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface IPageObject {

    WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;
    List<WebElement> getWelements(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;
    AppiumDriver getDriver();
}
