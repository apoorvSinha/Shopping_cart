package finalizing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePageTest {
    static WebDriver driver;
    static JavascriptExecutor js;


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
        driver = new ChromeDriver();
//		driver = new EdgeDriver();
        SearchGoogle();
//		SelectResult("w3 schools");
        SelectResult("Java t Point");
/*
 		ScrollingDownPageDown();
        ScrollDownJS();
 		ScrollIntoView();
 */

    }

    public static void SearchGoogle() {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Java Tutorial");
        search.submit();
    }

    public static void SelectResult(String str) throws InterruptedException {
        if (str.equalsIgnoreCase("w3 schools")) {
            driver.findElement(By.xpath("//h3[contains(text(),'Java Tutorial - W3Schools')]")).click();
        }
        else if(str.equalsIgnoreCase("java t point")) {
            driver.findElement(By.xpath("//h3[contains(text(),'Java Tutorial | Learn Java Programming - javatpoint')]")).click();
        }
        Thread.sleep(2000);
    }

    public static void ScrollingDownPageDown() throws InterruptedException {
        int time = 1;
        while (time<=4);{
            WebElement body = driver.findElement(By.xpath(""));
            body.sendKeys(Keys.PAGE_DOWN);
            time++;
            Thread.sleep(2000);
        }
    }
    public static void ScrollDownJS() throws InterruptedException {
        js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,3072)");
        Thread.sleep(2000);
    }

    public static void ScrollIntoView() {
        WebElement questions = driver.findElement(By.xpath("//*[@id=\"city\"]/table/tbody/tr/td/h2[6]"));
        js.executeScript("arguments[0].scrollIntoView();", questions);
    }

}
