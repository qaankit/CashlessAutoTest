package com.auto.merchant;

import org.testng.annotations.Test;

import com.auto.base.BasePage;
import com.auto.base.TestCore;
import com.auto.configProperties.ConfigProperties;
import com.auto.pages.SignupPage;

public class SignupTest extends TestCore{
	
	@Test
	public void invalidSignup(){
		SignupPage signup = new SignupPage(driver);
		BasePage basepage = new BasePage(driver);
		
		basepage.assertEquals(ConfigProperties.site_url, driver.getCurrentUrl());
		signup.clickLink("Free Trial");
	}

}
