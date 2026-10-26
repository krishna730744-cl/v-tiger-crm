package reuseble;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	
	WebDriver driver;
	public WebDriverUtility(WebDriver driver) {
		this.driver=driver;
	}
	public void hover(WebElement element) {
		
		Actions act= new Actions(driver);
		act.moveToElement(element).build().perform();
		
	}
	public void rightClick(WebElement element) {
		
		Actions act= new Actions(driver);
		act.contextClick(element).build().perform();
		
	}
	
	public void select(WebElement element,int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
		
	
	}
	public void select(WebElement element,String value) {
		Select sel = new Select(element);
		sel.selectByContainsVisibleText(value);
		
		
	}
	public void select(String value,WebElement element) {
		Select sel = new Select(element);
		sel.deselectByValue(value);
		
	
	}
	
	
	
	
	
	

}
