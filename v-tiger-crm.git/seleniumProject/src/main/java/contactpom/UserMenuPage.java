package contactpom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class UserMenuPage {
	





	    private WebDriver driver;

	    @FindBy(css = "img[src='themes/softed/images/user.PNG']")
	    private WebElement profile;

	    @FindBy(linkText = "Sign Out")
	    private WebElement signOut;

	    public UserMenuPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void logout() {

	        Actions act = new Actions(driver);

	        act.moveToElement(profile).perform();

	        signOut.click();
	    }
	
}
