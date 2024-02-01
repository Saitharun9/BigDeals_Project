package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Bigdeals_ShoppingCartPage {
    WebDriver driver;

    By AddToCart_Button = By.linkText("Add To Cart");
    By AddToCartSuccess_Label = By.xpath("//span[text()='Success']");
    By AddToCartSuccessOk_Button = By.xpath("//button[text()='ok']");
    By CartImage = By.xpath("//div[@class='cart-images']");
    By CartImageDelete_Button = By.xpath("(//i[@class='fa fa-trash-o pull-right cart-delete'])[3]");
    By SecureCheckout_Button = By.linkText("Secure checkout");
    By FirstName_Textbox = By.id("first_name");
    By LastName_Textbox = By.id("first_name");
    By EmailAddress_Textbox = By.id("first_name");
    By Phone_Textbox = By.id("first_name");
    By Address_Textbox = By.id("first_name");
    By SameAddress_Checkbox = By.xpath("//label[@for='same_address']");
    By Coutinue_Button = By.xpath("//button[text()='Continue']");



    public Bigdeals_ShoppingCartPage(WebDriver driver){

        this.driver = driver;

    }

    //Get the User name from Home Page

    public void validateAddedItemInShoppingCart() throws InterruptedException {
        driver.findElement(CartImage).isEnabled();
        Thread.sleep(2000);


    }

    public void deleteItemFromShoppingCart() throws InterruptedException {

        driver.findElement(CartImageDelete_Button).click();
        Thread.sleep(5000);

        driver.findElement(AddToCartSuccess_Label).isDisplayed();

        driver.findElement(AddToCartSuccessOk_Button).click();
    }

    public void SecureCheckout() throws InterruptedException {

        driver.findElement(SecureCheckout_Button).click();
        Thread.sleep(5000);



    }


}
