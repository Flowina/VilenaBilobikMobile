package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.webPageObjects.GoogleMainPagaObject;
import pageObjects.webPageObjects.GoogleSearchResultsPageObject;

public class WebPageObject  {

    private final GoogleMainPagaObject googleMainPage;
    private final GoogleSearchResultsPageObject googleSearchResults;

    public WebPageObject(AppiumDriver appiumDriver) {
        googleMainPage = new GoogleMainPagaObject(appiumDriver);
        googleSearchResults = new GoogleSearchResultsPageObject(appiumDriver);
        PageFactory.initElements(appiumDriver, this);
    }

    public GoogleMainPagaObject getGoogleMainPage() {
        return googleMainPage;
    }

    public GoogleSearchResultsPageObject getGoogleSearchResults() {
        return googleSearchResults;
    }
}
