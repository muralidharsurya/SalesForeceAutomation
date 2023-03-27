package testCases;

import org.testng.annotations.Test;

import genericUtilities.BasePage;
import obejectRepository.CreateNewUser;
import obejectRepository.HomePage;
import obejectRepository.LoginPage;
@Test
public class SalesForceHomepage  extends BasePage{

  public void homepageTest() {
   HomePage hp=new HomePage(sDriver);
   hp.clikOnAccounts();
  }
 
 public void newAccountUser() throws Exception {
	 CreateNewUser cn = new CreateNewUser(sDriver);
	 cn.clickOn();
	 
 }
  
}
