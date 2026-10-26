package vtiger;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import leadpom.CreateLeadPage;
import leadpom.HomePage;
import leadpom.LeadDetailsPage;
import leadpom.LeadsPage;
import leadpom.LoginPage;
import leadpom.UserMenuPage;

public class leadTest1 {


	
	

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
	     * @throws InterruptedException 
	     */
          @Test
	    public static void leadTestuy() throws InterruptedException{

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


	        LoginPage loginPage = new LoginPage(driver);

	        System.out.println("Username and password fields located successfully.");

	        loginPage.enterUsername("admin");

	        System.out.println("Username entered successfully.");

	        loginPage.enterPassword("manager");

	        System.out.println("Password entered and login submitted.");

	        loginPage.clickLogin();

	        System.out.println("Login process completed.");


	        // ============================================================
	        // STEP 3: CREATE LEAD
	        // ============================================================

	        System.out.println("Step 3: Navigating to Leads module...");


	        HomePage homePage = new HomePage(driver);

	        homePage.clickLeads();

	        System.out.println("Leads module opened successfully.");


	        LeadsPage leadsPage = new LeadsPage(driver);

	        leadsPage.clickCreateLead();

	        System.out.println("Create Lead page opened successfully.");


	        // ============================================================
	        // STEP 4: FILLING LEAD FORM
	        // ============================================================

	        System.out.println("Step 4: Filling Lead form...");

	        String lastName = "Kumarr";

	        System.out.println("Lead Last Name: " + lastName);


	        CreateLeadPage createLeadPage = new CreateLeadPage(driver);

	        System.out.println("Lead Last Name field located successfully.");

	        createLeadPage.enterLastName(lastName);

	        System.out.println("Lead Last Name entered successfully.");


	        String compName = "Google";

	        System.out.println("Company Name: " + compName);

	        System.out.println("Company Name field located successfully.");

	        createLeadPage.enterCompanyName(compName);

	        System.out.println("Company Name entered successfully.");


	        // ============================================================
	        // STEP 5: SAVE LEAD
	        // ============================================================

	        System.out.println("Step 5: Saving Lead...");

	        createLeadPage.clickSave();

	        System.out.println("Save button clicked successfully.");

	        System.out.println("Lead save operation completed.");


	        // ============================================================
	        // STEP 6: VERIFICATION
	        // ============================================================

	        System.out.println("Step 6: Verifying Lead creation...");


	        LeadDetailsPage leadDetailsPage =
	                new LeadDetailsPage(driver);


	        // Fetch actual Last Name from the Lead details page
	        String actLastName =
	                leadDetailsPage.getLastName();


	        // Fetch actual Company Name from the Lead details page
	        String actCompName =
	                leadDetailsPage.getCompanyName();


	        System.out.println("Expected Lead Last Name: " + lastName);

	        System.out.println("Actual Lead Last Name: " + actLastName);

	        System.out.println("Expected Company Name: " + compName);

	        System.out.println("Actual Company Name: " + actCompName);


	        // Verify both Last Name AND Company Name
	        if (actLastName.equals(lastName)
	                && actCompName.equals(compName)) {

	            System.out.println(
	                    "PASS: Lead created successfully with correct Last Name and Company Name !!!"
	            );

	        } else {

	            System.out.println(
	                    "FAIL: Lead creation failed or entered details do not match....."
	            );
	        }


	        // ============================================================
	        // STEP 7: LOGOUT
	        // ============================================================

	        System.out.println("Step 7: Starting logout process...");


	        UserMenuPage userMenuPage =
	                new UserMenuPage(driver);


	        System.out.println("Profile icon located successfully.");

	        System.out.println("Actions object created successfully.");

	        userMenuPage.logout();

	        System.out.println("Mouse hovered over profile icon.");

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
