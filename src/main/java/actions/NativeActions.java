package actions;

import setup.IPageObject;

public class NativeActions {
    private IPageObject po;

    public NativeActions(IPageObject po) {
        System.out.println("***** NativeActions constructor: po = " + po);
        this.po = po;
    }

    public void goToRegistrationPage() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        po.getWelement("logInPage.registerBtn").click();
    }

    public void register(String login, String email, String password) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        po.getWelement("registrationPage.userNameTxt").sendKeys(login);
        po.getWelement("registrationPage.emailTxt").sendKeys(email);
        po.getWelement("registrationPage.passwordTxt").sendKeys(password);
        po.getWelement("registrationPage.confirmPasswordTxt").sendKeys(password);
        po.getWelement("registrationPage.agreementCheckBox").click();

        //po.getDriver().hideKeyboard();
        po.getWelement("registrationPage.registerBtn").click();

        // second click required in iOs
        // Is it a bug?
        String platformName = (String) po.getDriver().getSessionDetails().get("platformName");
        if (platformName.toLowerCase().equals("ios")) {
            po.getWelement("registrationPage.registerBtn").click();
        }
    }

    public void logIn(String login, String password) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        po.getWelement("logInPage.userNameTxt").sendKeys(login);
        po.getWelement("logInPage.passwordTxt").sendKeys(password);
        po.getWelement("logInPage.signInBtn").click();
    }

    public String getBudgetPageTitle() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        return po.getWelement("budgetPage.pageTitle").getText();
    }
}
