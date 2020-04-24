package org.jhi.page_objects;

import java.util.List;

import org.jhi.main.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewpointsPage extends Base {
	
	/*
	 * This class will serve as an Object Repository for Viewpoints page.
	 */
	
	WebDriver driver;
	public ViewpointsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h3[@class='topic-card__title']//a")
	private List<WebElement> viewpointLinks;
	
	@FindBy(xpath = "//aside[@class='site-sidebar']//li//div//div[text()='Viewpoints']")
	private WebElement viewpointTab;
	
	public List<WebElement> allViewpointLinks() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(viewpointLinks));
		return viewpointLinks;
	}
	
	public WebElement viewpointTab() {
		return viewpointTab;
	}

}
