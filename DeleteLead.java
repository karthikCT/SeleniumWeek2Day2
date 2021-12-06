package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		
//Setup		
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("http://leaftaps.com/opentaps");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.manage().window().maximize();

driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
driver.findElement(By.id("password")).sendKeys("crmsfa");
driver.findElement(By.className("decorativeSubmit")).click();
driver.findElement(By.linkText("CRM/SFA")).click();
driver.findElement(By.linkText("Leads")).click();
driver.findElement(By.linkText("Find Leads")).click();

String id = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
System.out.println(id);

driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
driver.findElement(By.linkText("Delete")).click();
driver.findElement(By.linkText("Find Leads")).click();
driver.findElement(By.name("id")).sendKeys(id);
driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
Thread.sleep(3000);

String text = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();

//Verify message "No records to display" in the Lead List.
if (text.contains("No records to display"))
{
	System.out.println("The lead is Successfully Deleted");
	}
else
	System.out.println("The Lead is not Deleted");

driver.close();
	}

}
