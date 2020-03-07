package automationpractice.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.relevantcodes.extentreports.LogStatus;

import automationpractice.base.Page;
import automationpractice.page.action.HomePage;
import automationpractice.page.action.LoginPage;
import automationpractice.utilities.ExcelReader;
import automationpractice.utilities.ExcelReaderwithDataProviderMethod;
import automationpractice.utilities.TestUtil;

public class LoginTest extends Page  {
	
	
	
		@BeforeMethod
		public void beforeMethod() {
			//Page.initConfiguration();
				//test.log(LogStatus.INFO, "Login Test started");
				//HomePage home = new HomePage();
				//home.gotoSignIn();
				//LoginPage login=new LoginPage();
			Page.initConfiguration();
			test.log(LogStatus.INFO, "Login Test started");
			HomePage home = new HomePage();
			home.gotoSignIn();
				}

	@Test(dataProvider="credential")
	public void loginTest(String username, String password, String meg) throws IOException{
		
				
		System.out.println("username:  " + username);
		
		System.out.println("password:  " + password );
		System.out.println("password:  " + meg );
		LoginPage login=new LoginPage();
		login.doLogin(username, password);
		String actual = Page.driver.getTitle();
		String expected="My account - My Store";
		Assert.assertEquals(actual, expected);
		test.log(LogStatus.INFO, "Login Test started");
	}
		
		// close the workbook
	@DataProvider(name="credential")
	public String [][] getExcelData() throws IOException{
		ExcelReaderwithDataProviderMethod read = new ExcelReaderwithDataProviderMethod();
		return read.passData("C:\\Users\\Ladzone\\eclipse-workspace\\automationpractice\\src\\test\\resources\\excel\\testdata.xlsx", "SignInTest");
		}
		
		//login.doLogin("alaylad@gmail.com", "alay123");
		//String actual = Page.driver.getTitle();
		//String expected="My account - My Store";
		//Assert.assertEquals(actual, expected);
		//test.log(LogStatus.INFO, "Login Test started");
		
		
		//Page.quitBrowser();
	
	@AfterMethod
	public void afterMethod() {
		Page.driver.quit();
	}

}