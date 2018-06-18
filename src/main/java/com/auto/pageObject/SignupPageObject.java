package com.auto.pageObject;

import org.apache.commons.lang3.RandomStringUtils;
import com.auto.base.BasePage;

public class SignupPageObject {
	
	public static String companyName = "Testing";
	public static String name = "QA " + RandomStringUtils.random(10);
	public static String email = "QA" + BasePage.currentDate() + "@mailinator.com";
	public static String selectIndustry = "IT";
	public static String selectCountry = "USD";
	public static String selectState = "AK";
	public static String selectCity = "Aldgate";
	public static String zipcode = "45402";
	
	public static String freeTrailLink_xpath = "//a[contains(text(),'";
	public static String freeTrailLink_xpathA = "')]";
	public static String signupField_class = "form-control";
	public static String signupButton_css = ".btn.btn-primary.btn-block";
}
