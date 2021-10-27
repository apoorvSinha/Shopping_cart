package TestCases;

import Pages.HomePage;
import Pages.LogOut;
import Pages.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC01_Tenali_Raman {

    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        JSONParser parser = new JSONParser();
        JSONObject JSobj = (JSONObject) parser.parse(new FileReader("src/main/java/utility/data.json"));

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = (String)JSobj.get("url");
        String username = (String) JSobj.get("uName");
        String userpwd = (String) JSobj.get("uPwd");

        HomePage home = new HomePage(driver);
        Login log = new Login(driver);
        LogOut logOt = new LogOut(driver);

        driver.get(url);
        home.clickLogin();

        log.ClickuName(username);
        log.ClickuPwd(userpwd);
        log.ClickLoginBtn();

        Thread.sleep(3000);
        logOt.ClickLogoutBtn();
    }
}
