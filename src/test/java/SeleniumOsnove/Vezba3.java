package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Vezba3 {

    //Zadatak 1
    //Pokrenuti browser, otici na google,
    //otvoriti jos 2 taba, u drugom otici na youtube, u trecem otici na linkedin. Nakon toga zatvoriti sve tabove posebno.

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String linkedin = "https://www.linkedin.com";
        String youtube = "https://www.youtube.com";
        String google = "https://www.google.com";
        driver.navigate().to(google);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/button[2]/div")).click();

        Thread.sleep(2000);


        JavascriptExecutor as= (JavascriptExecutor) driver;

        as.executeScript("window.open()");
        as.executeScript("window.open()");

        ArrayList<String> listaTabova = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));
        driver.navigate().to(youtube);

        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to(linkedin);

        driver.switchTo().window(listaTabova.get(0));
        driver.close();
        Thread.sleep(1000);

        driver.switchTo().window(listaTabova.get(1));
        driver.close();
        Thread.sleep(1000);

        driver.switchTo().window(listaTabova.get(2));
        driver.close();
        Thread.sleep(1000);



    }
}
