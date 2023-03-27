package genericUtilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import webDriverUtility.WebDriverUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class ListenersImplementation  implements ITestListener{

	ExtentReports report;
    ExtentTest test;
    public void onTestStart(ITestResult result) {
       String  methodName = result.getMethod().getMethodName();
        System.out.println(methodName+"---Execution Started");
        test =report.createTest(methodName);
    }

    public void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        System.out.println(methodName+"---passed");

        test.log(Status.PASS, methodName+"---pass");

    }
   public void onTestFailure(ITestResult result) {
        DateUtility  du = new   DateUtility();
        WebDriverUtility wUtil = new WebDriverUtility();
        String methodName= result.getMethod().getMethodName();
        test.log(Status.FAIL,methodName+"---Fail");
        test.log(Status.INFO,result.getThrowable());
        String ScreenshotName=methodName+"-"+du.getSystemDateInFormat();
        try {
                wUtil.takeScreenShot(BasePage.sDriver, ScreenshotName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    public void onTestSkipped(ITestResult result) {

        String methodName = result.getMethod().getMethodName();
        System.out.println(methodName+"---SKIP");
        test.log(Status.INFO, result.getThrowable());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    public void onStart(ITestContext context) {
        System.out.println("suit execution started");

        ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\src\\ExtentReports"+new DateUtility().getSystemDateInFormat()+".html");
        htmlReport.config().setDocumentTitle("SalesForce Execution Reports");
        htmlReport.config().setTheme(Theme.DARK);
        htmlReport.config().setReportName("SalesForce EXECUTION REPORT");

        report = new ExtentReports();
        report.attachReporter(htmlReport);
        report.setSystemInfo("Base URL", "url");
        report.setSystemInfo("Base Browser", "chrome");
        report.setSystemInfo("Reporter Name", "surya");
    }

    public void onFinish(ITestContext context) {
        System.out.println("suit executed finished");
           report.flush();

    }}
	
	    

	    
	    
