package com.regression.gmail;

import org.testng.annotations.Test;
import com.gmail.businessfunctions.gmailHomePage;
import com.svsseleniumjava.utilities.TestBase;

public class TC_01_Gmail_LoginAndSendEmail_Logout extends TestBase {

	gmailHomePage gHomePage;

	String actSText = "Sign in";

	String uName = utility.getPropertyValue("ValidUserName");
	String password = utility.getPropertyValue("ValidPassword");

	@Test
	public void LoginSendEmailLogout() throws InterruptedException {

		gHomePage = new gmailHomePage(driver);
		gHomePage.verifySignInText(actSText);
		gHomePage.verifyCreateAccountLinkAvailable();
		gHomePage.verifyNextBtnAvailable();
		gHomePage.enterUserName(uName);
		gHomePage.enterPassword(password);

	}

}
