package iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Iframe {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        String url = "https://science.nasa.gov/science-research/heliophysics/what-nasa-is-learning-from-the-biggest-geomagnetic-storm-in-20-years/";
        driver.get(url);

        //1. yöntem
        //   driver.switchTo().frame(0);

        //2. yöntem
        // driver.switchTo().frame("9i47b__igEw");

        //3. yöntem
        WebElement iframeElement = driver.findElement(By.id("9i47b__igEw"));
        driver.switchTo().frame(iframeElement);

        WebElement playButton = driver.findElement(By.xpath("//div[5]/button"));
        playButton.click();

        //Çıkış için 1. yöntem
        driver.switchTo().defaultContent();

        //Çıkış için 2. yöntem
       // driver.switchTo().parentFrame();

        Thread.sleep(6000);

        driver.quit();

    }
}
