package contactpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class CreateContactPage {




	 WebDriver driver;

	    @FindBy(name = "lastname")
	    private WebElement lastNameField;

	    @FindBy(name = "leadsource")
	    private WebElement leadSourceField;

	    @FindBy(id = "email")
	    private WebElement emailField;

	    @FindBy(id = "assistant")
	    private WebElement assistantField;

	    @FindBy(id = "jscal_field_birthday")
	    private WebElement birthDateField;

	    @FindBy(css = "input[title='Save [Alt+S]']")
	    private WebElement saveButton;

	    public CreateContactPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void enterLastName(String lastName) {
	        lastNameField.sendKeys(lastName);
	    }

	    public void selectLeadSource(String leadSource) {
	        Select sel = new Select(leadSourceField);
	        sel.selectByValue(leadSource);
	    }

	    public void enterEmail(String email) {
	        emailField.sendKeys(email);
	    }

	    public void enterAssistant(String assistant) {
	        assistantField.sendKeys(assistant);
	    }

	    public void enterBirthdate(String birthdate) {
	        birthDateField.sendKeys(birthdate);
	    }

	    public void clickSave() {
	        saveButton.click();
	    }
	}
