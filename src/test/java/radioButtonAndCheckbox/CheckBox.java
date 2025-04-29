package radioButtonAndCheckbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class CheckBox {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://demoqa.com/checkbox adresine git
        String url = "https://demoqa.com/checkbox";
        driver.get(url);

        WebElement firstButton = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button"));
        firstButton.click();
        Thread.sleep(2000);
        WebElement desktopCheckbox = driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[2]"));
        if (!desktopCheckbox.isSelected()) {
            desktopCheckbox.click();
            System.out.println("desktop tıklandı");
            Thread.sleep(2000);
        } else {
            System.out.println("desktop seöili");
        }

        WebElement secondButton = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button"));
        secondButton.click();
        Thread.sleep(2000);

        WebElement notesChecbox = driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[3]"));
        if(!notesChecbox.isSelected()){
            notesChecbox.click();
            System.out.println("seçim kaldırıldı");
            Thread.sleep(2000);
        }else {
            System.out.println("Seçili değil");
        }

        // browserı kapat
        driver.quit();
    }
}
