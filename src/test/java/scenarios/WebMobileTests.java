package scenarios;

import actions.WebActions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageObject;
import setup.BaseTest;

public class WebMobileTests extends BaseTest {
    WebActions actions;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws Exception {
        if (po == null) {
            System.out.println("***** Why is po NULL ?!!");
            // I don't know why the po field is null here.
            // In the NativeMobileTests the same code works perfectly.
            // WORKAROUND: Reinitialize po
            po = new PageObject("web", getDriver());
        }
        actions = new WebActions(po);
    }

    @Parameters({"baseUrl", "searchText"})
    @Test(groups = {"web"},
            description = "go to a Google search page and make a search using keyword ‘EPAM’. " +
            "Make sure that there are some relevant results (non-empty list)")
    public void simpleWebTest(String baseUrl, String searchText) throws InterruptedException, NoSuchFieldException, IllegalAccessException, InstantiationException {
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
