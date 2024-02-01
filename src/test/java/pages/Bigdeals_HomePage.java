package pages;
import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Bigdeals_HomePage {
    WebDriver driver;

    By Login_Link = By.xpath("//span[text()='Login']");
    By MainTab_Links = By.linkText("");

    By MainSearch_Textbox = By.xpath("//input[@name='key']");
    By MainSearch_Button = By.xpath("//button[@class='pull-right btn-search']");
    By ByNow_Button1 = By.xpath("//ul[@class='product-list grid']/li/div[1]/div[3]/a");
    
    
    

    public Bigdeals_HomePage(WebDriver driver){
        this.driver = driver;
       // WebDriverWait wait=new WebDriverWait(driver,20);

    }

    //Get the User name from Home Page

    public void navigateToLogin(){

        driver.findElement(Login_Link).click();

    }

    public void validateMainTabVavigation(String tabName, String url, String baseUrl) throws InterruptedException {

        driver.findElement(By.linkText(tabName)).click();
        //wait.until(ExpectedConditions.urlToBe(baseUrl+url));
        Thread.sleep(12000);

        String ActualURL = driver.getCurrentUrl();
        String ExpectedURL = baseUrl + url;
        Assert.assertEquals(ActualURL, ExpectedURL);



    }

    public void validateMainSearch(String searchText, String url, String baseurl) throws InterruptedException {

        driver.findElement(MainSearch_Textbox).clear();
        driver.findElement(MainSearch_Textbox).click();
        driver.findElement(MainSearch_Textbox).sendKeys(searchText);
        Thread.sleep(10000);

        driver.findElement(MainSearch_Button).click();
        //wait.until(ExpectedConditions.urlToBe(baseurl+url));
        Thread.sleep(12000);
       

        driver.findElement(ByNow_Button1).isDisplayed();

        String ActualURL = driver.getCurrentUrl();
        String ExpectedURL = baseurl + url + searchText;
       Assert.assertEquals(ActualURL, ExpectedURL);




    }

    public void buyNow() {

        driver.findElement(ByNow_Button1).click();





    }
}
