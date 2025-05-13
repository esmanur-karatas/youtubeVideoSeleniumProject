package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DemoqaFormExampleTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://demoqa.com/automation-practice-form adresine git
        String url = "https://demoqa.com/automation-practice-form";
        driver.get(url);

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Esmanur");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Karataş");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("esmanur@gmail.com");

        WebElement gender = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label"));
        gender.click();

        WebElement phoneNumber = driver.findElement(By.id("userNumber"));
        phoneNumber.sendKeys("55555555555");

        WebElement dateBirth = driver.findElement(By.id("dateOfBirthInput"));
        dateBirth.click();

        WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
        Select select = new Select(month);
        select.selectByVisibleText("April");

        WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
        Select select2 = new Select(year);
        select2.selectByVisibleText("2002");

        WebElement day = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[2]"));
        day.click();
        Thread.sleep(2000);
        WebElement subject = driver.findElement(By.id("subjectsInput"));
        subject.sendKeys("Test");

        WebElement hobbie = driver.findElement(By.xpath("//label[@for=\"hobbies-checkbox-2\"]"));
        hobbie.click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        Thread.sleep(2000);
        driver.quit();


    }
}
