package automationPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class Practice_OrangeTestCase6 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.xpath("//input[@value=\"Add\"]")).click();

		Select sc = new Select(driver.findElement(By.className("formSelect")));
		sc.selectByVisibleText("Admin");
		driver.findElement(By.cssSelector("input[id*='empName']")).sendKeys("p");
		String Name="Nina Patel"; 
		List<WebElement> myList = driver.findElements(By.xpath("//div[@class=\"ac_results\"]/ul"));
		// System.out.println("array:"+);
		ArrayList<String> all_elements_text =new ArrayList<>();
		//List<String> all_elements_text=new ArrayList<>();
		for(int i=0; i<myList.size(); i++){
			//all_elements_text.add(myList.get(i).getText());
			all_elements_text.add(myList.get(i).toString());
		    System.out.println(myList.get(i).getText());
		    }
		//value of ul- driver.findElements- store in collections- 
		//iterate to find nina patel
		driver.findElement(By.cssSelector("input[name='systemUser[userName]']")).sendKeys("Gagan");
		Select sc1 = new Select(driver.findElement(By.id("systemUser_status")));
		sc1.selectByVisibleText("Disabled");
		driver.findElement(By.cssSelector("input[id=\"systemUser_password\"]")).sendKeys("admin1990");
		driver.findElement(By.cssSelector("input[name=\"systemUser[confirmPassword]\"]")).sendKeys("admin1990");
	}
}
