package vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class kunal {
		public static void main(String[] args) throws InterruptedException {
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				
				driver.get("https://anvnacare.alwaysdata.net/");
				
				WebElement pharm=driver.findElement(By.id("navPharmacy"));
				pharm.click();
				Thread.sleep(1000);
				
				WebElement item1=driver.findElement(By.id("addCartBtn-3"));
				item1.click();
				Thread.sleep(2000);
				
				WebElement cart=driver.findElement(By.xpath("//a[@class='btn position-relative px-2 py-1']//i"));
				cart.click();
				Thread.sleep(1000);
				
				WebElement checkout=driver.findElement(By.id("checkoutBtn"));
				checkout.click();
				
				WebElement login=driver.findElement(By.id("navLogin"));
				login.click();
				
				WebElement registeredEmail=driver.findElement(By.cssSelector("input[placeholder='Enter your registered email']"));
				registeredEmail.sendKeys("kunalcoding24@gmail.com");
				Thread.sleep(2000);
		
				
				WebElement registeredpassword=driver.findElement(By.cssSelector("input[placeholder='Enter your password']"));
				registeredpassword.sendKeys("Kunal@123");
				Thread.sleep(2000);
				
				WebElement rememberMe=driver.findElement(By.className("form-check-input"));
				rememberMe.click();
				Thread.sleep(2000);
				
				WebElement loginbtn=driver.findElement(By.cssSelector("button[data-testid='login-submit-btn']"));
				loginbtn.click();
				Thread.sleep(4000);
				
				WebElement ecart=driver.findElement(By.cssSelector(".bi.bi-cart3.fs-4.text-success"));
				ecart.click();
				
				//WebElement checkout1=driver.findElement(By.id("checkoutBtn"));
				//checkout1.click();
				//Thread.sleep(2000);
				
				//WebElement address=driver.findElement(By.id("addNewAddressBtn"));
				//address.click();
				//Thread.sleep(2000);
				
				
				
				
				
			}

		
	}


