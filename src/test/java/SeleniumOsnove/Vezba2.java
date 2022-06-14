package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.openqa.selenium.Keys.ENTER;

public class Vezba2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/button[2]/div")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Wikipedia");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys(ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[7]/div/div[10]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/a/h3")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div/div/form/div/input[1]")).sendKeys("Nikola Tesla");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div/div/form/div/input[3]")).click();

        Thread.sleep(2000);
        String ocekivaniNaslov = "Nikola Tesla";
        String dobijenNaslov = driver.findElement(By.xpath("/html/body/div[3]/h1")).getText();

        String ocekivaniURL = "https://de.wikipedia.org/wiki/Nikola_Tesla";
        String dobijenURL = driver.getCurrentUrl();

        Assert.assertEquals(dobijenNaslov, ocekivaniNaslov);
        Assert.assertEquals(dobijenURL, ocekivaniURL);

    }
}
