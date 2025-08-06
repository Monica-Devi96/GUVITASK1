package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DriverFactory;

import java.time.Duration;

public class OpenAccountPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private final By openNewAccountLink = By.linkText("Open New Account");
    private final By accountTypeDropdown = By.id("type");
    private final By fromAccountDropdown = By.id("fromAccountId");
    private final By openAccountButton = By.cssSelector("input.button");
    private final By newAccountIdLink = By.id("newAccountId");

    public OpenAccountPage() {
    	this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void navigateToOpenNewAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(openNewAccountLink)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountTypeDropdown));
    }

    public String openSavingsAccount() {
        // Select SAVINGS from account type dropdown
        Select accountTypeSelect = new Select(driver.findElement(accountTypeDropdown));
        accountTypeSelect.selectByVisibleText("SAVINGS");
        System.out.println("Selected account type: SAVINGS");

        // Wait for funding account dropdown to refresh/populate
        wait.until(driver -> {
            Select s = new Select(driver.findElement(fromAccountDropdown));
            return !s.getOptions().isEmpty();
        });

        // Select specific funding account: 13344
        Select fromAccountSelect = new Select(driver.findElement(fromAccountDropdown));
        boolean accountFound = false;

        for (WebElement option : fromAccountSelect.getOptions()) {
            if (option.getText().trim().equals("12345")) {
                fromAccountSelect.selectByVisibleText("12345");
                accountFound = true;
                System.out.println("Funding from account: 12345");
                break;
            }
        }

        if (!accountFound) {
            throw new RuntimeException("Funding account 13344 not found in dropdown.");
        }

        // Click Open New Account button
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(openAccountButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();
        System.out.println("Clicked Open New Account button");

        // Wait for confirmation page with new account number
        WebElement newAccountIdElement = wait.until(ExpectedConditions.visibilityOfElementLocated(newAccountIdLink));
        String newAccountNumber = newAccountIdElement.getText();
        System.out.println("New Savings account created: " + newAccountNumber);

        return newAccountNumber;
    }
}
