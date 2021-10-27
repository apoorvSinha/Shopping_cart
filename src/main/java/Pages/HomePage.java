package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    //constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //locator for login button
    By loginBtn = By.id("login2");

    //click loginButton
    public void clickLogin(){
        driver.findElement(loginBtn).click();
    }
}
