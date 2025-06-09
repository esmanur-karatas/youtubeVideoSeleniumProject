package seleniumDynamicTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumDynamicTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        driver.manage().window().maximize();


        driver.get("https://demoqa.com/dynamic-properties");
        WebElement enableButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));

        System.out.println("Enable Butonu aktif hale geldi: " + enableButton.isEnabled());


        WebElement visibleButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        System.out.println("Visible Butonu görünür hale geldi: " + visibleButton.isDisplayed());

        WebElement colorButton = driver.findElement(By.id("colorChange"));

        String initialColor = colorButton.getCssValue("color");
        System.out.println("İlk Renk: " + initialColor);

        Thread.sleep(6000);

        String changedColor = colorButton.getCssValue("color");
        System.out.println("Yeni Renk: " + changedColor);

        if (!initialColor.equals(changedColor)) {
            System.out.println("Butonun rengi değişti!");
        } else {
            System.out.println("Butonun rengi değişmedi!");
        }

        driver.quit();
    }
}
