package org_bigdeals_tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import bussinessComponents.pageValidations;
import pages.*;

import static libs.ExcelUtils.getTableArray;
import static libs.ExcelUtils.getTableArray2;


public class Bigdeals_CheckoutShoppingCartValidation {
    public WebDriver driver;
    Bigdeals_HomePage HomePage = new Bigdeals_HomePage(driver);
    Bigdeals_LoginPage LoginPage = new Bigdeals_LoginPage(driver);
    pageValidations pv = new pageValidations();
    public String baseurl = "https://bigdeals.lk/";


    @DataProvider
    public Object[][] CheckOutTestData() throws Exception {

        Object[][] testObjArray = getTableArray2("C:\\Users\\pathi\\eclipse-workspace\\BigDeals_Project\\testdata\\checkOutData.xlsx", "Sheet1");

        return (testObjArray);
    }

    @BeforeTest
    public void LaunchBrowser() {
        System.out.println("Launching the Web application");
        //System.setProperty("webdriver.gecko.driver",driverpath);
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();

    }

    @BeforeMethod
    public void launchHomepage() {
        //Open bigdeals.lk home page
        driver.get(baseurl);

    }


    @Test(dataProvider = "CheckOutTestData")
    public void verifyCheckOutItemShoppingCartAfterAddingItem(String searchText,	String validationData,	String url,	String firstName,	String lastName,	String emaiAddress,	String phone,	String address) throws InterruptedException {

        Bigdeals_HomePage HomePage = new Bigdeals_HomePage(driver);
        Bigdeals_LoginPage LoginPage = new Bigdeals_LoginPage(driver);
        Bigdeals_ProductDetailsPage ProductDetailPage = new Bigdeals_ProductDetailsPage(driver);
        Bigdeals_ShoppingCartPage ShoppingCartPage = new Bigdeals_ShoppingCartPage(driver);
        Bigdeals_ShoppingCartDeleveryDedailPage DeleveryDedailPage = new Bigdeals_ShoppingCartDeleveryDedailPage(driver);

        HomePage.validateMainSearch(searchText, url, baseurl);

        //Validate Adding item to cart
        HomePage.buyNow();
        ProductDetailPage.addToCartFromProductDetailPage();

        ProductDetailPage.navigateToShoppingCart();

        //Validate cart
        ShoppingCartPage.validateAddedItemInShoppingCart();

        //Click on check out
        ShoppingCartPage.SecureCheckout();

        //Fill delevery data
        DeleveryDedailPage.FillDeleveryData(firstName,lastName,emaiAddress,phone,address);

        //Click on check out
        ShoppingCartPage.SecureCheckout();




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
