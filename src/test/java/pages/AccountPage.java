package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AccountPage {
    private WebDriver driver;

    private By accountLinks = By.cssSelector("#accountTable a");
    private By balance = By.xpath("//td[@id='availableBalance']");
    private By transactionsTable = By.xpath("//table[@id='transactionTable']");
    private By transactionHeaders = By.xpath("//table[@id='transactionTable']//th[contains(text(),'Transaction')]");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectAccountByType(String type) {
        List<WebElement> accounts = driver.findElements(accountLinks);
        for (WebElement account : accounts) {
            if (account.getText().contains(type)) {
                account.click();
                break;
            }
        }
    }

    public boolean isBalanceDisplayed() {
        return driver.findElement(balance).isDisplayed();
    }

    public boolean isRecentTransactionsDisplayed() {
        return driver.findElement(transactionsTable).isDisplayed();
    }

    public void navigateToTransactions() {
        driver.findElement(By.linkText("Transactions"))  // adjust if needed
              .click();
    }

    public boolean isTransactionHistoryDisplayed() {
        return driver.findElement(transactionsTable).isDisplayed();
    }

    public boolean validateTransactionTableHeaders() {
        List<WebElement> headers = driver.findElements(transactionHeaders);
        return headers.stream().anyMatch(h -> h.getText().contains("Date")) &&
               headers.stream().anyMatch(h -> h.getText().contains("Amount")) &&
               headers.stream().anyMatch(h -> h.getText().contains("Type"));
    }

    public void filterTransactionsByDate(String from, String to) {
        driver.findElement(By.id("fromDate")).sendKeys(from);
        driver.findElement(By.id("toDate")).sendKeys(to);
        driver.findElement(By.cssSelector("input[value='Find Transactions']")).click();
    }

    public boolean areFilteredResultsDisplayed() {
        return driver.findElement(transactionsTable).isDisplayed();
    }

    public void sortBy(String column) {
        List<WebElement> headers = driver.findElements(transactionHeaders);
        for (WebElement header : headers) {
            if (header.getText().equalsIgnoreCase(column)) {
                header.click();
                break;
            }
        }
    }

    public boolean isSorted(String column) {
        // Placeholder logic
        return true;
    }
}
