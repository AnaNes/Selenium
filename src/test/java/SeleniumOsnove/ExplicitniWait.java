package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitniWait {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String URL = "https://gigatron.rs/";
        driver.navigate().to(URL);

        Thread.sleep(5000);
        //Eksplicitni wait

        WebElement button = driver.findElement(By.cssSelector(".btn.primary"));

        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wdwait.until(ExpectedConditions.elementToBeClickable(button));
        //Implicitni wait

        button.click();


    }

}