package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Bigdeals_ShoppingCartDeleveryDedailPage {
    WebDriver driver;

    By AddToCart_Button = By.linkText("Add To Cart");
    By AddToCartSuccess_Label = By.xpath("//span[text()='Success']");
    By AddToCartSuccessOk_Button = By.xpath("//button[text()='ok']");
    By CartImage = By.xpath("//div[@class='cart-images']");
    By CartImageDelete_Button = By.xpath("(//i[@class='fa fa-trash-o pull-right cart-delete'])[3]");
    By SecureCheckout_Button = By.linkText("Secure checkout");
    By FirstName_Textbox = By.id("first_name");
    By LastName_Textbox = By.id("last_name");
    By EmailAddress_Textbox = By.id("email_address");
    By Phone_Textbox = By.id("telephone");
    By Address_Textbox = By.id("address");
    By SameAddress_Checkbox = By.xpath("//label[@for='same_address']");
    By Coutinue_Button = By.xpath("//button[text()='Continue']");
    By AddDeleveryAddress_Button = By.id("add_delivery_address");


    public Bigdeals_ShoppingCartDeleveryDedailPage(WebDriver driver){

        this.driver = driver;

    }


    public void FillDeleveryData(String firstName, String lastName, String eAddress, String phone, String address) throws InterruptedException {

        driver.findElement(AddDeleveryAddress_Button).click();
        Thread.sleep(2000);

        driver.findElement(FirstName_Textbox).sendKeys(firstName);
        driver.findElement(LastName_Textbox).sendKeys(lastName);
        driver.findElement(EmailAddress_Textbox).sendKeys(eAddress);
        driver.findElement(Phone_Textbox).sendKeys(phone);
        Thread.sleep(1000);
        driver.findElement(Address_Textbox).sendKeys(address);
        Thread.sleep(1000);
        driver.findElement(SameAddress_Checkbox).click();
        Thread.sleep(5000);

        driver.findElement(Coutinue_Button).click();
        Thread.sleep(5000);



    }
    

}
