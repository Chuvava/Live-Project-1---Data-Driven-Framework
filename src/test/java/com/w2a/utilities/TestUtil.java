package com.w2a.utilities;

import com.w2a.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestUtil extends TestBase {

    public static String screenShotPath = "\\target\\surefire-reports\\html\\";
    public static String screenShotName;

    public static void captureScreenshot() throws IOException {

        Date d = new Date();
        screenShotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + screenShotPath + screenShotName));
    }
}
