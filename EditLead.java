package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Karthikeyan");
driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
Thread.sleep(5000);

driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
driver.getTitle().contains("View Lead");
driver.findElement(By.linkText("Edit")).click();
driver.findElement(By.id("updateLeadForm_companyName")).clear();
driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("GL Chennai");
driver.findElement(By.xpath("//input[@name='submitButton']")).click();

//Confirm the changed name appears
if(driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText().contains("GL Chennai"))
{
System.out.println("The Changed Company Name Appears Correctly");
}

driver.close();

	}
}
