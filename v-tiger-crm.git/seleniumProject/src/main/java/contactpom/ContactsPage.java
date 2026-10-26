package contactpom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	

	 WebDriver driver;

	    @FindBy(css = "img[alt='Create Contact...']")
	    private WebElement createContactButton;

	    public ContactsPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void clickCreateContact() {
	        createContactButton.click();
	    }
	}

