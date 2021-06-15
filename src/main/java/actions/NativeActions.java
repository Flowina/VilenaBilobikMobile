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
        registrationPo.getRegisterBtn().click();
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
