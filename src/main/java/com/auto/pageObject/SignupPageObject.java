package com.auto.pageObject;

import org.apache.commons.lang3.RandomStringUtils;

import com.auto.base.BasePage;

public class SignupPageObject {
	
	public static String companyName = RandomStringUtils.randomAlphabetic(15);
	public static String name = RandomStringUtils.randomAlphabetic(15);
	public static String email = name + "@mailinator.com";
	public static String mobileNumber = BasePage.autogenerateNumber(10);
	public static String selectIndustry = "Tech Support";
	public static String selectCountry = "USA";
	public static String selectState = "California";
	public static String city = RandomStringUtils.randomAlphabetic(7);
	public static String zipcode = BasePage.autogenerateNumber(5);
	
	public static String freeTrailLink_xpath = "//a[contains(text(),'";
	public static String freeTrailLink_xpathA = "')]";
	public static String signupField_class = "form-control";
	public static String signupButton_xpath = "//button[contains(text(),'";
	public static String singupButton_xpathB = "')]";
	public static  String validationMessage_css = ".error";
	public static  String invalidemailMessage_css = ".error.small";
}
