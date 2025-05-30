package seleniumFileOperations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FileUpload {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        String url = "https://the-internet.herokuapp.com/upload";
        driver.get(url);

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        String filePath = System.getProperty("user.home") + "\\Downloads\\sampleFile.jpeg";
        chooseFile.sendKeys(filePath);

        Thread.sleep(2000);

        WebElement button = driver.findElement(By.id("file-submit"));
        button.click();
        Thread.sleep(3000);

        driver.quit();
    }
}
