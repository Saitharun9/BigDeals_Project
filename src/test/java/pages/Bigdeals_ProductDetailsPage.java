package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Bigdeals_ProductDetailsPage {
    WebDriver driver;

    By AddToCart_Button = By.linkText("Add To Cart");
    By AddToCartSuccess_Label = By.xpath("//span[text()='Success']");
    By AddToCartSuccessOk_Button = By.xpath("//button[text()='ok']");
    By Cart_Button = By.xpath("(//span[text()='Cart'])[1]");

    public Bigdeals_ProductDetailsPage(WebDriver driver){

        this.driver = driver;

    }

    //Get the User name from Home Page

    public void addToCartFromProductDetailPage() throws InterruptedException {

        //Type user name and password. Then click login button
        driver.findElement(AddToCart_Button).click();
        Thread.sleep(5000);

        driver.findElement(AddToCartSuccess_Label).isDisplayed();

        driver.findElement(AddToCartSuccessOk_Button).click();
        Thread.sleep(5000);

    }

    public void navigateToShoppingCart() throws InterruptedException {

        //Type user name and password. Then click login button
       WebElement element = driver.findElement(Cart_Button);
       element.click();
        Thread.sleep(3000);

    }


}
