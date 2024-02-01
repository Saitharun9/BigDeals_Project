package org_bigdeals_tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import bussinessComponents.pageValidations;
import pages.Bigdeals_HomePage;
import pages.Bigdeals_LoginPage;
import pages.Bigdeals_ProductDetailsPage;
import pages.Bigdeals_ShoppingCartPage;

import static libs.ExcelUtils.getTableArray;


public class Bigdeals_ShoppingCartValidation {
    public WebDriver driver;
    Bigdeals_HomePage HomePage = new Bigdeals_HomePage(driver);
    Bigdeals_LoginPage LoginPage = new Bigdeals_LoginPage(driver);
    pageValidations pv = new pageValidations();
    public String baseurl = "https://bigdeals.lk/";


    @DataProvider
    public Object[][] SearchTest() throws Exception {

        Object[][] testObjArray = getTableArray("C:\\Users\\pathi\\eclipse-workspace\\Demo1\\testdata\\searchData.xlsx", "Sheet1");

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
        //Open Bigdeals.lk  home page
        driver.get(baseurl);

    }

    @Test(dataProvider = "SearchTest")
    public void verifyShoppingCartAfterAddingItem(String testCaseName, String searchText, String url) throws InterruptedException {

        Bigdeals_HomePage HomePage = new Bigdeals_HomePage(driver);
        Bigdeals_LoginPage LoginPage = new Bigdeals_LoginPage(driver);
        Bigdeals_ProductDetailsPage ProductDetailPage = new Bigdeals_ProductDetailsPage(driver);
        Bigdeals_ShoppingCartPage ShoppingCartPage = new Bigdeals_ShoppingCartPage(driver);

        HomePage.validateMainSearch(searchText, url, baseurl);

        //Validate Adding item to cart
        HomePage.buyNow();
        ProductDetailPage.addToCartFromProductDetailPage();

        ProductDetailPage.navigateToShoppingCart();

      //Validate cart
        ShoppingCartPage.validateAddedItemInShoppingCart();

        //Delete item
        ShoppingCartPage.deleteItemFromShoppingCart();


    }

   /* @Test(dataProvider = "SearchTest")
    public void verifyDeletingItemShoppingCartAfterAddingItem(String testCaseName, String searchText, String url) throws InterruptedException {

        Bigdeals_HomePage HomePage = new Bigdeals_HomePage(driver);
        Bigdeals_LoginPage LoginPage = new Bigdeals_LoginPage(driver);
        Bigdeals_ProductDetailsPage ProductDetailPage = new Bigdeals_ProductDetailsPage(driver);
        Bigdeals_ShoppingCartPage ShoppingCartPage = new Bigdeals_ShoppingCartPage(driver);

       HomePage.validateMainSearch(searchText, url, baseurl);

        //Validate Adding item to cart
        HomePage.buyNow();
        ProductDetailPage.addToCartFromProductDetailPage();

        ProductDetailPage.navigateToShoppingCart();

        //Validate cart
        ShoppingCartPage.validateAddedItemInShoppingCart();

        //Delete item
        ShoppingCartPage.deleteItemFromShoppingCart();



    }

    @Test(dataProvider = "SearchTest")
    public void verifyCheckOutItemShoppingCartAfterAddingItem(String testCaseName, String searchText, String url) throws InterruptedException {

        Bigdeals_HomePage HomePage = new Bigdeals_HomePage(driver);
        Bigdeals_LoginPage LoginPage = new Bigdeals_LoginPage(driver);
        Bigdeals_ProductDetailsPage ProductDetailPage = new Bigdeals_ProductDetailsPage(driver);
        Bigdeals_ShoppingCartPage ShoppingCartPage = new Bigdeals_ShoppingCartPage(driver);

        HomePage.validateMainSearch(searchText, url, baseurl);

        //Validate Adding item to cart
        HomePage.buyNow();
        ProductDetailPage.addToCartFromProductDetailPage();

        ProductDetailPage.navigateToShoppingCart();

        //Validate cart
        ShoppingCartPage.validateAddedItemInShoppingCart();

       //Navigate to shopping cart
        ProductDetailPage.navigateToShoppingCart();
        //Delete item
        ShoppingCartPage.deleteItemFromShoppingCart();




    }*/


    @AfterMethod
    public void logout() throws InterruptedException {
        //driver.close();

    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        //driver.quit();
    }
}
