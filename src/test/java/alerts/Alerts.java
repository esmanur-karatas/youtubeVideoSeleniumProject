package alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Alerts {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://demoqa.com/alertsadresine git
        String url = "https://demoqa.com/alerts";
        driver.get(url);

        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();

        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();

        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();

        Alert confirmAlert = driver.switchTo().alert();
        confirmAlert.dismiss();

        WebElement promtButton = driver.findElement(By.id("promtButton"));
        promtButton.click();

        Alert prompAlert = driver.switchTo().alert();
        prompAlert.sendKeys("Esmanur");
        prompAlert.accept();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
