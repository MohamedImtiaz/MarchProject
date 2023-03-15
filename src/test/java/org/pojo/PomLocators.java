package org.pojo;

import org.global.BassFile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.FieldValue;

public class PomLocators extends  BassFile {
	
public PomLocators() {
	
	PageFactory.initElements(driver, this);
}

@FindBy(id="firstName")
private WebElement userFirstName;

public WebElement getUserFirstName() {
	return userFirstName;
}
@FindBy(id="lastName")
private WebElement userLastName;

public WebElement getUserLastName() {
	return userLastName;
}
@FindBy(id="userEmail")
private WebElement usermail;

public WebElement getUsermail() {
	return usermail;
}
@FindBy(xpath="//label[text()='Male']")
private WebElement userGender;

public WebElement getUserGender() {
	return userGender;
}
@FindBy(id="userNumber")
private WebElement userContactNumber;

public WebElement getUserContactNumber() {
	return userContactNumber;
}
@FindBy(xpath="//div[@aria-label='Choose Tuesday, September 24th, 1996']")
private WebElement userDob;

public WebElement getUserDob() {
	return userDob;
}
@FindBy(id="dateOfBirthInput")
private WebElement dateOfBirth;

public WebElement getDateOfBirth() {
	return dateOfBirth;
}
@FindBy(xpath="//label[text()='Sports']")
private WebElement hob;

public WebElement getHob() {
	return hob;
}
@FindBy(xpath="//textarea[@placeholder='Current Address']")
private WebElement addre;

public WebElement getAddre() {
	return addre;
}
}
