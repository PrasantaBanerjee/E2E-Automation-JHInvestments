package org.jhi.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jhi.main.Base;
import org.jhi.page_objects.ViewpointsPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * @auth: Prasanta.
 * @desc: This class will contain all the test cases w.r.t Viewpoints page. 
 * 
 */
public class Validations_Viewpoints extends Base{

	ViewpointsPage viewpoints_page = new ViewpointsPage(getDriver());

	public void clickAndVerifyViewpointLinks() {
		WebElement link = viewpoints_page.viewpointTab();
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(link));
		link.click();
			
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Clicked on Viewpoints tab.");
		System.out.println();

		List<WebElement> availableViewpoints = viewpoints_page.allViewpointLinks();
		System.out.println("All the available Viewpoints in the page: ");
		int count=1;
		for(WebElement each : availableViewpoints) {
			System.out.println(count + ". " + each.getText());
			count++;
		}
		System.out.println();

		for(WebElement eachViewpoint : availableViewpoints) {
			String newTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
			eachViewpoint.sendKeys(newTab);
			System.out.println("Clicked on \"" + eachViewpoint.getText() + "\" viewpoint.");
			List<String>allWindows = new ArrayList<>(getDriver().getWindowHandles());
			getDriver().switchTo().window(allWindows.get(1));
			System.out.println("Switched to: " + getDriver().getTitle());
			System.out.println("URL: " + getDriver().getCurrentUrl());
			getDriver().close();
			System.out.println("Closed the tab.");
			getDriver().switchTo().window(allWindows.get(0));
			System.out.println("Switched back to Viewpoints page.");
			System.out.println();
		}
		System.out.println("All viewpoint links have been verified.");
	}
}