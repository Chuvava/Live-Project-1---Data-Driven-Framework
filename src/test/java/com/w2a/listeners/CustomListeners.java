package com.w2a.listeners;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;
import org.testng.*;

import java.io.IOException;

public class CustomListeners extends TestBase implements ITestListener {

    public void onTestStart(ITestResult result) {

        test = rep.startTest(result.getName());
        //runmodes - y
        if(!TestUtil.isTestRunnable(result.getName(), excel)){
            throw new SkipException("Skipping the test '" + result.getName().toUpperCase() +  "' as the Run mode is NO");
        }
    }

    public void onTestSuccess(ITestResult result) {

        test.log(LogStatus.PASS, result.getName() + " PASS");
        rep.endTest(test);
        rep.flush();
    }

    public void onTestFailure(ITestResult result) {
        //added for correct showing sreenshot link in the html report
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        try {
            TestUtil.captureScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.log(LogStatus.FAIL, result.getName() + " FAILED with exception : " + result.getThrowable());
        test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenShotName));

        Reporter.log("Click to see ScreenShot");
        Reporter.log("<a target=\"_blank\" href=\"" + TestUtil.screenShotName + "\">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href=\"\"" + TestUtil.screenShotName + "\">" +
                "<img src=\"" + TestUtil.screenShotName + "\" height=200 width=200></img></a>");
        rep.endTest(test);
        rep.flush();
    }

    public void onTestSkipped(ITestResult result) {

        test.log(LogStatus.SKIP, result.getName().toUpperCase() + " Skipped the test as the Run mode is NO");
        rep.endTest(test);
        rep.flush();
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}
