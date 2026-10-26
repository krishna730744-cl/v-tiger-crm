package vtiger;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class leadTest {
	

	
	

	/**
	 * Test Class: CreateLeadsTest
	 *
	 * Description:
	 * This automation script verifies the complete flow of creating a new
	 * Lead in the Vtiger CRM application.
	 *
	 * Test Flow:
	 * 1. Launch Chrome browser
	 * 2. Maximize browser window
	 * 3. Configure implicit wait
	 * 4. Open Vtiger application
	 * 5. Login using valid credentials
	 * 6. Navigate to Leads module
	 * 7. Open Create Lead page
	 * 8. Enter Lead Last Name
	 * 9. Enter Company Name
	 * 10. Save the Lead
	 * 11. Verify the created Lead
	 * 12. Logout from Vtiger
	 * 13. Close the browser
	 *
	 * Test Data:
	 * Lead Last Name: Kumarr
	 * Company Name: Google
	 *
	 * Expected Result:
	 * Lead should be created successfully with the entered Last Name
	 * and Company Name, and the user should be able to logout successfully.
	 *
	 * Application: Vtiger CRM
	 * Test Type: Functional / UI Automation
	 */

	

		public static void main(String[] args) throws InterruptedException {

			// ============================================================
			// TEST EXECUTION START
			// ============================================================

			System.out.println("========== TEST EXECUTION STARTED ==========");
			System.out.println("Test Case: Create Lead");


			// ============================================================
			// STEP 1: OPEN THE BROWSER
			// ============================================================

			System.out.println("Step 1: Opening Chrome browser...");

			WebDriver driver = new ChromeDriver();

			System.out.println("Chrome browser opened successfully.");

			driver.manage().window().maximize();

			System.out.println("Browser window maximized.");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

			System.out.println("Implicit wait configured to 15 seconds.");


			// ============================================================
			// STEP 2: LOGIN
			// ============================================================

			System.out.println("Step 2: Starting login process...");

			driver.get("http://localhost:8888/");

			System.out.println("Vtiger application launched successfully.");

			WebElement username = driver.findElement(By.name("user_name"));
			WebElement password = driver.findElement(By.name("user_password"));

			System.out.println("Username and password fields located successfully.");

			username.sendKeys("admin");

			System.out.println("Username entered successfully.");

			password.sendKeys("manager" + Keys.ENTER);

			System.out.println("Password entered and login submitted.");

			System.out.println("Login process completed.");


			// ============================================================
			// STEP 3: CREATE LEAD
			// ============================================================

			System.out.println("Step 3: Navigating to Leads module...");

			driver.findElement(By.linkText("Leads")).click();

			System.out.println("Leads module opened successfully.");

			driver.findElement(By.cssSelector("img[alt='Create Lead...']")).click();

			System.out.println("Create Lead page opened successfully.");


			// ============================================================
			// STEP 4: FILLING LEAD FORM
			// ============================================================

			System.out.println("Step 4: Filling Lead form...");

			String lastName = "Kumarr";

			System.out.println("Lead Last Name: " + lastName);

			WebElement lastNameField = driver.findElement(By.name("lastname"));

			System.out.println("Lead Last Name field located successfully.");

			lastNameField.sendKeys(lastName);

			System.out.println("Lead Last Name entered successfully.");


			String compName = "Google";

			System.out.println("Company Name: " + compName);

			WebElement compNameField = driver.findElement(By.name("company"));

			System.out.println("Company Name field located successfully.");

			compNameField.sendKeys(compName);

			System.out.println("Company Name entered successfully.");


			// ============================================================
			// STEP 5: SAVE LEAD
			// ============================================================

			System.out.println("Step 5: Saving Lead...");

			driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

			System.out.println("Save button clicked successfully.");

			System.out.println("Lead save operation completed.");


			// ============================================================
			// STEP 6: VERIFICATION
			// ============================================================

			System.out.println("Step 6: Verifying Lead creation...");

			// Fetch actual Last Name from the Lead details page
			String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

			// Fetch actual Company Name from the Lead details page
			String actCompName = driver.findElement(By.id("dtlview_Company")).getText();

			System.out.println("Expected Lead Last Name: " + lastName);
			System.out.println("Actual Lead Last Name: " + actLastName);

			System.out.println("Expected Company Name: " + compName);
			System.out.println("Actual Company Name: " + actCompName);

			// Verify both Last Name AND Company Name
			if (actLastName.equals(lastName) && actCompName.equals(compName)) {

			    System.out.println("PASS: Lead created successfully with correct Last Name and Company Name !!!");

			} else {

			    System.out.println("FAIL: Lead creation failed or entered details do not match.....");

			}


			// ============================================================
			// STEP 7: LOGOUT
			// ============================================================

			System.out.println("Step 7: Starting logout process...");

			WebElement profile = driver.findElement(
					By.cssSelector("img[src='themes/softed/images/user.PNG']")
			);

			System.out.println("Profile icon located successfully.");

			Actions act = new Actions(driver);

			System.out.println("Actions object created successfully.");

			act.moveToElement(profile).build().perform();

			System.out.println("Mouse hovered over profile icon.");

			driver.findElement(By.linkText("Sign Out")).click();

			System.out.println("Sign Out option clicked successfully.");

			System.out.println("Logout process completed.");


			// ============================================================
			// STEP 8: CLOSE THE BROWSER
			// ============================================================

			System.out.println("Step 8: Closing the browser...");

			Thread.sleep(5000);

			System.out.println("Wait completed.");

			driver.quit();

			System.out.println("Browser closed successfully.");


			// ============================================================
			// TEST EXECUTION END
			// ============================================================

			System.out.println("========== TEST EXECUTION COMPLETED ==========");

		
		}

}
