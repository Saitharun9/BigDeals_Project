package bussinessComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class pageValidations {
    public static void validateUserLandingPage(WebDriver driver, String baseurl, String name) throws Exception {
        String ActualURL = driver.getCurrentUrl();
        String ExpectedURL = baseurl;
        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='spn-reg']")).getText(),"Hi "+name);
        Thread.sleep(5000);
        Assert.assertEquals(ActualURL, ExpectedURL);

    }
} 
