package actions;

import pageObjects.NativePageObject;
import pageObjects.nativePageObjects.*;

public class NativeActions {
    private NativePageObject po;
    private LogInPageObject logInPo;
    private RegistrationPageObject registrationPo;
    private BudgetPageObject budgetPo;

    public NativeActions(NativePageObject po) {
        this.po = po;
        logInPo = po.getLogInPage();
        registrationPo = po.getRegistrationPage();
        budgetPo = po.getBudgetPage();
    }

    public void goToRegistrationPage() {
        logInPo.getRegisterBtn().click();
    }

    public void register(String login, String email, String password) {
        registrationPo.getUserNameTxt().sendKeys(login);
        registrationPo.getEmailTxt().sendKeys(email);
        registrationPo.getPasswordTxt().sendKeys(password);
        registrationPo.getConfirmPasswordTxt().sendKeys(password);
        registrationPo.getAgreementCheckBox().click();

        //po.getDriver().hideKeyboard();
        registrationPo.getRegisterBtn().click();

        // second click required in iOs
        // Is it a bug?
        String platformName = (String) po.getDriver().getSessionDetails().get("platformName");
        if (platformName.toLowerCase().equals("ios")) {
            registrationPo.getRegisterBtn().click();
        }
    }

    public void logIn(String login, String password) {
        logInPo.getUserNameTxt().sendKeys(login);
        logInPo.getPasswordTxt().sendKeys(password);
        logInPo.getSignInBtn().click();
    }

    public String getBudgetPageTitle() {
        return budgetPo.getPageTitle().getText();
    }
}
