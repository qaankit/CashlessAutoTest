package com.auto.tests;



import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auto.base.BasePage;
import com.auto.base.ILogLevel;
import com.auto.base.TestCore;
import com.auto.configProperties.ConfigProperties;
import com.auto.pageObject.SignupPageObject;
import com.auto.pages.SignupPage;

public class SignupTest extends TestCore{
	
	@DataProvider(name="username")
	Object[][] getdata(){
		Object [][]obj = new Object[1][2];
			obj[0][0]=ConfigProperties.invalidEmail;
			obj[0][1]=ConfigProperties.invalidZipcode;
		
		return obj;
	}

	@Test(priority=0)
	public void validationForRegisterPage(){
		
		SignupPage signup = new SignupPage(driver);
		
		log("Executing Test [validation For Registration Page Test]", ILogLevel.TEST);
		assertEquals(ConfigProperties.site_url, driver.getCurrentUrl());
		log("Url navigate to [" + ConfigProperties.site_url + "]", ILogLevel.TEST);
		signup.clickLink("Free Trial");
		signup.click("Sign Up");
		assertTrue(signup.verifyValidationMessage(0), "This field is required is not present");
	}
	
	@Test(priority=1, dataProvider="username")
	public void invalidSignupONregisterPage(String username, String zipcode){
		
		SignupPage signup = new SignupPage(driver);
		BasePage basepage = new BasePage(driver);
		
		log("Executing Test [Invalid Registration Test]", ILogLevel.TEST);
		assertEquals(ConfigProperties.site_url, driver.getCurrentUrl());
		log("Url navigate to [" + ConfigProperties.site_url + "]", ILogLevel.TEST);
		signup.clickLink("Free Trial");
		signup.enterInput(0, SignupPageObject.companyName);
		signup.enterInput(1, SignupPageObject.name);
		signup.enterInput(2, username);
		signup.enterInput(3, SignupPageObject.mobileNumber);
		signup.select(4, SignupPageObject.selectIndustry);
		signup.select(5, SignupPageObject.selectCountry);
		signup.select(6, SignupPageObject.selectState);
		signup.enterInput(7, SignupPageObject.city);
		signup.enterInput(8, zipcode);
		signup.click("Sign Up");
		assertEquals(basepage.getTextWithIndex(By.cssSelector(SignupPageObject.validationMessage_css), 1), "Please enter at least 5 characters.");
	}
	
	@Test(priority=2)
	public void registrationNewUser(){
		
		SignupPage signup = new SignupPage(driver);
		
		log("Executing Test [New User Registration Test]", ILogLevel.TEST);
		assertEquals(ConfigProperties.site_url, driver.getCurrentUrl());
		log("Url navigate to [" + ConfigProperties.site_url + "]", ILogLevel.TEST);
		signup.clickLink("Free Trial");
		signup.enterInput(0, SignupPageObject.companyName);
		signup.enterInput(1, SignupPageObject.name);
		signup.enterInput(2, SignupPageObject.email);
		signup.enterInput(3, SignupPageObject.mobileNumber);
		signup.select(4, SignupPageObject.selectIndustry);
		signup.select(5, SignupPageObject.selectCountry);
		signup.select(6, SignupPageObject.selectState);
		signup.enterInput(7, SignupPageObject.city);
		signup.enterInput(8, SignupPageObject.zipcode);
		signup.click("Sign Up");
	}
	
	/*@Test(priority=3)
	public void activeAccountFromMail(){
		
		SignupPage signup = new SignupPage(driver);
		BasePage basepage = new BasePage(driver);
		
		log("Executing Test [Active Account from Mail Test]", ILogLevel.TEST);
		assertEquals(ConfigProperties.mailinator_url, driver.getCurrentUrl());
		log("Url navigate to [" + ConfigProperties.mailinator_url + "]", ILogLevel.TEST);
		
	}*/
}
