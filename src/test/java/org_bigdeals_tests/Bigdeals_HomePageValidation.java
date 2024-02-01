package org_bigdeals_tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import bussinessComponents.pageValidations;
import pages.Bigdeals_HomePage;
import pages.Bigdeals_LoginPage;
import pages.Bigdeals_ProductDetailsPage;
import pages.Bigdeals_ShoppingCartPage;

import static libs.ExcelUtils.getTableArray;

import java.time.Duration;


public class Bigdeals_HomePageValidation {
    public WebDriver driver;
    Bigdeals_HomePage HomePage = new Bigdeals_HomePage(driver);
    Bigdeals_LoginPage LoginPage = new Bigdeals_LoginPage(driver);
    Bigdeals_ShoppingCartPage ShoppingCartPage = new Bigdeals_ShoppingCartPage(driver);
    pageValidations pv = new pageValidations();
    public String baseurl = "https://bigdeals.lk/";

    
    //WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));



    @DataProvider
    public Object[][] TabValidation() throws Exception {
        Object[][] testObjArray = getTableArray("C:\\Users\\pathi\\eclipse-workspace\\Demo1\\testdata\\mainTabData.xlsx", "Sheet1");
        return (testObjArray);
    }

    @DataProvider
    public Object[][] SearchTest() throws Exception {
        Object[][] testObjArray2 = getTableArray("C:\\Users\\pathi\\eclipse-workspace\\Demo1\\testdata\\searchData.xlsx", "Sheet1");
        return (testObjArray2);
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

    @Test(dataProvider = "TabValidation")
    public void verifyHomepage(String testCaseName, String tabName, String url) throws InterruptedException {

        Bigdeals_HomePage HomePage = new Bigdeals_HomePage(driver);
        Bigdeals_LoginPage LoginPage = new Bigdeals_LoginPage(driver);

        //Validate main tabs
        HomePage.validateMainTabVavigation(tabName, url, baseurl);
    }

   /* @Test(dataProvider = "SearchTest")
    public void verifyMainSearch(String testCaseName, String searchText, String url) throws InterruptedException {

        Bigdeals_HomePage HomePage = new Bigdeals_HomePage(driver);
        Bigdeals_LoginPage LoginPage = new Bigdeals_LoginPage(driver);

        //Validate main tabs
        HomePage.validateMainSearch(searchText, url, baseurl);

    }*/

   /* @Test(dataProvider = "SearchTest")
    public void verifyAddingItemsToCart(String testCaseName, String searchText, String url) throws InterruptedException {

        Bigdeals_HomePage HomePage = new Bigdeals_HomePage(driver);
        Bigdeals_LoginPage LoginPage = new Bigdeals_LoginPage(driver);
        Bigdeals_ProductDetailsPage ProductDetailPage = new Bigdeals_ProductDetailsPage(driver);

        HomePage.validateMainSearch(searchText, url, baseurl);

       // ShoppingCartPage.validateAddedItemInShoppingCart();
       HomePage.buyNow();
        ProductDetailPage.addToCartFromProductDetailPage();
    }*/

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
