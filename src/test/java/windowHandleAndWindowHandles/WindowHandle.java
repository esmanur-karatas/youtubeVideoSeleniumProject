package windowHandleAndWindowHandles;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WindowHandle {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.nato.int/");
        String natoWindow = driver.getWindowHandle();
        System.out.println("NATO sekme id = " + natoWindow);
        System.out.println("NATO Başlık: " + driver.getTitle());
        System.out.println("NATO URL: " + driver.getCurrentUrl());

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.nasa.gov/");
        String nasaWindow = driver.getWindowHandle();
        System.out.println("NASA sekme id = " + nasaWindow);
        System.out.println("NASA Başlık: " + driver.getTitle());
        System.out.println("NASA URL: " + driver.getCurrentUrl());

        Thread.sleep(3000);

        driver.switchTo().window(natoWindow);
        System.out.println("Geri Dönülen Sayfanın Başlığı: " + driver.getTitle());

        driver.quit();
    }
}
