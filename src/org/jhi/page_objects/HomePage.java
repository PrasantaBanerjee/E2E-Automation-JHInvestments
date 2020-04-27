package org.jhi.page_objects;

import java.util.List;

import org.jhi.main.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Base {
	
	/*
	 * This class will serve as an Object Repository for Homepage.
	 */
	
	WebDriver driver; 	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//div[@class='primary-nav-item u-flex-sm']//div")
	private List<WebElement> allMenuOptions;

	public List<WebElement> getHomepageNavigMenu() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(allMenuOptions));
		return allMenuOptions;	
	}
	
}
