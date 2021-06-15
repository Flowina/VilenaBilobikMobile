package pageObjects.webPageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearchResultsPageObject {
    @FindBy(css = "#rso [data-hveid]")
    List<WebElement> searchResultItems;

    public GoogleSearchResultsPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    public List<WebElement> getSearchResultItems() {
        return searchResultItems;
    }
}
