package actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import setup.IPageObject;

import java.util.List;

public class WebActions {
    private IPageObject po;

    public WebActions(IPageObject po) {
        System.out.println("***** WebActions constructor: po = " + po);
        this.po = po;
    }

    public void search(String query) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        po.getWelement("googleMainPage.searchField").sendKeys(query + Keys.ENTER);
    }

    public Boolean isSearchResultsContainsText(String text) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        List<WebElement> items = po.getWelements("googleSearchResults.searchResultItems");
        for (WebElement w: items) {
            String itemText = w.getText();
            if (itemText != null && itemText.toLowerCase().contains(text.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
