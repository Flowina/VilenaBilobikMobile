package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.webPageObjects.GoogleMainPageObject;
import pageObjects.webPageObjects.GoogleSearchResultsPageObject;

public class WebPageObject  {

    private final GoogleMainPageObject googleMainPage;
    private final GoogleSearchResultsPageObject googleSearchResults;

    public WebPageObject(AppiumDriver appiumDriver) {
        googleMainPage = new GoogleMainPageObject(appiumDriver);
        googleSearchResults = new GoogleSearchResultsPageObject(appiumDriver);
        PageFactory.initElements(appiumDriver, this);
    }
}
