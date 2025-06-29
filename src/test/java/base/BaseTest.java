package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverFactory;
import utils.ExtentManager;
import com.aventstack.extentreports.*;
import utils.Log;

public class BaseTest {
    protected WebDriver driver;
    protected ExtentReports extent = ExtentManager.getInstance();
    protected ExtentTest test;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        driver = DriverFactory.initDriver(browser);
        Log.startTestCase(this.getClass().getSimpleName());
    }

    @AfterMethod
    public void tearDown() {
        Log.endTestCase();
        DriverFactory.quitDriver();
    }
}
