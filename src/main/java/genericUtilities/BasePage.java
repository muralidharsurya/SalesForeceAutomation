package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import obejectRepository.HomePage;
import obejectRepository.LoginPage;
import webDriverUtility.WebDriverUtility;

public class BasePage {

	  public PropertyFileUtility pUtil = new PropertyFileUtility();
	    public ExcelFileUtility eUtil = new ExcelFileUtility();
	     public WebDriverUtility wUtil = new WebDriverUtility();
	    public DateUtility du = new DateUtility();
	    public static WebDriver sDriver; //Listeners
	    WebDriver driver;
	    @BeforeSuite(groups = "smokeSuit")
	    public void bsConfig() {
	        System.out.println("---Data connection successfully---");
	    }

	    @BeforeClass(groups = "smokeSuit")
	    public void bcConfig() throws IOException {
	        String URL = pUtil.readDataFromPropertyFile("url");
	       
	        String BROWSER = pUtil.readDataFromPropertyFile("browser");

	        // Step 2: Launch the browser - runtime polymorphism

	        if (BROWSER.equalsIgnoreCase("chrome"))
	        {
	            WebDriverManager.chromedriver().setup();
	            driver= new ChromeDriver();
	            System.out.println("----- "+BROWSER+" Launched succesfully-----");
	        }
	        else if (BROWSER.equalsIgnoreCase("firefox"))
	        {
	            WebDriverManager.firefoxdriver().setup();
	         driver = new FirefoxDriver();
	            System.out.println("----- "+BROWSER+" Launched successfully-----");
	        }
	        else
	        {
	            System.out.println("Invalid Browser name");
	        }

	        sDriver=driver; //listeners
	        wUtil.maximizeWindow(driver);
	        wUtil.WaitForPage(driver);
	        driver.get(URL);
	    }

	    @BeforeMethod(groups = "smokeSuit")
	    public void bmConfig() throws IOException {
	        String USERNAME = pUtil.readDataFromPropertyFile("username");
	        String PASSWORD = pUtil.readDataFromPropertyFile("password");

	        LoginPage lp = new LoginPage(driver);
	        lp.loginToApp(USERNAME, PASSWORD);

	        System.out.println("----- Login successful -----");
	    }

	    @AfterMethod(groups = "smokeSuite")
	    public void amConfig() {
	        HomePage hp = new HomePage(driver);
	        hp.logoutOfApp(driver);
	        System.out.println("----- Logout successful -----");
	        
	    }

	    @AfterClass(groups = "smokeSuite")
	    public void acConfig() {
	        driver.quit();
	        System.out.println("----- Browser Closed successfully -----");
	    }

	    @AfterSuite(groups = "smokeSuite")
	    public void asConfig() {

	        System.out.println("----- Database Connection successfull -----");
	    }




}
