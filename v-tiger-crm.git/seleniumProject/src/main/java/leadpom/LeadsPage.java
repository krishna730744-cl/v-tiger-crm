package leadpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LeadsPage {





	    WebDriver driver;

	    @FindBy(css = "img[alt='Create Lead...']")
	    private WebElement createLead;

	    public LeadsPage(WebDriver driver) {

	        this.driver = driver;

	        PageFactory.initElements(driver, this);
	    }

	    public void clickCreateLead() {

	        createLead.click();
	    }
	}

