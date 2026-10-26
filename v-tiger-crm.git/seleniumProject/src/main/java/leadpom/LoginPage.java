package leadpom;
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

	    public void enterUsername(String usernameData) {

	        username.sendKeys(usernameData);
	    }

	    public void enterPassword(String passwordData) {

	        password.sendKeys(passwordData);
	    }
	    public void clickLogin() {
	        loginButton.click();
	    }
	}


