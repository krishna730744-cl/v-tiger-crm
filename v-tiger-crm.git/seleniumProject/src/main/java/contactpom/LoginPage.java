package contactpom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
 WebDriver driver;

	    @FindBy(name = "user_name")
	    private WebElement username;

	    @FindBy(name = "user_password")
	    private WebElement password;

	    @FindBy(id = "submitButton")
	    private WebElement loginButton;

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void enterUsername(String usernam) {
	        username.sendKeys(usernam);
	    }

	    public void enterPassword(String passwor) {
	        password.sendKeys(passwor);
	    }

	    public void clickLogin() {
	        loginButton.click();
	    }
	}


