package vtiger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import contactpom.ContactDetailsPage;
import contactpom.ContactsPage;
import contactpom.CreateContactPage;
import contactpom.HomePage;

import junit.framework.Assert;
import reuseble.jsonExtraction;
import utility.BaseTest;
@Listeners(listeners.TestListeners.class)
public class contactTest1 extends BaseTest {
	
		@Test
	    public  void contactyu() throws Exception {
	        String lastname = jsonExtraction.jsonextr("lastName");
	        String emai = jsonExtraction.jsonextr("email");
	        String assistan = jsonExtraction.jsonextr("assistant");
	        String leadsourc = jsonExtraction.jsonextr("leadSource");
	        String birthdat = jsonExtraction.jsonextr("birthdate");
	        // Home Page
	        HomePage homePage = new HomePage(driver);

	        homePage.clickContacts();

	        // Contacts Page
	        ContactsPage contactsPage = new ContactsPage(driver);

	        contactsPage.clickCreateContact();

	        // Create Contact Page
	        CreateContactPage createContactPage = new CreateContactPage(driver);
	        String lastName = lastname;
	        createContactPage.enterLastName(lastName);
	        String leadSource = leadsourc;
	        createContactPage.selectLeadSource(leadSource);
	        String email = emai;
	        createContactPage.enterEmail(email);
	        String assistant = assistan;
	        createContactPage.enterAssistant(assistant);
	        String birthdate = birthdat;
	        createContactPage.enterBirthdate(birthdate);
	        // Save
	        createContactPage.clickSave();
	        // Contact Details Page
	        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
	        // Fetch actual values
	        String actLastName =contactDetailsPage.getLastName();

	        String actLeadSource =contactDetailsPage.getLeadSource();

	        String actAssistant = contactDetailsPage.getAssistant();

	        String actEmail = contactDetailsPage.getEmail();

	        String actBirthday = contactDetailsPage.getBirthday();
	        Assert.assertEquals(actLastName, lastName);
	        Assert.assertEquals(actLeadSource, leadSource);
	        Assert.assertEquals(actAssistant, assistant);
	        Assert.assertEquals(actEmail, email);
	        Assert.assertEquals(actBirthday, birthdate);
	     
	    }
	}

