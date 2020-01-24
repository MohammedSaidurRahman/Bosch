package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	
	WebDriver driver;
	
	@Before
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mohammed Rahman\\Desktop\\chromedriver_win32\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	//	this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	//	this.driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
	}
	
	@After
	public void TearDown() throws InterruptedException {
		Thread.sleep(2000);
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
		this.driver = null;
	} 
	
	@Given("^Shopping site is loaded$")
	public void shopping_site_is_loaded() throws Throwable {
	   driver.get("http://automationpractice.com/index.php");
	   WebElement popularButton = driver.findElement(By.xpath("//*[@id=\"home-page-tabs\"]/li[1]/a"));
	   Assert.assertEquals(true, popularButton.isDisplayed());

	}
	
	
	@And("^User clicks on sign in button on home page$")
	public void user_clicks_on_sign_in_button_on_home_page() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a\r\n" + 
				"	")).click();
		WebElement emailField = driver.findElement(By.id("email"));
		Assert.assertEquals(true, emailField.isDisplayed());
	}

	@And("^User enters a valid email address$")
	public void user_enters_a_valid_email_address() throws Throwable {
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("14038128@stu.mmu.ac.uk");
		WebElement emailField = driver.findElement(By.id("email"));
		Assert.assertEquals(true, emailField.isDisplayed());
		Thread.sleep(1000);

		
	}

	@And("^User enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
		driver.findElement(By.id("passwd")).click();
		driver.findElement(By.id("passwd")).sendKeys("12345");
		WebElement passwdField = driver.findElement(By.id("passwd"));
		Assert.assertEquals(true, passwdField.isDisplayed());
		Thread.sleep(1000);
		
	}

	@When("^User clicks on sign in button$")
	public void user_clicks_on_sign_in_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
	}

	@Then("^User should be successfully signed in$")
	public void user_should_be_successfully_signed_in() throws Throwable {
		WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1"));
		Assert.assertEquals("MY ACCOUNT", myAccount.getText());
	}

	

}
