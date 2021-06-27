package data;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider
    public Object[][] registrationData() {
        return new Object[][]{
                {
                        "Joe", "joe@test.test", "Qwerty123!"
                }
        };
    }
}
