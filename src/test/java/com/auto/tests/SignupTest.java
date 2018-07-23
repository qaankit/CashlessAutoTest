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
		Object [][]obj = new Object[1][1];
		for (int i=0;i<1;i++){
			obj[i][0]=ConfigProperties.invalidEmail+i;	
		}
		
		return obj;
	}
	
	@Test(priority=0)
	public void validationForSignupPage(){
		SignupPage signup = new SignupPage(driver);
		BasePage basepage = new BasePage(driver);
		
		log("Executing Test [validation For SignupPage Test]", ILogLevel.TEST);
		basepage.assertEquals(ConfigProperties.site_url, driver.getCurrentUrl());
		log("Url navigate to [" + ConfigProperties.site_url + "]", ILogLevel.TEST);
		signup.clickLink("Free Trial");
		signup.click("Sign Up");
		assertTrue(signup.verifyValidationMessage(0), "This field is required is not present");
	}
	
	@Test(priority=1, dataProvider="username")
	public void invalidSignup(String username){
		SignupPage signup = new SignupPage(driver);
		BasePage basepage = new BasePage(driver);
		
		log("Executing Test [Invalid Login Test]", ILogLevel.TEST);
		basepage.assertEquals(ConfigProperties.site_url, driver.getCurrentUrl());
		log("Url navigate to [" + ConfigProperties.site_url + "]", ILogLevel.TEST);
		signup.clickLink("Free Trial");
		signup.Enter(0, SignupPageObject.companyName);
		signup.Enter(1, SignupPageObject.name);
		signup.Enter(2, username);
		signup.Enter(3, SignupPageObject.mobileNumber);
		signup.select(4, SignupPageObject.selectIndustry);
		signup.select(5, SignupPageObject.selectCountry);
		signup.select(6, SignupPageObject.selectState);
		signup.Enter(7, SignupPageObject.city);
		signup.Enter(8, SignupPageObject.zipcode);
		signup.click("Sign Up");
		assertEquals(basepage.getText(By.cssSelector(SignupPageObject.invalidemailMessage_css)),"The email must be a valid email address.");	
	}
	
}
