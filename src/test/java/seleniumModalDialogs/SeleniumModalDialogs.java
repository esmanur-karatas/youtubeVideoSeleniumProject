package seleniumModalDialogs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SeleniumModalDialogs {
    public static void main(String[] args) throws IOException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.trendyol.com/");

        try{
            WebElement closeModel = driver.findElement(By.cssSelector("div[class='modal-close']"));
            closeModel.click();
            System.out.println("Modal pencere kapatıldı");
        } catch (Exception e) {
            System.out.println("Modal pencere kapatılamadı ya da bulunamadı.");
        }

        TakesScreenshot ts = (TakesScreenshot)  driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("screenshots/modalss.png");
        FileUtils.copyFile(source, destination);
        driver.quit();
    }
}
