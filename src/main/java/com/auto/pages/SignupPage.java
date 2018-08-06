package com.auto.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.auto.base.BasePage;
import com.auto.base.ILogLevel;
import com.auto.pageObject.SignupPageObject;

public class SignupPage extends BasePage{

	public SignupPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickLink(String _value){
		click(By.xpath(SignupPageObject.freeTrailLink_xpath +_value+ SignupPageObject.freeTrailLink_xpathA), _value, 3);
	}
	
	public void enterInput(int _index, String _values){
		sendKeysByIndex(By.className(SignupPageObject.signupField_class), _index, _values, 3, _values);
	}
	
	public void select(int _index, String _values){
		dropdownSelectsByIndex(By.className(SignupPageObject.signupField_class), _index, _values);
	}
	
	public void click(String _btnName){
		click(By.xpath(SignupPageObject.signupButton_xpath + _btnName + SignupPageObject.singupButton_xpathB), _btnName, 3);
	}
	
	public boolean verifyValidationMessage(int _index) {
		List<WebElement> ele = driver.findElements(By.cssSelector(SignupPageObject.validationMessage_css));
		boolean heading = ele.get(_index).isDisplayed();
		String str = ele.get(_index).getText();

		if (heading) {
			log("This field is required." + str + " is present", ILogLevel.ASSERTS);
			return true;
		} else {
			log("This field is required." + str + " is not present", ILogLevel.ASSERTS);
			return false;
		}
	}

}
