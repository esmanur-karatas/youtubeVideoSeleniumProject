package driverGetMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverGetMethods {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        String baseUrl = "https://www.trendyol.com/";
        //get():
        driver.get(baseUrl);

//getCurrentUrl():
        System.out.println("Sayfanın url: " + driver.getCurrentUrl());

//getTitle():
        System.out.println("Sayfanın Başlığı: " + driver.getTitle());

//getPageSource():
      System.out.println("Sayfanın Kaynak Kodu\n " + driver.getPageSource());

//getWindowHandle():
        System.out.println("Sayfanın Uniq Değeri: " + driver.getWindowHandle());

//getClass():
        System.out.println("Driverın Classı" + driver.getClass());

//driverı kapat
        driver.quit();

    }
}
