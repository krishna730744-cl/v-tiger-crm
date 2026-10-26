package utility;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import reuseble.jsonExtraction;

public class BaseTest {
public WebDriver driver;
public static WebDriver sdriver=null;
	
	 
	// Login Page Elements
	 @FindBy(name = "user_name")
	    private WebElement usernamet;

	    @FindBy(name = "user_password")
	    private WebElement passwordt;

	    @FindBy(id = "submitButton")
	    private WebElement loginButton;
	 // Login Page Elements
	    
	    @BeforeClass
		public void BrowserOpen() throws Exception{
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			PageFactory.initElements(driver, this);
			String url=jsonExtraction.jsonextr("url");
			driver.get(url);
			driver.manage().window().maximize();
			sdriver=driver;
		}
	
	
	@BeforeMethod
	public void Login() throws Exception {
		String usernam=jsonExtraction.jsonextr("username");
		String passwor=jsonExtraction.jsonextr("password");
		enterUsername(usernam);
		enterPassword(passwor);
		clickLogin();
	}
		public void enterUsername(String usernam) {
	        usernamet.sendKeys(usernam);
	    }

	    public void enterPassword(String passwor) {
	        passwordt.sendKeys(passwor);
	    }

	    public void clickLogin() {
	        loginButton.click();
	    }
	
	@AfterMethod
	public void Logout() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Home&action=index&parenttab=My Home Page']")).click();
		driver.findElement(By.xpath("//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")).click();		
		driver.findElement(By.linkText("Sign Out")).click();		
	}
	@AfterClass
	public void Browserclose() throws InterruptedException {
		driver.quit();
		
	}
	

}