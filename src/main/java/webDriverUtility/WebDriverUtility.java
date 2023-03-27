package webDriverUtility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class WebDriverUtility {
	/**
     * This method will maximize the window
     * @param driver
     */
    public void maximizeWindow(WebDriver driver)
    {
        driver.manage().window().maximize();
    }
    /**
     * This method will minimize the window
     * @param driver
     */
    public void minimizeWindow(WebDriver driver)
    {
        driver.manage().window().minimize();
    }
    /**
     * this method wait for the page load
     * @param driver
     */
    public void WaitForPage(WebDriver driver )
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    /**
     * This method will wait until the element becomes visible
     * @param driver
     * @param elemet
     */
    public void waitForElementToBeVisisble(WebDriver driver, WebElement elemet)
    {
        WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Wait.until(ExpectedConditions.visibilityOf(elemet));
    }
    /**
     * This method will wait until the element becomes clickable
     * @param driver
     * @param element
     */
    public void waitForElementToBeClickable(WebDriver driver, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    /**
     * This method will handle the drop down based on index
     * @param element
     * @param Index
     */
    public void handleDropDown(WebElement element,int Index)
    {
        Select sel = new Select(element);
        sel.selectByIndex(Index);
    }

    /**
     * This method will handle the drop down based on value
     * @param value
     * @param element
     */
    public void handleDropDown(String value,WebElement element)
    {
        Select sel = new Select(element);
        sel.selectByValue(value);
    }

    /**
     * This method will handle dropdown based on visible text
     * @param element
     * @param Text
     */
    public void handleDropDown(WebElement element,String Text)
    {
        Select sel = new Select(element);
        sel.selectByVisibleText(Text);
    }

    /**
     * This method will perform mouse hover action
     * @param driver
     * @param element
     */
    public void mouseHoverAction(WebDriver driver,WebElement element)
    {
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
    }

    /**
     * This method will perform right click anywhere in web page
     * @param driver
     */
    public void rightClickActions(WebDriver driver)
    {
        Actions act = new Actions(driver);
        act.contextClick().perform();
    }
    /**
     * this method will perform right click on a  web element
     * @param driver
     */
    public void rightClickAction(WebDriver driver,WebElement element)
    {
        Actions act = new Actions(driver);
        act.contextClick(element).perform();
    }

    /**
     * This method will perform double click anywhere on web page
     * @param driver
     */
    public void doubleClickAction(WebDriver driver)
    {
        Actions act = new Actions(driver);
        act.doubleClick().perform();
    }

    /**
     * This method will perform double click on a web element
     * @param driver
     * @param element
     */
    public void doubleClickAction(WebDriver driver, WebElement element)
    {
        Actions act = new Actions(driver);
        act.doubleClick(element).perform();
    }

    /**
     * This method will perform drag and drop action
     * @param driver
     * @param srcElement
     * @param dstElement
     */
    public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement dstElement)
    {
        Actions act = new Actions(driver);
        act.dragAndDrop(srcElement, dstElement).perform();
    }

    /**
     * this method will accept the alert
     * @param driver
     */
    public void acceptAlert(WebDriver driver)
    {
        driver.switchTo().alert().accept();
    }
    /**
     * This method will dismiss the alert
     * @param driver
     */
    public void dismissAlert(WebDriver driver)
    {
        driver.switchTo().alert().dismiss();
    }
    /**
     * this method will Capture the text from Alert popup
     * @param driver
     * @return
     */
    public String getAlertText(WebDriver driver)
    {
        return driver.switchTo().alert().getText();
    }
    /**
     * this method will handle frame based on index
     * @param driver
     * @param Index
     */
    public void handleFrame(WebDriver driver,int Index)
    {
        driver.switchTo().frame(Index);
    }
    /**
     * This method will handle frame based on name or ID
     * @param driver
     * @param nameOrId
     */
    public void handleFrame(WebDriver driver, String nameOrId)
    {
        driver.switchTo().frame(nameOrId);
    }
    /**
     * this method will handle frame based on Web element
     * @param driver
     * @param element
     */
    public void handleFrame(WebDriver driver,WebElement element)
    {
        driver.switchTo().frame(element);
    }
    /**
     * this method will switch to immediate parent frame
     * @param driver
     */
    public void switchToParentFrame(WebDriver driver)
    {
        driver.switchTo().parentFrame();
    }
    /**
     * this method will switch to deault frame
     * @param driver
     */
    public void switchToDefaultFrame(WebDriver driver)
    {
        driver.switchTo().defaultContent();
    }

    /**
     * This method will switch the window based on partial window title.
     * @param driver
     * @param partialWinTitle
     */
    public void switchToWindow(WebDriver driver,String partialWinTitle)
    {
        //step1: capture all the window ID'S
        Set<String> winIDs = driver.getWindowHandles();

        //step2: Navigate to each window
        for(String win:winIDs)
        {
            //Step3: switch to window and  capture the title
            String winTitle = driver.switchTo().window(win).getTitle();

            //step4: compare the title with required partial title
            if(winTitle.contains(partialWinTitle))
            {
                break;
            }
        }
    }

    /**
     * This method will take screen shot and save it in folder
     * @param driver
     * @param screenshotName
     * @return
     * @throws IOException
     */
    public String  takeScreenShot(WebDriver driver,String screenshotName) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dst = new File(".\\Screenshot\\"+screenshotName+".png");
        FileUtils.copyFile(src, dst);

        return dst.getAbsolutePath(); //used for extent Reports..
    }

    /**
     * this method will perform random scroll downwards vertically
     * @param driver
     */
    public void scrollAction(WebDriver driver)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0.500)", "");
    }

    /**
     * this method will scroll until the element is identified in DOM
     * @param driver
     * @param element
     */
    public void scrollAction(WebDriver driver,WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int y=element.getLocation().getY();
        js.executeScript("window.scrollBy(0."+y+")", element);
    }


}
