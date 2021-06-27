package pageObjects.webPageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.BasePageObject;

import java.util.List;

public class GoogleSearchResultsPageObject extends BasePageObject {
    @FindBy(css = "#rso [data-hveid]")
    List<WebElement> searchResultItems;

    public GoogleSearchResultsPageObject(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
}
