package vtiger;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import reuseble.jsonExtraction;

public class contactTest {

	    public static void main(String[] args) throws Exception {

	        WebDriver driver = new ChromeDriver();
	        String usernam=jsonExtraction.jsonextr("username");
			String passwor=jsonExtraction.jsonextr("password");
			String url=jsonExtraction.jsonextr("url");
			
			String lastname=jsonExtraction.jsonextr("lastName");
			String emai=jsonExtraction.jsonextr("email");
			String assistan=jsonExtraction.jsonextr("assistant");
			String leadsourc=jsonExtraction.jsonextr("leadSource");
			String birthdat=jsonExtraction.jsonextr("birthdate");

	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	        driver.get(url);

	        // Login
	        WebElement username = driver.findElement(By.name("user_name"));
	        WebElement password = driver.findElement(By.name("user_password"));

	        username.sendKeys(usernam);
	        password.sendKeys(passwor);

	        driver.findElement(By.id("submitButton")).click();

	        // Click Contacts
	        driver.findElement(By.linkText("Contacts")).click();

	        // Click Create Contact
	        driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

	        // Last Name
	        String lastName = lastname;

	        WebElement lastNameField =driver.findElement(By.name("lastname"));

	        lastNameField.sendKeys(lastName);

	        // Lead Source
	        String leadSource = leadsourc;
	        WebElement lead = driver.findElement(By.name("leadsource"));
	        Select sel = new Select(lead);
	        sel.selectByValue(leadSource);

	        // Email
	        String email = emai;
	        WebElement emailField = driver.findElement(By.id("email"));
	        emailField.sendKeys(email);

	        // Assistant
	        String assistant = assistan;
	        WebElement assistantField =driver.findElement(By.id("assistant"));

	        assistantField.sendKeys(assistant);

	        // Birthdate
	        String birthdate = birthdat;
	        WebElement birthDateField = driver.findElement(By.id("jscal_field_birthday"));
	        birthDateField.sendKeys(birthdate);

	        // Save
	        driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

	        // Fetch actual values
	        String actLastName =
	                driver.findElement(By.id("dtlview_Last Name")).getText();

	        String actLeadSource = driver.findElement(By.xpath("//*[@id='dtlview_Lead Source']")).getText();
	        String actAssistant =driver.findElement(By.id("dtlview_Assistant")).getText();
	        String actEmail = driver.findElement(By.id("dtlview_Email")).getText();
	        String actBirthday = driver.findElement(By.id("dtlview_Birthdate")).getText();

	        // Validation
	        if (actLastName.equals(lastName)
	                && actLeadSource.equals(leadSource)
	                && actAssistant.equals(assistant)
	                && actEmail.equals(email)
	                && actBirthday.equals(birthdate)) {

	            System.out.println("Contact Successfully Created");

	        } else {

	            System.out.println("Contact Creation Failed");
	        }

	        // Logout
	        WebElement profile = driver.findElement(
	                By.cssSelector("img[src='themes/softed/images/user.PNG']")
	        );

	        Actions act = new Actions(driver);

	        act.moveToElement(profile).perform();

	        driver.findElement(By.linkText("Sign Out")).click();

	        Thread.sleep(3000);

	        driver.quit();
	    }
	}


