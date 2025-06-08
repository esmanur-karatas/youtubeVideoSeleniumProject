package seleniumJsExecuter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumJsExecuter {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://demoqa.com/elements");

        //1 sayfa sonuna scroll
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        //2. Elmente kadar scroll
//        WebElement element = driver.findElement(By.xpath("//div/div/div[2]/span/div/div[1]"));
//        js.executeScript("arguments[0].scrollIntoView(true);", element);

        //3.elemente js ile tıklama
        WebElement button = driver.findElement(By.xpath("(//ul//li[@id=\"item-0\"])[1]"));
        js.executeScript("arguments[0].click();", button);

        //4. elemente değer gönderme
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
        js.executeScript("arguments[0].value='esmanur';" , userName);

        //5. Başlıktaki metni almak için
        String title = (String)
                js.executeScript("return document.title;");
        System.out.println("Sayfa Başlığı: " + title);

        //6. Sayfayı yenilemek için kullanır.
        js.executeScript("history.go(0);");

        //7 Alert gösterme
        js.executeScript("alert('Bu bir otomasyon testidir!')");

        Thread.sleep(3000);

        driver.quit();
    }
}
