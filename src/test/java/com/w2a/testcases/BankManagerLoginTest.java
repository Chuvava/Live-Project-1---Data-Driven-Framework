package com.w2a.testcases;

import com.w2a.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {

    @Test
    public void loginAsBankManager() throws InterruptedException {

        //added for correct showing sreenshot link in the html report
        System.setProperty("org.uncommons.reportng.escape-output", "false");

        log.debug("Inside Login Test");
        driver.findElement(By.xpath(OR.getProperty("bmlBtn"))).click();
        Thread.sleep(3000);

        Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addCustomerBtn"))), "Login was NOT successfull");

        log.debug("Login successfully executed");
        Reporter.log("Login successfully executed");
        Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\aefimov\\Downloads\\actualCompanyLogo.png\">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\aefimov\\Downloads\\actualCompanyLogo.png\">" +
                "<img src=\"C:\\Users\\aefimov\\Downloads\\actualCompanyLogo.png\" height=200 width=200></img></a>");
    }
}
