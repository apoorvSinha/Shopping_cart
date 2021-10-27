package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenPrinter {

    public static void ScreenPrint(WebDriver driver,String filePath) throws IOException {
        TakesScreenshot screen =(TakesScreenshot) driver;
        File src = screen.getScreenshotAs(OutputType.FILE);
        File dest = new File(filePath);
        FileUtils.copyFile(src, dest);
    }
    public static void TimeStamp(WebDriver driver) throws IOException {
        Date date = new Date();
        String frmt = "HH.mm.ss a";
        SimpleDateFormat sdf = new SimpleDateFormat(frmt);
        String stamp = sdf.format(date);
        ScreenPrint( driver,"C:\\Users\\Apoorv Sinha\\OneDrive\\Pictures\\SleniumScreenPrints\\"+stamp+".png");
    }
}
