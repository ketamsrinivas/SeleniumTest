package com.gmail.businessfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class gmailHomePage {

	public WebDriver driver;
	public WebDriverWait wait;

	public gmailHomePage(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, 100);

	}

	// Webelements:
	By signInTxt = By.xpath("//*[@id='headingText']/span");
	// By createAckBtn = By.xpath("//*[contains(@id,'ow310') and
	// contains(@class,'U26fgb c7fp5b FS4hgd FliLIb uRo0Xe
	// t29vte')]/span/span");
	By createAckBtn = By.xpath("//*[@id='ow310']");

	By nxtBtn = By.xpath("//*[@id='identifierNext']/span/span");
	By email = By.id("identifierId");
	By passwordFiled = By.id("password");

	// write Methods here.Login into gmail to Send an email and Logout

	public String verifySignInText(String actSText) {

		String expSTxt = driver.findElement(signInTxt).getText();
		Assert.assertEquals(actSText, expSTxt, "Text is not available");
		return expSTxt;

	}

	public boolean verifyCreateAccountLinkAvailable() {

		try {
			// WebElement ackBtn =
			// wait.until(ExpectedConditions.visibilityOfElementLocated(createAckBtn));
			WebElement ackBtn = driver.findElement(createAckBtn);
			if (ackBtn.isDisplayed()) {
				System.out.println("<Create account Link is Displayed>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("<Create account Link is not Displayed>");
		}
		return true;

	}

	public void verifyNextBtnAvailable() {
		try {
			WebElement hompageNxtBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(nxtBtn));
			// Assert.assertEquals(hompageNxtBtn.isDisplayed(), "<Gmail Home
			// Page, Next button is displayed>");
			if (hompageNxtBtn.isDisplayed()) {

				System.out.println("<Gmail Home Page, Next button is displayed>");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("<Gmail Home page, Next button is not displayed>");
		}
	}

	public void enterUserName(String userName) {

	
		wait.until(ExpectedConditions.visibilityOfElementLocated(email));
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(userName);
		driver.findElement(nxtBtn).click();
		
		// if neccessary use the Javascript button whenever it is required.

	}
	
	public void enterPassword(String password) throws InterruptedException{
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFiled)).clear();
		driver.findElement(passwordFiled).sendKeys(password);
		driver.findElement(nxtBtn).click();
		
		
	}
	
	
	

}
