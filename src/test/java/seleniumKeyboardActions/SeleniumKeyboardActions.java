package seleniumKeyboardActions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class SeleniumKeyboardActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://demoqa.com/text-box");
        WebElement fullName = driver.findElement(By.id("userName"));
        WebElement eMail = driver.findElement(By.id("userEmail"));
        WebElement currenAdress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));

        Actions actions = new Actions(driver);

        actions.click(fullName)
                .sendKeys("Esmanur")
                .sendKeys(Keys.TAB)
                .sendKeys("test@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("Bu bir otomasyon testidir.")
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.TAB)
                .keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();


        Thread.sleep(3000);
        driver.quit();
    }
}
