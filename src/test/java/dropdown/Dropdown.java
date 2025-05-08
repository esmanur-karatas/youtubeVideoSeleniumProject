package dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Dropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.globalsqa.com/demo-site/select-dropdown-menu/ adresine git
        String url = "https://www.globalsqa.com/demo-site/select-dropdown-menu/";
        driver.get(url);

        WebElement country = driver.findElement(By.xpath("//*[@id=\"post-2646\"]/div[2]/div/div/div/p/select"));
        Select select = new Select(country);

        //1. Yöntem visible text ile almak
//        select.selectByVisibleText("Andorra");
//        Thread.sleep(2000);

//        2. Yöntem value ya göre alma
//        select.selectByValue("ALB");
//        Thread.sleep(2000);

        //3. indekse göre almak
        select.selectByIndex(2);
        Thread.sleep(2000);

        //4.Konsola tüm değerleri yazdırma
        List<WebElement> allOptions = select.getOptions();
        for(WebElement option : allOptions){
            System.out.println(option.getText());
        }
        driver.quit();
    }
}
