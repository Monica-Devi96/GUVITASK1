package guvitask11;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameSwitch {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.switchTo().frame("frame-top");
		//driver.switchTo().defaultContent();
 		
 		//Left Frame
		     driver.switchTo().frame("frame-left");
      	     WebElement ele1 = driver.findElement(By.tagName("body"));
		     String text1 = ele1.getText();
		     System.out.println("The text in left frame: "+text1);
		     driver.switchTo().defaultContent();
		     
		//Middle Frame
		     driver.switchTo().frame("frame-top");
		     driver.switchTo().frame("frame-middle");
		     WebElement ele2 = driver.findElement(By.tagName("body"));
		     String text2 = ele2.getText();
		     System.out.println("The text in middle frame: "+text2);
		     driver.switchTo().defaultContent();
		     
		//Right Frame
		     driver.switchTo().frame("frame-top");
		     driver.switchTo().frame("frame-right");
		     WebElement ele3 = driver.findElement(By.tagName("body"));
		     String text3 = ele3.getText();
		     System.out.println("The text in right frame: "+text3);
		     driver.switchTo().defaultContent();
		     
		//Bottom Frame
		     driver.switchTo().frame("frame-bottom");
		     WebElement ele4 = driver.findElement(By.tagName("body"));
		     String text4 = ele4.getText();
		     System.out.println("The text in bottom frame: "+text4);
		     driver.switchTo().defaultContent();
		     
		     driver.switchTo().frame("frame-top");
		     
		     
}

}
