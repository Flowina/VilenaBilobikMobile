package scenarios;

import actions.NativeActions;
import data.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageObject;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {
    NativeActions actions;
    String budgetPageTitle;

    @Parameters({"budgetPageTitle"})
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(String budgetPageTitle) {
        actions = new NativeActions(getNativePo());
        this.budgetPageTitle = budgetPageTitle;
    }

    /*@Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPo().getWelement("signInBtn").click();
        System.out.println("Simplest Android native test done");

    }*/
    @Test(groups = {"native"},
            description = "Register a new account and then sign in. Make sure that you are on the BudgetActivity page",
            dataProviderClass = TestDataProvider.class, dataProvider = "registrationData")
    public void registerAndLogInTest(String userName, String email, String password) {
        actions.goToRegistrationPage();
        actions.register(userName, email, password);
        actions.logIn(email, password);
        Assert.assertEquals(actions.getBudgetPageTitle(), budgetPageTitle);
    }
}
