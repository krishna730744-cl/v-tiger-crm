package emailpom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComposeEmailPage {
	@FindBy(xpath = "//img[@title='Select']")
    private WebElement contact;

    @FindBy(id = "subject")
    private WebElement subject;

    @FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement send;

    public ComposeEmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getContact() {
        return contact;
    }

    public WebElement getSubject() {
        return subject;
    }

    public WebElement getSend() {
        return send;
    }
}

