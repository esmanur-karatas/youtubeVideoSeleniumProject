package driverNavigateMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverNavigateMethodsExample {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//1.Amazon ana sayfa getir
        driver.get("https://www.amazon.com.tr/");
//2.Youtube Sayfasına Gidelim
        driver.navigate().to("https://www.youtube.com/");

//3.Tekrar Amazon Sayfasına Dönelim
        driver.navigate().back();

//4.Yeniden youtube sayfasına gidelim
        driver.navigate().forward();

//5.Sayfayı refresh(yenile) yapalım
        driver.navigate().refresh();
//6.Sayfayı kapatalım.
        driver.close();
    }
}
