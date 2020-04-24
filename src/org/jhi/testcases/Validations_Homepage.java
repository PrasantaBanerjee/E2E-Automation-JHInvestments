package org.jhi.testcases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.jhi.main.Base;
import org.jhi.page_objects.HomePage;
import org.openqa.selenium.WebElement;

/*
 * @auth: Prasanta.
 * @desc: This class will contain all the test cases w.r.t Homepage. 
 * 
 */
public class Validations_Homepage extends Base {
	HomePage homepage = new HomePage(getDriver());

	public void TC1_validateHomepageUrl() {
		String pageUrl = getDriver().getCurrentUrl();
		String expectedUrl = "https://www.jhinvestments.com/";
		assertEquals(pageUrl, expectedUrl, "Mismatch found in Homepage URL.");
	}

	public void TC2_validateHomepageTitle() {
		String pageTitle = getDriver().getTitle();
		String expectedTitle = "John Hancock Investment Mgmt | A better way to invest";
		assertEquals(pageTitle, expectedTitle, "Mismatch found in Homepage Title.");
	}

	public void TC3_validateNavigationMenuOptions() {
		List<String> expectedMenuOptions = new ArrayList<>();
		Stream.of("Dashboard", "Investments", "Fund Compare", "Viewpoints", "Resources", "About us").forEach(x -> expectedMenuOptions.add(x));
		
		List<String> actualMenu = new ArrayList<>();
		List<WebElement> optionsAtExecution = homepage.getHomepageNavigMenu();
		optionsAtExecution.stream().forEach(x -> actualMenu.add(x.getText()));
		
		assertEquals(actualMenu, expectedMenuOptions);
	}
}