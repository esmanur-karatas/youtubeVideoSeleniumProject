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
        WebElement searchBoxName = driver.findElement(By.name("field-keywords"));

//        className
        WebElement classnameEx = driver.findElement(By.className("nav-line-2 "));

//        cssSelector
        WebElement cssselector = driver.findElement(By.cssSelector("input[placeholder='Telefon Numarası']"));

//        xpath
        WebElement xpathex = driver.findElement(By.xpath("//div//span[@id='nav-search-submit-text']"));

//        linkText
        WebElement linktext = driver.findElement(By.linkText("Yeni Çıkanlar"));

//        partialLinkText
        WebElement linktext2 = driver.findElement(By.linkText("Çıkanlar"));

//        tagName
        WebElement tagnaem= driver.findElement(By.tagName("deneme"));


        // tarayıcı kapat
        driver.quit();
    }
}
