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

        //https://demoqa.com/checkbox adresine git
        String url = "https://www.globalsqa.com/demo-site/select-dropdown-menu/";
        driver.get(url);

        WebElement country = driver.findElement(By.xpath("//*[@id=\"post-2646\"]/div[2]/div/div/div/p/select"));
        Select select = new Select(country);

//1. Visible Textine göre
        // select.selectByVisibleText("American Samoa");

        //2. yöntem Value değrine göre seçme
// select.selectByValue("ASM");

// 3. Yöntem İndex değerine göre seçme
        select.selectByIndex(4);

        List<WebElement> allOptions = select.getOptions();
        for (WebElement options : allOptions) {
            System.out.println(options.getText());
        }
        Thread.sleep(2000);

        driver.quit();
    }
}
