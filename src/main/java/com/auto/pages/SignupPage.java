package com.auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.auto.base.BasePage;
import com.auto.pageObject.SignupPageObject;

public class SignupPage extends BasePage{

	public SignupPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickLink(String _value){
		click(By.xpath(SignupPageObject.freeTrailLink_xpath +_value+ SignupPageObject.freeTrailLink_xpathA), _value, 3);
	}
	
	public void enter(int _index, String _values){
		sendKeysByIndex(By.className(SignupPageObject.signupField_class), _index, _values, 3, _values);
	}
	
	public void select(int _index, String _values){
		dropdownSelectsByIndex(By.className(SignupPageObject.signupField_class), _index, _values);
	}
	
	public void click(String _btnName){
		click(By.cssSelector(SignupPageObject.signupButton_css), _btnName, 3);
	}

}
