package pageObjects.nativePageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPageObject {
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    //@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Email']/following-sibling::XCUIElementTypeTextField[1]")
    WebElement emailTxt;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Username']/following-sibling::XCUIElementTypeTextField[1]")
    WebElement userNameTxt;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Password']/following-sibling::XCUIElementTypeSecureTextField[1]")
    WebElement passwordTxt;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Confirm password']/following-sibling::XCUIElementTypeSecureTextField[1]")
    WebElement confirmPasswordTxt;

    @AndroidFindBy( className = "android.widget.CheckedTextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label='I read agreaments and agree wit it']")
    WebElement agreementCheckBox;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Register new account']")
    WebElement registerBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_cancel_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='Cancel']")
    WebElement cancelBtn;

    public RegistrationPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    public WebElement getEmailTxt() {
        return emailTxt;
    }

    public WebElement getUserNameTxt() {
        return userNameTxt;
    }

    public WebElement getPasswordTxt() {
        return passwordTxt;
    }

    public WebElement getConfirmPasswordTxt() {
        return confirmPasswordTxt;
    }

    public WebElement getAgreementCheckBox() {
        return agreementCheckBox;
    }

    public WebElement getRegisterBtn() {
        return registerBtn;
    }

    public WebElement getCancelBtn() {
        return cancelBtn;
    }
}
