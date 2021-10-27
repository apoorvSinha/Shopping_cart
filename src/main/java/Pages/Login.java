package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utility.ScreenPrinter;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Login {

    WebDriver driver;

    public Login(WebDriver driver) throws IOException, ParseException {
        this.driver = driver;
    }


    By uName = By.id("loginusername");
    By uPwd = By.id("loginpassword");
    By loginBtn = By.xpath("//button[contains(text(),'Log in')]");

    public void ClickuName(String user){driver.findElement(uName).sendKeys(user);}
    public void ClickuPwd(String passwrod){driver.findElement(uPwd).sendKeys(passwrod);}
    public void ClickLoginBtn(){driver.findElement(loginBtn).click();}
}

















/*
    public WebDriver driver;
    JSONParser parser = new JSONParser();
    String URL, username, password;
    @Parameters("browser")
    @BeforeTest
    public void setup(String Browser) throws IOException, ParseException {
        WebDriverManager.chromedriver().setup();
        if(Browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else if(Browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }
        Object obj = parser.parse(new FileReader("src/main/java/utility/data.json"));
        JSONObject jsObject = (JSONObject)obj;
        URL = (String)jsObject.get("url");
        username = (String)jsObject.get("uName");
        password = (String)jsObject.get("uPwd");
    }
    @Test
    public void HomeLogin() throws IOException, InterruptedException {
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("login2")).click();
        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
        Thread.sleep(4000);
        ScreenPrinter.TimeStamp(driver);
    }

    @AfterTest
    public void TearDown(){
        driver.quit();
    }*/