package Anotacije;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Zadatak1 {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait wdwait = new WebDriverWait(driver , Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/button[2]/div")).click();

    }

    @Test
    public void test1() throws InterruptedException {
        driver.navigate().to("https://www.wikipedia.com");
        Thread.sleep(2000);
        driver.findElement(By.id("searchInput")).sendKeys("Nikola Tesla");
        driver.findElement(By.cssSelector(".pure-button.pure-button-primary-progressive")).click();

        String ocekivaniNaziv = "Nikola Tesla";
        WebElement naslov = driver.findElement(By.id("firstHeading"));
        String dobijenNaslov = naslov.getText();
        Assert.assertEquals(dobijenNaslov , ocekivaniNaziv); }

    @AfterMethod
    public void removeCookies(){
        driver.manage().deleteAllCookies();}
    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();





    }
}
