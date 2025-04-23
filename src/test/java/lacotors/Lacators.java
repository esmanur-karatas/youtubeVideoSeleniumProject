package lacotors;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Lacators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        String baseUrl = "https://www.amazon.com.tr/";
        //get():
        driver.get(baseUrl);

//        id
        WebElement searchBoxInput = driver.findElement(By.id("twotabsearchtextbox"));
        searchBoxInput.sendKeys("Laptop", Keys.ENTER);

//        name
        WebElement searchboxName = driver.findElement(By.name("field-keywords"));

//        className
        WebElement hesaplar = driver.findElement(By.className("nav-line-2 "));
        hesaplar.click();

//        cssSelector
        WebElement cssornek = driver.findElement(By.cssSelector("input[placeholder='Telefon Numarası']"));

//        xpath
        WebElement xpathEx= driver.findElement(By.xpath("//nav[@class='nav-assistant']"));

//        linkText
        WebElement link = driver.findElement(By.linkText("Yeni Çıkanlar"));

//        partialLinkText
        WebElement link2 = driver.findElement(By.partialLinkText("Çıkanlar"));

//        tagName
        WebElement tag = driver.findElement(By.tagName("denmee"));






        // tarayıcı kapat
        driver.quit();
    }
}
