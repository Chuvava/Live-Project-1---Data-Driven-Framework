package com.w2a.base;

import com.w2a.utilities.ExcelReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    /*
     * WebDriver - done
     * Properties - done
     * Logs - log4j jar, .log, log4j.properties
     * ExtentReports
     * DB
     * Excel
     * Mail
     * ReportNG, ExtentReports
     * Jenkins
     *
     * */

    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    public static String userDir = System.getProperty("user.dir");
    public static Logger log = Logger.getLogger("devpinoyLogger");
    public static ExcelReader excel = new ExcelReader(userDir + "\\src\\test\\resources\\excel\\testdata.xlsx");
//    public static final String testDataExcelFileName = "testdata.xlsx";
    public static WebDriverWait wait;

    @BeforeSuite
    public void setUp() throws IOException {


        if (driver == null) {
            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
            config.load(fis);
            log.debug("Config file loaded!");

            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
            OR.load(fis);
            log.debug("OR file loaded!");

            if (config.getProperty("browser").equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", userDir + "\\src\\test\\resources\\executables\\geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", userDir + "\\src\\test\\resources\\executables\\chromedriver.exe");
                driver = new ChromeDriver();
                log.debug("Chrome launched!");
            } else if (config.getProperty("browser").equalsIgnoreCase("ie")) {
                System.setProperty("webdriver.ie.driver", userDir + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }

            driver.get(config.getProperty("testsiteurl"));
            log.debug("Navigated to : " + config.getProperty("testsiteurl"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Long.parseLong(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 5);
        }
    }

    @AfterSuite
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }

        log.debug("Test execution completed !!!");
    }

    public boolean isElementPresent(By by) {

        try {

            driver.findElement(by);
            return true;

        } catch (NoSuchElementException e) {

            return false;
        }
    }

}
