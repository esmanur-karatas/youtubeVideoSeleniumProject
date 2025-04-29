package radioButtonAndCheckbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.lang.model.element.Element;
import java.time.Duration;

public class Radio_Button {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1. Go to https://demoqa.com/automation-practice-form
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement femaleRadioButoon = driver.findElement(By.xpath("//label[@for=\"gender-radio-2\"]"));
//        femaleRadioButoon.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", femaleRadioButoon);

        Thread.sleep(2000);
        driver.quit();
    }
}
