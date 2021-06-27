package actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pageObjects.NativePageObject;
import pageObjects.WebPageObject;
import pageObjects.webPageObjects.*;

public class WebActions {
    private final WebPageObject po;
    private final GoogleMainPagaObject mainPo;
    private final GoogleSearchResultsPageObject searchResultsPageObject;

    public WebActions(WebPageObject po) {
        this.po = po;
        mainPo = po.getGoogleMainPage();
        searchResultsPageObject = po.getGoogleSearchResults();
    }

    public void search(String query) {
        mainPo.getSearchField().sendKeys(query + Keys.ENTER);
    }

    public Boolean isSearchResultsContainsText(String text) {
        for (WebElement w: searchResultsPageObject.getSearchResultItems()) {
            if (w.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }
}
