package leadpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LeadDetailsPage {

	 WebDriver driver;

	    @FindBy(id = "dtlview_Last Name")
	    private WebElement actualLastName;

	    @FindBy(id = "dtlview_Company")
	    private WebElement actualCompanyName;

	    public LeadDetailsPage(WebDriver driver) {

	        this.driver = driver;

	        PageFactory.initElements(driver, this);
	    }

	    public String getLastName() {

	        return actualLastName.getText();
	    }

	    public String getCompanyName() {

	        return actualCompanyName.getText();
	    }
	
}
