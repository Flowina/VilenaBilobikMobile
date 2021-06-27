package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import pageObjects.nativePageObjects.NativePageObject;
import pageObjects.webPageObjects.WebPageObject;
import setup.IPageObject;

import java.lang.reflect.Field;
import java.util.List;

public class PageObject implements IPageObject {

    Object somePageObject; // it should be set of web page or EPAM Test App WebElements
    AppiumDriver appiumDriver;

    public PageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        this.appiumDriver = appiumDriver;
        System.out.println("Current app type: " + appType);
        switch(appType){
            case "web":
                somePageObject = new WebPageObject(appiumDriver);
                break;
            case "native":
                somePageObject = new NativePageObject(appiumDriver);
                break;
            default: throw new Exception("Can't create a page object for "+appType);
        }

    }

    @Override
    public WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException {
        Object obj = getObject(weName);
        return (WebElement) obj;
    }

    @Override
    public List<WebElement> getWelements(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Object obj = getObject(weName);
        return (List<WebElement>) obj;
    }

    private Object getObject(String weName) throws NoSuchFieldException, IllegalAccessException {
        String [] path = weName.split("\\.");

        // use reflection technique
        Object obj = somePageObject;
        Field field = null;
        Class<?> classs = somePageObject.getClass();
        for (String p: path) {
            field = classs.getDeclaredField(p);
            field.setAccessible(true);
            obj = field.get(obj);
            classs = field.getType();
        }
        return obj;
    }

    @Override
    public AppiumDriver getDriver() {
        return appiumDriver;
    }
}
