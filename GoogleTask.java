package guvitask9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleTask {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("https://www.google.com/");
		driver.manage().window().maximize();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		driver.navigate().refresh();
		driver.quit();
	}

}
