package seleniumMouseActions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class SeleniumMouseActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       driver.get("https://demoqa.com/buttons");
       Actions actions = new Actions(driver);

       WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
       actions.doubleClick(doubleClick).perform();
       Thread.sleep(2000);

       WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
       actions.contextClick(rightClick).perform();
       Thread.sleep(2000);

       WebElement click = driver.findElement(By.xpath("//button[text()='Click Me']"));
       actions.click(click).perform();
       Thread.sleep(2000);

       driver.navigate().to("https://demoqa.com/tool-tips");
       WebElement hoverButton = driver.findElement(By.id("toolTipButton"));
       actions.moveToElement(hoverButton).perform();
       Thread.sleep(2000);

       driver.navigate().to("https://demoqa.com/droppable");
       WebElement dragMe = driver.findElement(By.id("draggable"));

       WebElement dragHere = driver.findElement(By.id("droppable"));

       actions.clickAndHold(dragMe).moveToElement(dragHere).release().perform();
       Thread.sleep(2000);

       driver.quit();




    }
}
