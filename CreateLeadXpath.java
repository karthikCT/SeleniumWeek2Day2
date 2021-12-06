package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadXpath {

	public static void main(String[] args) {
		
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("http://leaftaps.com/opentaps");

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
driver.findElement(By.id("password")).sendKeys("crmsfa");
driver.findElement(By.className("decorativeSubmit")).click();
driver.findElement(By.linkText("CRM/SFA")).click();
driver.findElement(By.linkText("Create Lead")).click();
//driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Trimble");
driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Trimble");
//driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Karthikeyan");
driver.findElement(By.xpath("(//input[@name = 'firstName'])[3]")).sendKeys("Karthikeyan");
//driver.findElement(By.id("createLeadForm_lastName")).sendKeys("C T");
driver.findElement(By.xpath("(//input[@name = 'lastName'])[3]")).sendKeys("C T");


WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
Select src = new Select(source);
src.selectByVisibleText("Employee");

WebElement market = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
Select mrk = new Select(market);
mrk.selectByVisibleText("Automobile");

driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Kat");
driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("CTK");
driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("SalTitle");
driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("07/16/80");
driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("MainTitle");
driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Engineering");
driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("100000");

WebElement currency = driver.findElement(By.id("createLeadForm_currencyUomId"));
Select curr = new Select(currency);
curr.selectByIndex(1);

WebElement ind = driver.findElement(By.id("createLeadForm_industryEnumId"));
Select industry = new Select(ind);
industry.selectByIndex(1);

driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("100");

WebElement own = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
Select owner = new Select(own);
owner.selectByValue("OWN_PARTNERSHIP");

driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("SIC");
driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("SYM");
driver.findElement(By.id("createLeadForm_description")).sendKeys("Its my first lead");
driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("Be Bold And Brave");

driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("2");
driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("987654321");
driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("91");
driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("54321");
driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Kenna");
driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("babu@trestleaf.com");
driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("http://testleaf.com");


driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Kat");
driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Kevin");
driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("Velachery");
driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Chennai60042");
driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Chennai");
driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("600117");
driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("117");

WebElement statep = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
Select sp = new Select(statep);
sp.selectByIndex(5);

WebElement conco = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
Select country = new Select(conco);
country.selectByValue("GBR");
 
 String FM = driver.findElement(By.id("createLeadForm_firstName")).getAttribute("value");
 System.out.println("FirstName is : " + FM);
 
 driver.findElement(By.name("submitButton")).click();
 
String resultingTitle = driver.getTitle();

if(resultingTitle.contains("View Lead"))
{	
 System.out.println("Title of the resulting Page is " +resultingTitle);
}
else
	System.out.println("Title of the resulting Page is not View Lead)");

driver.close();
	}

}
