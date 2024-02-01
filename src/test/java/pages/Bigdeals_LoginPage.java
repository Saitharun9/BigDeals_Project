package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Bigdeals_LoginPage {
    WebDriver driver;

    By Username_Textbox = By.xpath("//input[@name='email']");
    By Password_Textbox = By.xpath("//input[@name='password']");
    By Login_Buttton = By.xpath("//button[text()='Login']");
    By MyProfile_Button = By.xpath("//span[text()='My Profile']");
    By SignOut_Button = By.xpath("//button[contains(text(),'Sign Out')]");

    public Bigdeals_LoginPage(WebDriver driver){

        this.driver = driver;

    }

    //Get the User name from Home Page

    public void loginToBigdeals(String userName, String password) throws InterruptedException {

        //Type user name and password. Then click login button
        driver.findElement(Username_Textbox).clear();
        Thread.sleep(1000);
        driver.findElement(Username_Textbox).sendKeys(userName);

        driver.findElement(Password_Textbox).clear();
        Thread.sleep(1000);
        driver.findElement(Password_Textbox).sendKeys(password);

        driver.findElement(Login_Buttton).click();
        Thread.sleep(1000);

    }

    public void logoutFromBigdeals(WebDriver driver) throws InterruptedException {


        Actions action = new Actions(driver);
        WebElement we = driver.findElement(MyProfile_Button);
        action.moveToElement(we).moveToElement(driver.findElement(MyProfile_Button)).click().build().perform();
        Thread.sleep(5000);
        //Actions builder = new Actions(driver);
        //builder.moveToElement(MyProfile_Button).perform();
        //builder.moveToElement(MyProfile_Button).click().perform();
        //driver.findElement(MyProfile_Button).click();

        driver.findElement(SignOut_Button).click();


    }
}
