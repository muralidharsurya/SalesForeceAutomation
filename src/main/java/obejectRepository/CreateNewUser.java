package obejectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webDriverUtility.WebDriverUtility;

public class CreateNewUser extends WebDriverUtility {
	@FindBy(xpath="//a[@title='New']")
	private WebElement New;
	
	@FindBy(xpath="(//input[@role='combobox'])[1]")
	private WebElement SendName;
	
	@FindBy(xpath ="//button[@title='Save']")
	private WebElement Save;
	

	public CreateNewUser(WebDriver driver) {
		 PageFactory.initElements(driver,this);
	}


	public WebElement getNew() {
		return New;
	}

	public WebElement getSendName() {
		return SendName;
	}


	public WebElement getSave() {
		return Save;
	}

	public void clickOn() throws Exception {
		New.click();
	}


	
		
	}


	

	


	

