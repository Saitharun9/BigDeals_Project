package org_bigdeals_tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import bussinessComponents.pageValidations;
import pages.Bigdeals_HomePage;
import pages.Bigdeals_LoginPage;

import static libs.ExcelUtils.getTableArray;


public class Bigdeals_Login {
    public WebDriver driver;
    Bigdeals_HomePage HomePage = new Bigdeals_HomePage(driver);
    Bigdeals_LoginPage LoginPage = new Bigdeals_LoginPage(driver);
    pageValidations pv = new pageValidations();
    public String baseurl = "https://bigdeals.lk/";




    @DataProvider
    public Object[][] Authentication() throws Exception {

        Object[][] testObjArray = getTableArray("C:\\Users\\pathi\\eclipse-workspace\\Demo1\\testdata\\bigdealsUserData.xlsx", "Sheet1");

        return (testObjArray);
    }

    @BeforeTest
    public void LaunchBrowser() {
        System.out.println("Launching the Web application");
        //System.setProperty("webdriver.gecko.driver",driverpath);
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        //driver = new EdgeDriver();

    }

    @BeforeMethod
    public void launchHomepage() {
        //Open bigdeals.lk home page
        driver.get(baseurl);

    }

    @Test(dataProvider = "Authentication")
    public void verifyHomepage(String userName, String password, String name) throws Exception {

        Bigdeals_HomePage HomePage = new Bigdeals_HomePage(driver);
        Bigdeals_LoginPage LoginPage = new Bigdeals_LoginPage(driver);

        //Navigate to login page
        HomePage.navigateToLogin();

        //Login to Bigdeals.lk
        LoginPage.loginToBigdeals(userName,password);

        //Verify user landing page
        pv.validateUserLandingPage(driver, baseurl, name);

        //Sign out
        LoginPage.logoutFromBigdeals(driver);

    }

    @AfterMethod
    public void logout() throws InterruptedException {
        Thread.sleep(1000);
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        //driver.quit();
    }
}
