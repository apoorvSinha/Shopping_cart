package TestCases;

import Pages.HomePage;
import Pages.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC02_AddItems {
    public static WebDriver driver;

    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        JSONParser parser = new JSONParser();
        JSONObject jsobj = (JSONObject) parser.parse(new FileReader("src/main/java/utility/data.json"));
        String url = (String) jsobj.get("url");
        String username = (String) jsobj.get("uName");
        String userpwd = (String)jsobj.get("uPwd");


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().maximize();
        HomePage home = new HomePage(driver);
        Login log = new Login(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        home.clickLogin();
        log.ClickuName(username);
        log.ClickuPwd(userpwd);
        log.ClickLoginBtn();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Laptop')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'MacBook air')]")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();

        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert is: "+alert.getText());
        alert.accept();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
        driver.quit();
    }

}
