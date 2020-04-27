package org.jhi.testcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jhi.main.Base;
import org.jhi.page_objects.AboutUsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * @auth: Prasanta.
 * @desc: This class will contain all the test cases w.r.t About us page. 
 * 
 */
public class Validations_AboutUs extends Base {

	AboutUsPage aboutus_page = new AboutUsPage(getDriver());

	public void navigateToAboutUs() {
		WebElement link = aboutus_page.aboutUsTab();
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(link));
		link.click();
			
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Clicked on About Us tab.");
		System.out.println();
	}
	
	public void validateSocialMediaLinks() {
		navigateToAboutUs();
		
		List<WebElement> allLinks = aboutus_page.socialLinks();
		for (WebElement eachLink : allLinks) {
			String linkUrl = eachLink.getAttribute("href");

			try {
				URL url = new URL(linkUrl);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setReadTimeout(30000);
				conn.connect();

				if (conn.getResponseCode() >= 400) {
					System.err.println(url.toString() + " -> " + conn.getResponseCode() + " " + conn.getResponseMessage());
				} else {
					System.out.println(url.toString() + " -> " + conn.getResponseCode() + " " + conn.getResponseMessage());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Completed validating all Social Media Links.");
	}
}