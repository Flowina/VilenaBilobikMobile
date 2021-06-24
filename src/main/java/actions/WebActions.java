package actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pageObjects.NativePageObject;
import pageObjects.WebPageObject;
import pageObjects.webPageObjects.*;

import java.util.List;

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
        List<WebElement> items = searchResultsPageObject.getSearchResultItems();
        for (WebElement w: items) {
            String itemText = w.getText();
            if (itemText != null && itemText.toLowerCase().contains(text.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
