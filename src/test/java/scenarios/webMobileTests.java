package scenarios;

import actions.WebActions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.WebPageObject;
import setup.BaseTest;

public class webMobileTests extends BaseTest {

    WebActions actions;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        WebPageObject wpo = getWebPo();
        actions = new WebActions(wpo);
    }

    @Parameters({"baseUrl", "searchText"})
    @Test(groups = {"web"}, description = "go to a Google search page and make a search using keyword ‘EPAM’. " +
            "Make sure that there are some relevant results (non-empty list)")
    public void simpleWebTest(String baseUrl, String searchText) throws InterruptedException {
        getDriver().get(baseUrl);
        // Make sure that page has been loaded completely
        /*new WebDriverWait(getDriver(), 30).until(
                wd -> ((JavascriptExecutor) wd)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );*/
        actions.search(searchText);
        Assert.assertTrue(actions.isSearchResultsContainsText(searchText), "Search results are not relevant");
    }
}
