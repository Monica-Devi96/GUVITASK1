package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;
import pages.AccountPage;

public class AccountTest extends BaseTest {

    LoginPage loginPage;
    AccountPage accountPage;
    String baseUrl = ConfigReader.getProperty("baseUrl");

    @BeforeMethod
    public void setupAccountPage() {
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("john");
        loginPage.enterPassword("demo");
        loginPage.clickLogin();
        accountPage = new AccountPage(driver);
    }

    @Test
    public void viewCheckingAccountSummary() {
        accountPage.selectAccountByType("CHECKING");
        Assert.assertTrue(accountPage.isBalanceDisplayed());
        Assert.assertTrue(accountPage.isRecentTransactionsDisplayed());
    }

    @Test
    public void viewSavingsAccountSummary() {
        accountPage.selectAccountByType("SAVINGS");
        Assert.assertTrue(accountPage.isBalanceDisplayed());
        Assert.assertTrue(accountPage.isRecentTransactionsDisplayed());
    }

    @Test
    public void viewFullTransactionHistory() {
        accountPage.navigateToTransactions();
        Assert.assertTrue(accountPage.isTransactionHistoryDisplayed());
    }

    @Test
    public void validateTransactionListColumns() {
        accountPage.navigateToTransactions();
        Assert.assertTrue(accountPage.validateTransactionTableHeaders());
    }

    @Test
    public void filterTransactionByDateRange() {
        accountPage.navigateToTransactions();
        accountPage.filterTransactionsByDate("01-01-2024", "01-06-2024");
        Assert.assertTrue(accountPage.areFilteredResultsDisplayed());
    }

    @Test
    public void sortTransactionsByDateAndAmount() {
        accountPage.navigateToTransactions();
        accountPage.sortBy("Date");
        Assert.assertTrue(accountPage.isSorted("Date"));

        accountPage.sortBy("Amount");
        Assert.assertTrue(accountPage.isSorted("Amount"));
    }
}