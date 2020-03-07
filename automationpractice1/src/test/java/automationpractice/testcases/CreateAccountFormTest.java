package automationpractice.testcases;

import org.testng.annotations.Test;

import automationpractice.base.Page;
import automationpractice.page.action.AccountPage;
import automationpractice.page.action.HomePage;

public class CreateAccountFormTest {


	@Test(priority = 1)
	public void signInTest() {

		Page.initConfiguration();
		//test.log(LogStatus.INFO, "SignIn Test started");
		AccountPage home=new AccountPage();
		home.authenticationPage();
		//test.log(LogStatus.INFO, "SignIn Test ended");
		//Page.quitBrowser();	

	}
	
	
	
	@Test(priority = 2)
	public void authentication() {

		//Page.initConfiguration();
		//test.log(LogStatus.INFO, "SignIn Test started");
		AccountPage home=new AccountPage();
		home.authenticationPageEmailField();
		//test.log(LogStatus.INFO, "SignIn Test ended");
		//Page.quitBrowser();	

	}

}
