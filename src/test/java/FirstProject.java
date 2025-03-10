import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FirstProject {
    public static void main(String[] args) throws InterruptedException {
        // WebDriver nesnesini tanımla, bu nesne ile tarayıcıyı kontrol edeceğiz.
        WebDriver driver;

// ChromeDriver'ı otomatik olarak yönetmek ve sistemimize uygun olanı kullanmak için WebDriverManager'ı başlat.
        WebDriverManager.chromedriver().setup();

// Chrome tarayıcısını başlatmak için bir ChromeDriver nesnesi oluşturduk.
        driver = new ChromeDriver();

// Belirtilen URL'ye gitmek için get() metodunu kullan.
        driver.get("https://www.amazon.com.tr/");

// Tarayıcı penceresini tam ekran yapmak için maximize() metodunu kullan.
        driver.manage().window().maximize();

// Sayfa yüklendiğinde elemanları bulamazsa, 15 saniye boyunca tekrar denemesini sağlıyoruz.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

// Kodun 3 saniye beklemesini sağlıyoruz.
        Thread.sleep(3000);

// Tarayıcıyı kapatıyoruz, böylece test tamamlandığında kaynakları serbest bırakıyoruz.
        //driver.close();
        driver.quit();
    }
}
