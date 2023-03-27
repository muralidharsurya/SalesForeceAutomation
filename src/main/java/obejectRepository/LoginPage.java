package obejectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	  @FindBy(id="username")
	    private WebElement UserName;

	    @FindBy(id="password")
	    private WebElement Password;

	    @FindBy(name="Login")
	    private WebElement submitBtn;

	    public LoginPage(WebDriver driver){
	        PageFactory.initElements(driver,this);

	    }

	    public WebElement getUsername() {
	        return UserName;
	    }

	    public WebElement getPassword() {
	        return Password;
	    }

	    public WebElement getSubmitBtn() {
	        return submitBtn;
	    }
	    public void loginToApp(String username ,String password){
	       UserName.sendKeys(username);
	       Password.sendKeys(password);
	       submitBtn.click();

	    }

}
