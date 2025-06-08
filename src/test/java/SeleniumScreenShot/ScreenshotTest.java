package SeleniumScreenShot;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ScreenshotTest {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.trendyol.com/");

        createScreenshotFolder();

        takeFullPageScreenShot(driver);

        takeElementScreenshot(driver, By.cssSelector("div[class='logo']"));

        driver.quit();
    }

    public static void takeFullPageScreenShot(WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        File destFile = new File("screenshots/fullpage_" + timestamp + ".png");
        try {
            FileHandler.copy(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void takeElementScreenshot(WebDriver driver, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            File srcFile = element.getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File destFile = new File("screenshots/" + timestamp + ".png");

            FileHandler.copy(srcFile,destFile);
            System.out.println("Element ekran görüntüsü alındı: " + destFile.getPath());
        } catch (Exception e) {
            System.out.println("Element bulunmadı: " + e.getMessage());
        }
    }

    public static void createScreenshotFolder() {
        File folder = new File("screenshots");
        if (!folder.exists()) {
            boolean created = folder.mkdir();
            if (created) {
                System.out.println("Klasör oluşturuldu");
            } else {
                System.out.println("Klasör oluşturulurken bir hata meydana geldi");
            }
        }
    }

}

