package guvitask9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	WebDriver driver = new ChromeDriver();
	driver.navigate().to("https://www.wikipedia.org/");
	driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Artificial Intelligence");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement str=driver.findElement(By.linkText("History")); 
        str.click();
        System.out.println("The title of the section is "+str.getText());
        
	}

}
