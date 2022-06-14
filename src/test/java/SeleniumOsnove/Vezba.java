package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

////Zadatak 1
//Otvoriti browser, otici na youtube, otici na google, povecati prozor, vratiti se nazad i odraditi refresh

public class Vezba {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver1 = new ChromeDriver();

        driver1.navigate().to("https://www.youtube.com");
        driver1.navigate().to("https://www.google.com/?gws_rd=ssl");
        driver1.manage().window().maximize();
        driver1.navigate().back();
        driver1.navigate().refresh();
    }
}
