package automationPractice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class Practice_OrangeTestCase5 {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		
		WebDriver driver=new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		String pass="Admin123";
		String lowerPass=pass.toLowerCase();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys(lowerPass);
		driver.findElement(By.id("btnLogin")).click();
		Assert.assertEquals("Welcome",driver.findElement(By.id("welcome")),driver.findElement(By.id("welcome")));
	
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]//*[text()='Logout']")).click();
		String expectedURL=driver.getCurrentUrl();
		String actualURL="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
		Assert.assertEquals(expectedURL,actualURL);
		
		//driver.findElement(By.tagName("a")).click();
		//driver.findElement(By.className("panelContainer")).click();
		//driver.findElement(By.partialLinkText("Logout")).click();
		
		
	}

}