package pageObjects.nativePageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pageObjects.BasePageObject;

public class BudgetPageObject extends BasePageObject {
    /*@AndroidFindBy(xpath = "//*[@resource-id='platkovsky.alexey.epamtestapp:id/action_bar'][1]/" +
            "android.widget.TextView")*/
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout[2]/" +
            "android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeStaticText")
    WebElement pageTitle;

    public BudgetPageObject(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
}
