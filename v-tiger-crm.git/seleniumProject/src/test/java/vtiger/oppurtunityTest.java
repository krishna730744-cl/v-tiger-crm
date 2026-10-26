package vtiger;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class oppurtunityTest {
	

	/**
	 * Test Class: CreateOpportunityTest
	 *
	 * Description:
	 * This automation script verifies the complete flow of creating a new
	 * Opportunity in the Vtiger CRM application.
	 *
	 * Test Flow:
	 * 1. Launch Chrome browser
	 * 2. Maximize browser window
	 * 3. Configure implicit wait
	 * 4. Open Vtiger application
	 * 5. Login using valid credentials
	 * 6. Navigate to Opportunities module
	 * 7. Open Create Opportunity page
	 * 8. Enter Opportunity Name
	 * 9. Select Organizations from Related To dropdown
	 * 10. Open Organization selection popup
	 * 11. Select required Organization from popup
	 * 12. Switch back to parent window
	 * 13. Save the Opportunity
	 * 14. Verify the created Opportunity
	 * 15. Logout from Vtiger
	 * 16. Close the browser
	 *
	 * Test Data:
	 * Opportunity Name: MakunaiDeal
	 * Organization Name: MakunaiGlobal_
	 *
	 * Expected Result:
	 * Opportunity should be created successfully with the entered
	 * Opportunity Name and the selected Organization.
	 *
	 * Application: Vtiger CRM
	 * Test Type: Functional / UI Automation
	 */



		public static void main(String[] args) throws InterruptedException {

			// ============================================================
			// TEST EXECUTION START
			// ============================================================

			System.out.println("========== TEST EXECUTION STARTED ==========");
			System.out.println("Test Case: Create Opportunity");


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
			// STEP 3: CREATE OPPORTUNITY
			// ============================================================

			System.out.println("Step 3: Navigating to Opportunities module...");

			driver.findElement(By.linkText("Opportunities")).click();

			System.out.println("Opportunities module opened successfully.");

			driver.findElement(By.cssSelector("img[alt='Create Opportunity...']")).click();

			System.out.println("Create Opportunity page opened successfully.");


			// ============================================================
			// STEP 4: FILLING OPPORTUNITY FORM
			// ============================================================

			System.out.println("Step 4: Filling Opportunity form...");


			// ------------------------------------------------------------
			// Enter Opportunity Name
			// ------------------------------------------------------------

			String oppoName = "RishabhDeals";

			System.out.println("Opportunity Name: " + oppoName);

			WebElement oppoNameField = driver.findElement(By.name("potentialname"));

			System.out.println("Opportunity Name field located successfully.");

			oppoNameField.sendKeys(oppoName);

			System.out.println("Opportunity Name entered successfully.");


			// ------------------------------------------------------------
			// Select Organizations from Related To dropdown
			// ------------------------------------------------------------

			System.out.println("Selecting Organizations from Related To...");

			WebElement relatedToDropdown =
					driver.findElement(By.name("related_to_type"));

			Select select = new Select(relatedToDropdown);

			select.selectByVisibleText("Organizations");

			System.out.println("Organizations selected successfully.");


			// ------------------------------------------------------------
			// Organization Name to be selec
//			---------------------

			String orgName = "RishabhGlobal_1788955763";

			System.out.println("Organization to be selected: " + orgName);


			// ------------------------------------------------------------
			// Open Organization Selection Popup
			// ------------------------------------------------------------

			System.out.println("Opening Organization selection popup...");

			String parentWindow = driver.getWindowHandle();

			/*
			 * Clicking the lookup/select icon beside the Related To field.
			 *
			 * This opens a separate popup window where the required
			 * Organization can be selected.
			 */

			driver.findElement(
					By.xpath("//input[@name='related_to']/following-sibling::img")
			).click();

			System.out.println("Organization selection popup opened successfully.");


			// ============================================================
			// STEP 5: SELECT ORGANIZATION FROM POPUP
			// ============================================================

			System.out.println("Step 5: Selecting Organization from popup...");

			Set<String> allWindows = driver.getWindowHandles();

			System.out.println("Available browser windows: " + allWindows.size());

			for (String window : allWindows) {

				if (!window.equals(parentWindow)) {

					driver.switchTo().window(window);

					System.out.println(
							"Switched successfully to Organization selection popup."
					);

					break;
				}
			}


			// ------------------------------------------------------------
			// Select Organization
			// ------------------------------------------------------------

			System.out.println("Searching for Organization: " + orgName);

			/*
			 * Select the required Organization from the popup window.
			 * The XPath searches for an Organization containing the
			 * specified Organization Name.
			 */

			driver.findElement(
					By.xpath("//a[contains(text(),'" + orgName + "')]")
			).click();

			System.out.println("Organization selected successfully.");


			// ------------------------------------------------------------
			// Switch back to Parent Window
			// ------------------------------------------------------------

			driver.switchTo().window(parentWindow);

			System.out.println("Returned to Create Opportunity page successfully.");


			// ============================================================
			// STEP 6: SAVE OPPORTUNITY
			// ============================================================

			System.out.println("Step 6: Saving Opportunity...");

			driver.findElement(
					By.cssSelector("input[title='Save [Alt+S]']")
			).click();

			System.out.println("Save button clicked successfully.");

			System.out.println("Opportunity save operation completed.");


			// ============================================================
			// STEP 7: VERIFICATION
			// ============================================================

			System.out.println("Step 7: Verifying Opportunity creation...");


			// ------------------------------------------------------------
			// Get Actual Opportunity Name
			// ------------------------------------------------------------

			String actOppoName =
					driver.findElement(
							By.id("dtlview_Opportunity Name")
					).getText();

			System.out.println("Expected Opportunity Name: " + oppoName);

			System.out.println("Actual Opportunity Name: " + actOppoName);


			// ------------------------------------------------------------
			// Verify Opportunity Name
			// ------------------------------------------------------------

			if (actOppoName.equals(oppoName)) {

				System.out.println(
						"PASS: Opportunity created successfully with correct Opportunity Name !!!"
				);

			} else {

				System.out.println(
						"FAIL: Opportunity creation failed or entered details do not match....."
				);
			}


			// ============================================================
			// STEP 8: LOGOUT
			// ============================================================

			System.out.println("Step 8: Starting logout process...");

			WebElement profile = driver.findElement(
					By.cssSelector(
							"img[src='themes/softed/images/user.PNG']"
					)
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
			// STEP 9: CLOSE THE BROWSER
			// ============================================================

			System.out.println("Step 9: Closing the browser...");

			Thread.sleep(2000);

			System.out.println("Wait completed.");

			driver.quit();

			System.out.println("Browser closed successfully.");


			// ============================================================
			// TEST EXECUTION END
			// =========================================

}
}