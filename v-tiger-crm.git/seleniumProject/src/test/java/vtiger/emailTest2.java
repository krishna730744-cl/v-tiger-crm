package vtiger;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import emailpom.ComposeEmailPage;
import emailpom.ContactPopupPage;
import emailpom.EmailPage;

import emailpom.LoginPage;
import reuseble.jsonExtraction;
import utility.BaseTest;
@Listeners(listeners.TestListeners.class)
public class emailTest2 extends BaseTest{
@Test
	p																							ublic  void leadTestyu() throws Exception{
   // Email Page
        EmailPage emailPage = new EmailPage(driver);

        emailPage.getEmail().click();

        emailPage.getCompose().click();

        Thread.sleep(1000);

        String pid = driver.getWindowHandle();

        Set<String> oldWindow = driver.getWindowHandles();

        for (String windowHandle : oldWindow) {

            if (!windowHandle.equals(pid)) {

                driver.switchTo().window(windowHandle);
                break;
            }
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        System.out.println(driver.getTitle());

        // Compose Email Page
        ComposeEmailPage composeEmailPage = new ComposeEmailPage(driver);

        composeEmailPage.getContact().click();

        Set<String> allWindow = driver.getWindowHandles();

        for (String window : allWindow) {

            if (!oldWindow.contains(window)) {

                driver.switchTo().window(window);
                break;
            }
        }

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait1.until(ExpectedConditions.numberOfWindowsToBe(3));

        System.out.println(driver.getTitle());

        // Contact Popup Page
        ContactPopupPage contactPopupPage = new ContactPopupPage(driver);

        contactPopupPage.getMarySmith().click();

        Set<String> newwindow = driver.getWindowHandles();

        for (String windowHandle1 : newwindow) {

            if (!windowHandle1.equals(pid)) {

                driver.switchTo().window(windowHandle1);
                break;
            }
        }

        // Compose Email Page
        String subject=jsonExtraction.jsonextr("subject");
        composeEmailPage.getSubject().sendKeys(subject);

        composeEmailPage.getSend().click();
        driver.switchTo().window(pid);

        Thread.sleep(4000);

       
    }
}