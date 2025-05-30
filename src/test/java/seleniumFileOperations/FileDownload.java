package seleniumFileOperations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class FileDownload {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        String url = "https://the-internet.herokuapp.com/download";
        driver.get(url);

        WebElement file = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[2]"));
        file.click();
        Thread.sleep(2000);
        String filePath = System.getProperty("user.home") + "\\Downloads\\some-file.txt";
        Boolean result = Files.exists(Paths.get(filePath));

        if(result){
            System.out.println("some-file.txt found");
        }else{
            System.out.println("some-file.txt not found");
        }


    }
}
