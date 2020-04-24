package org.jhi.page_objects;

import java.util.List;
import org.jhi.main.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutUsPage extends Base{
	
	/*
	 * This class will serve as an Object Repository for About us page.
	 */
	
	WebDriver driver;
	public AboutUsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='row social-container']//a[@href]")
	private List<WebElement> socialMediaLinks;
	
	@FindBy(xpath = "//aside[@class='site-sidebar']//li//div//div[text()='About us']")
	private WebElement aboutUsTab;
	
	public List<WebElement> socialLinks(){
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(socialMediaLinks));
		return socialMediaLinks;
	}
	
	public WebElement aboutUsTab() {
		return aboutUsTab;
	}
	
}
