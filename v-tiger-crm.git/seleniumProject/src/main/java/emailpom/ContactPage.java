package emailpom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ContactPage {
	
	
	@FindBy(xpath = "//a[text()='Mary Smith']")
    private WebElement marySmith;

    public ContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getMarySmith() {
        return marySmith;
    }
}


