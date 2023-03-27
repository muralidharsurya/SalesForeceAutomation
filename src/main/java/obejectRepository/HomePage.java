package obejectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webDriverUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	 @FindBy(xpath="//a[@title='Accounts']")
     private WebElement Accounts;
	 
   @FindBy(xpath="//a[@title='Contacts']")
   private WebElement Contacts;

   @FindBy(xpath="(//img[@title='User'])[1]")
   private WebElement ViewProfile;

   @FindBy(xpath="//a[text()='Log Out']")
   private WebElement Logout;



//initializtion
   public HomePage(WebDriver driver) {
       PageFactory.initElements(driver,this);
   }

   public WebElement getAccounts() {
       return Accounts;
   }

   public WebElement getContacts() {
       return Contacts;
   }

   public WebElement getViewProfile() {
       return ViewProfile;
   }

   public WebElement getLogout() {
       return Logout;
   }

  public void  clikOnAccounts(){
       Accounts.click();
  }
  public void  clickOnViewProfile(){
       ViewProfile.click();
  }
  public void  logoutOfApp(WebDriver driver){
       mouseHoverAction(driver,Logout);
       Logout.click();
  }

}
