package automationpractice.page.action;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationpractice.base.Page;
import automationpractice.page.locators.AccountPageLocators;
import automationpractice.page.locators.CartPageLocators;
import automationpractice.page.locators.CheckoutPageLocators;
import automationpractice.page.locators.ClothesPageLocators;
import automationpractice.page.locators.CreateAccountFormPageLocatores;
import automationpractice.page.locators.CreateAccountPageLocatores;
import automationpractice.page.locators.HomePageLocators;
import automationpractice.page.locators.PayPageLocators;
import automationpractice.page.locators.SignInFormPageLocatores;
import rough.Checkoutjunk;

public class AccountPage extends Page {

	public CheckoutPageLocators checkout;
	public ClothesPageLocators clothesPage;
	public SignInFormPageLocatores login;
	public Checkoutjunk junk;
	public CartPageLocators cartproceed;
	public PayPageLocators pay;
	
	public HomePageLocators home;
	static CreateAccountPageLocatores createAccount;
	public CreateAccountFormPageLocatores createAccountForm;
	public SignInFormPageLocatores signin;
	public AccountPageLocators account;
	public AccountPage() {
		this.junk=new Checkoutjunk();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.junk);
		
	
	}
		
	public void authenticationPage() {
		//test.log(LogStatus.INFO, "SignIn Test started");
		createAccount = new CreateAccountPageLocatores(driver);
		createAccountForm = new CreateAccountFormPageLocatores(driver);
		signin = new SignInFormPageLocatores(driver);
		account = new AccountPageLocators(driver);
		HomePage home=new HomePage();
		home.gotoSignIn();
		//test.log(LogStatus.INFO, "SignIn Test ended");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Login - My Store";
		Assert.assertEquals(actualTitle, expectedTitle);
	
		
		//home.signInBtn.click();
		
		Assert.assertTrue(createAccount.getCreateAccountForm().isDisplayed());
		Assert.assertTrue(createAccount.getCreatAccountEmailField().isDisplayed());
		Assert.assertTrue(createAccount.getCreateAccountBtn().isDisplayed());
		Assert.assertTrue(signin.getSignInForm().isDisplayed());
		
		//Assert.assertTrue(CreateAccountPageLocatores.getCreateAccountForm().isDisplayed());
		//Page.quitBrowser()

	}
	
	public void authenticationPageEmailField() {
		// Without email
		createAccount.getCreateAccountBtn().click();

		Assert.assertTrue(createAccount.getEmailErrorMessage().isDisplayed());

		// Wrong email format (mapko89ct, mapko89ct@gmail ...)
		createAccount.setCreateAccountEmailField("marko");
		createAccount.getCreateAccountBtn().click();

		Assert.assertTrue(createAccount.getEmailErrorMessage().isDisplayed());
		Assert.assertTrue(createAccount.getEmailFieldHighlightedRed().isDisplayed());

		// Registered email
		createAccount.setCreateAccountEmailField("email@email.email");
		createAccount.getCreateAccountBtn().click();

		Assert.assertTrue(createAccount.getEmailBeenRegistered().isDisplayed());

		// Correct email
		createAccount.setCreateAccountEmailField("mapko123ct@gmail.com");
		createAccount.getCreateAccountBtn().click();

		Assert.assertTrue(createAccountForm.getAccountCreationForm().isDisplayed());
	}
}
