package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OpenAccountPage;
import utils.ExtentTestManager;

public class CreateSavingsAccountTest extends BaseTest {

    @Test
    public void createSavingsAccount() {
        ExtentTestManager.getTest().info("Navigating to Open New Account page");

        
        OpenAccountPage openAccountPage = new OpenAccountPage();

        openAccountPage.navigateToOpenNewAccount();

        ExtentTestManager.getTest().info("Selecting SAVINGS account type and opening account");

        String newAccountNumber = openAccountPage.openSavingsAccount();

        ExtentTestManager.getTest().info("✅ New Savings account created: " + newAccountNumber);

        Assert.assertNotNull(newAccountNumber, "New Savings Account Number should not be null");
    }
}
