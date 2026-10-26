package emailpom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage {
    @FindBy(xpath = "//a[text()='Email']")
    private WebElement email;

    @FindBy(xpath = "//a[text()='Compose']")
    private WebElement compose;

    public EmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getCompose() {
        return compose;
    }
}

