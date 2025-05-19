package windowHandleAndWindowHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class WindowHandles {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Nasanın sitesine git
        driver.get("https://www.nasa.gov/");

        String nasaHandle = driver.getWindowHandle(); //sekmeninn id aldım

        //yeni sekme aç ve nato sitesine gir
        ((JavascriptExecutor)driver).executeScript("window.open('https://www.nato.int/','_blank');");

        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("Tüm sekmelerin ID: " + allHandles);

        //NATO ya geri dön
        for(String handle : allHandles){
            if(!handle.equals(nasaHandle)){
                driver.switchTo().window(handle);
                break;
            }
        }

        driver.switchTo().window(nasaHandle);

        driver.quit();

    }
}
