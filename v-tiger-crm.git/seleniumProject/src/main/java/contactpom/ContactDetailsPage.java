package contactpom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ContactDetailsPage {
	
	     WebDriver driver;

		    public ContactDetailsPage(WebDriver driver) {
		        this.driver = driver;
		        PageFactory.initElements(driver, this);
		    }

	    @FindBy(id = "dtlview_Last Name")
	    private WebElement actualLastName;

	    @FindBy(xpath = "//*[@id='dtlview_Lead Source']")
	    private WebElement actualLeadSource;

	    @FindBy(id = "dtlview_Assistant")
	    private WebElement actualAssistant;

	    @FindBy(id = "dtlview_Email")
	    private WebElement actualEmail;

	    @FindBy(id = "dtlview_Birthdate")
	    private WebElement actualBirthday;


	    public String getLastName() {
	        return actualLastName.getText();
	    }

	    public String getLeadSource() {
	        return actualLeadSource.getText();
	    }

	    public String getAssistant() {
	        return actualAssistant.getText();
	    }

	    public String getEmail() {
	        return actualEmail.getText();
	    }

	    public String getBirthday() {
	        return actualBirthday.getText();
	    }
	
}
