package SeleniumWordPress;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Kolacic {

    //Zadatak 2 - Ulogovati se na sajt https://demoqa.com/ preko kolacica, izlogovati se i asertovati da je korisnik izlogovan

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/login");



        Cookie kolac = new Cookie("userName","ananesi1");
        Cookie kolac1 = new Cookie("userID","1e273fa8-5043-4734-861b-0aec4fdfb6b1");
        Cookie kolac2 = new Cookie("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImFuYW5lc2kxIiwicGFzc3dvcmQiOiJBbmFuZXNpMSEiLCJpYXQiOjE2NTQxOTU4Nzd9.ESdcJ0USRn3NdQtrqg-Ir4f2LRtc1FRv5pkG_akc2Do");
        Cookie kolac3 = new Cookie("expires","2022-06-09T18%3A51%3A17.544Z");
        driver.manage().addCookie(kolac);
        driver.manage().addCookie(kolac1);
        driver.manage().addCookie(kolac2);
        driver.manage().addCookie(kolac3);
        driver.navigate().refresh();



     WebElement username = driver.findElement(By.id("userName-value"));
     String expectedUsername = "ananesi1";
     String actualUsername = username.getText();
        Assert.assertEquals(expectedUsername,actualUsername);



        WebElement logOutButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(logOutButton.isDisplayed());

        WebElement logOutButtonWRONG = driver.findElement(By.cssSelector(".btn.btn-primary"));
        //Prethodni webelement je nadjen preko pogresnog lokatora jer ovaj lokator za LOG OUT ima istu vrednosti kao
        //i LOG IN dugme. Sto znaci da ako bismo trazili da dugme log out ne postoji necemo uspeti jer ce program
        //naci log in dugme (zbog istog lokatora)

        //driver.manage().deleteAllCookies();
        //mozemo da se izlogujemo ako obrisemo sve kolacice
        //driver.manage().deleteCookieNamed("token");
        //mozemo da obrisemo specifican kolacic ako prosledimo samo naziv
        //driver.manage().deleteCookie(kolacic1);
        //mozemo da obrisemo specifican kolacic ako prosledimo prethodno kreiran objekat kolacica
        //driver.navigate().refresh();

        logOutButton.click();

        //Kada hocemo da assertujemo da element NE POSTOJI na stranici onda je potrebno uraditi to preko
        //try catch bloka

        boolean check = false;
        //prvo moramo da kreiramo neki boolean koji cemo koristiti za assert
        //podesili smo vrednost na false i kasnije pri assertu trazimo da taj boolean bude false

        try {
            check = logOutButton.isDisplayed();
            //ako je element ipak pronadjen onda ce boolean postati TRUE i assert na kraju ce pasti
        } catch (Exception elkwjgjpft) {
            //U parametre catch moramo da prosledimo Exception i neki random string naziv
            //Najcesce se u parametar salje Exception e
        }

        Assert.assertFalse(check);

        //Kako da testiramo da smo dobro uradili sve?
        //Prvo promenimo assertFalse u assertTrue
        //Nakon toga vratimo na assertFalse i zakomentarisemo deo bloka gde se izlogujemo
        //Tako ce boolean zapravo postati true jer ce element biti pronadjen

    }
}









