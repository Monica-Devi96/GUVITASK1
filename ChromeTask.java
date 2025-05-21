package guvitask9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class ChromeTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.demoblaze.com/");
		driver.manage().window().maximize();
        String str = driver.getTitle();
        if(str.equals("STORE")) {
        	System.out.println("Page landed on correct website");
        }
        else {
        	System.out.println("Page not landed on correct website");
        }
        
	}

}
