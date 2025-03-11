package driverGetMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverGetMethodsExample {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        String baseUrl = "https://www.amazon.com.tr/";
        //1.Amazon Sayfasına Gidelim.
        driver.get(baseUrl);

//2.Sayfa Başlığını Yazdırın.
        String actualTitle = driver.getTitle();
        System.out.println("Sayfa başlığı: " + actualTitle);

//3.Sayfa başlığının amazon içerdiğini test edin
        String expectedTitle = "Amazon";
        if(actualTitle.contains(expectedTitle)) {
            System.out.println("Title Testing Passed");
        }else {
            System.out.println("Title Testing Fail");
        }

//4.Sayfa adresini url yazdırın
        System.out.println("Sayfanın  Url : "+ driver.getCurrentUrl());

//5.Sayfa urlnin amazon içerdiğini test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "amazon";
        if(actualUrl.contains(expectedUrl)) {
            System.out.println("Url Testing Passed");
        }else {
            System.out.println("Url Testing Fail");
        }

//6.Sayfa Handle değerini yazdırın
        System.out.println("Sayfanın Hnadle Değeri : " + driver.getWindowHandle());

//7.Sayfa html kodlarını "shopping" kelimesi geçtiğini test edin
        String pageSource = driver.getPageSource();
        String expectedPageSource = "amazon";
        if(pageSource.contains(expectedPageSource)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
//8.Sayfayı kapatın.
        driver.quit();
    }
}
