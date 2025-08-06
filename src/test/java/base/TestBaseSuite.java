package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class TestBaseSuite {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeTest(alwaysRun = true)
    public void setup(String browser) {
        driver = DriverFactory.initDriver(browser);
        driver.get(ConfigReader.getProperty("baseUrl"));
        new LoginPage().login("john", "demo");
    }

    @AfterTest(alwaysRun = true)
    public void teardown() {
        DriverFactory.quitDriver();
    }
}
