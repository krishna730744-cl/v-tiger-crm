package leadpom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class CreateLeadPage {
	

	   WebDriver driver;

	    @FindBy(name = "lastname")
	    private WebElement lastNameField;

	    @FindBy(name = "company")
	    private WebElement compNameField;

	    @FindBy(css = "input[title='Save [Alt+S]']")
	    private WebElement saveButton;

	    public CreateLeadPage(WebDriver driver) {

	        this.driver = driver;

	        PageFactory.initElements(driver, this);
	    }

	    public void enterLastName(String lastName) {

	        lastNameField.sendKeys(lastName);
	    }

	    public void enterCompanyName(String compName) {

	        compNameField.sendKeys(compName);
	    }

	    public void clickSave() {

	        saveButton.click();
	    }
	
}
