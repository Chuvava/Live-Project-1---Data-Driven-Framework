package com.w2a.testcases;

import com.w2a.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;

public class BankManagerLoginTest extends TestBase {

    @Test
    public void bankManagerLoginTest() throws InterruptedException, IOException {

        //verifyEquals("abc", "xyz");
        Thread.sleep(3000);
        log.debug("Inside Login Test");
        click("bmlBtn_XPATH");
        Thread.sleep(3000);

        Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addCustomerBtn_XPATH"))), "Login was NOT successfull");

        //Assert.fail("Failed it just for test");
        log.debug("Login successfully executed");
        Reporter.log("Login successfully executed");
    }
}
