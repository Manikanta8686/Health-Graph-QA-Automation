package Test1.ALTORO_MUTUAL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Altoro_test1 {
	WebDriver driver = null;
	@BeforeTest
	public void open_browser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
		@Test(priority=1)
		public void open_url() {
			driver.get("http://altoro.testfire.net/");
			driver.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
			driver.findElement(By.xpath("//*[@id=\"uid\"]")).sendKeys("demo_user");
			driver.findElement(By.xpath("//*[@id=\"passw\"]")).sendKeys("demo_password");
			driver.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
			
		
	}@Test(priority=2)
		public void open_url1() {
		driver.get("http://altoro.testfire.net/login.jsp");
		driver.findElement(By.xpath("//*[@id=\"uid\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"passw\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
		WebElement K1 = driver.findElement(By.name("listAccounts"));
		//Thread.sleep(2000);
		  Select s1 = new Select(K1);
			s1.selectByIndex(1);
		driver.findElement(By.id("btnGetAccount")).click();
	}
	@Test(priority=3)
		public void open_url2() {
		driver.get("http://altoro.testfire.net/bank/showAccount?listAccounts=800001");
		WebElement expected_text=driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/table/tbody/tr[1]/td/table/tbody/tr[4]/td[2]"));
	    WebElement actual_text=driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/table/tbody/tr[1]/td/table/tbody/tr[4]/td[2]"));
	   //System.out.println(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/table/tbody/tr[1]/td/table/tbody/tr[4]/td[2]")));
	    Assert.assertEquals(expected_text, actual_text);
	    driver.findElement(By.xpath("//*[@id=\"MenuHyperLink3\"]")).click();
		WebElement K1 = driver.findElement(By.id("toAccount"));
		  Select s1 = new Select(K1);
			s1.selectByIndex(1);
	    driver.findElement(By.id("transferAmount")).sendKeys("9876");
	    driver.findElement(By.name("transfer")).click();
	    
	    
	}@Test(priority=4)
		public void open_transactions()
		{
		driver.get("http://altoro.testfire.net/bank/transfer.jsp");
		driver.findElement(By.xpath("//*[@id=\"MenuHyperLink2\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"HyperLink3\"]")).click();
		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div[1]/p[2]/a")).click();
		driver.findElement(By.name("email_addr")).sendKeys("mmk@gmail.com");
		driver.findElement(By.name("subject")).sendKeys("Testing");
		driver.findElement(By.name("comments")).sendKeys("Hi Greetings of the day");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		}
		@AfterTest
		public void close_browser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

}
