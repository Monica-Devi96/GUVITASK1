package guvitask11;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class NewWindow {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.findElement(By.linkText("Click Here")).click();
		Set <String> WindowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(WindowHandles);
		driver.switchTo().window(windows.get(1));
		String str = driver.findElement(By.tagName("h3")).getText();
		System.out.println("The page contains text: "+str);
        driver.close();
        driver.switchTo().window(windows.get(0));
        String expected_text = "The Internet";
        String str1 = driver.getTitle();
        if(str1.equalsIgnoreCase(expected_text)) {
        	System.out.println("The original window is active");
        }
        else
        {
        	System.out.println("The original window is not active");
        }
        driver.quit();
	}

}
