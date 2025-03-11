package driverNavigateMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverNavigateMrthods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com.tr/");
        Thread.sleep(3000);
//        navigate.to(): yönlendirmek için
        driver.navigate().to("https://www.trendyol.com/");
        Thread.sleep(3000);

//        navigate().back(): bir önceki sayfaya dönmek için
        driver.navigate().back();
        Thread.sleep(3000);

//        navigate().forward(): ilerideki sayfaya gitmek için
        driver.navigate().forward();
        Thread.sleep(3000);

//        navigate().refresh(): sayfayı yenilemek için
        driver.navigate().refresh();
        Thread.sleep(3000);

        // tarayıcı kapat
        driver.quit();
    }
}
