package pageObjects.webPageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.BasePageObject;

public class GoogleMainPageObject extends BasePageObject {
    @FindBy(css = "input[name='q']")
    WebElement searchField;

    public GoogleMainPageObject(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
}
