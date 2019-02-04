package com.w2a.testcases;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class AddCustomerTest extends TestBase {

    @Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
    public void addCustomerTest(Hashtable<String, String> data) throws InterruptedException {

        if(!data.get("runmode").equalsIgnoreCase("Y")) {

            throw new SkipException("Skipping the test case as the Run mode for data set is NO");
        }

        click("addCustomerBtn_XPATH");
        type("firstName_XPATH", data.get("firstname"));
        type("lastName_XPATH", data.get("lastname"));
        type("postCode_XPATH", data.get("postcode"));
        click("addBtn_XPATH");
        Thread.sleep(2000);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains(data.get("alerttext")));

        alert.accept();

        //Assert.fail("Failed it just for test");

    }


}
