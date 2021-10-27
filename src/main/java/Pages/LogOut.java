package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOut {
    WebDriver driver;
    public LogOut(WebDriver driver) {
        this.driver = driver;
    }
    By logoutBtn = By.id("logout2");

    public void ClickLogoutBtn(){driver.findElement(logoutBtn).click();}
}
