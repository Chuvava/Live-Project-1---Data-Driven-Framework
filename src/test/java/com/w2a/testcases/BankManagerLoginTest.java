package com.w2a.testcases;

import com.w2a.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {

    @Test
    public void loginAsBankManager() throws InterruptedException {



        log.debug("Inside Login Test");
        driver.findElement(By.xpath(OR.getProperty("bmlBtn"))).click();
        Thread.sleep(3000);

        Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addCustomerBtn"))), "Login was NOT successfull");

        Assert.fail("Failed it just for test");
        log.debug("Login successfully executed");
        Reporter.log("Login successfully executed");
    }
}
