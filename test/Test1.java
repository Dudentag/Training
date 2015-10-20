import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dudentag on 16/10/2015.
 */
public class Test1 {
    WebDriver driver;

    @Before
    public void StartUp(){
        driver = new FirefoxDriver(); //ESTO ABRE EL DRIVER
        driver.manage().window().maximize(); // depegar muestra las ofertas solo maximizado
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // los popup de despegar tardan en abrirse
    }

    //@After
    public void tearDown(){
        driver.close();//CIERRA EL DRIVER
    }

    @Test
    public void primerTest() {
        driver.get("http://www.wikipedia.org");//Navega
    }

    @Test
    public void segundoTest() {
        driver.get("http://www.wikipedia.org");
        //driver.findElement(By.cssSelector("[title*='English']")).click(); //ESTO ESTA MAL POR QUE NO ES REUSABLE
        WebElement linkEnglish = driver.findElement(By.cssSelector("[title*='English']"));
        System.out.println(linkEnglish.getText());
        linkEnglish.click();
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("Python");
        searchInput.submit();
        WebElement resultsTitle = driver.findElement(By.id("firstHeading"));
        Assert.assertTrue(resultsTitle.getText().contains("Python"));
        System.out.println("Test Successful");
    }

    @Test
    public void tercerTest() {
        String searchedValue = "tetorodaimacu";
        driver.get("http://www.wikipedia.org");
        WebElement linkEnglish = driver.findElement(By.cssSelector("[title*='English']"));
        System.out.println(linkEnglish.getText());
        linkEnglish.click();
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchedValue);
        searchInput.submit();
        WebElement resultsTitle = driver.findElement(By.id("firstHeading"));
        Assert.assertTrue(resultsTitle.getText().contains(searchedValue));
        System.out.println("Test Successful");
    }
    @Test
    public void ejercicio1(){
        driver.get("http://www.wikipedia.org");
        WebElement linkEnglish = driver.findElement(By.cssSelector("[title*='English']"));
        System.out.println(linkEnglish.getText());
        linkEnglish.click();
        WebElement randomlink = driver.findElement(By.cssSelector("#n-randompage a"));
        randomlink.click();
        WebElement resultsTitle = driver.findElement(By.cssSelector("#firstHeading"));
        System.out.println(resultsTitle.getText());
        // First image on page *.img
        //WebElement firstImage = driver.findElement(By.tagName("img"));
        //If exist, the image at right, like the Default for the search
        try {
            WebElement firstImage = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/table[1]/tbody/tr[2]/td/a/img"));
            System.out.println(firstImage.getAttribute("src"));
        } catch(org.openqa.selenium.NoSuchElementException ex){
            System.out.println(" No Default Image Found");
         }
    }
    @Test
    public void ejercicio2(){
        driver.get("http://www.despegar.com");
        try {
            WebElement popup = driver.findElement(By.cssSelector("#nibbler-facebook-overlay > span.nibbler-common-overlay-close"));
            popup.click();
        } catch(org.openqa.selenium.NoSuchElementException ex){
            System.out.println(" No Pop-up");
        }
        WebElement linkOfertas = driver.findElement(By.xpath("//*[@id=\"hotjar-carousel-offers\"]/div[2]/div[2]/div[2]/ul/li[6]/div/div[3]/a"));
        linkOfertas.click();
        WebElement textMail = driver.findElement(By.xpath("//*[@id=\"email-first\"]"));
        textMail.sendKeys("tuvieja@ar.mcd.com");
        WebElement buttonSubm = driver.findElement(By.xpath("//*[@id=\"dAlert-app\"]/div[2]/div[1]/div[1]/div[2]/a/em"));
        buttonSubm.click();
        //#flights-origin
        //#dAlert-app > div.eva-content > div.eva-main.step-container.form.step-2 > div.eva-grid.step-2 > div:nth-child(2) > div.eva-col-small-12.destination-container > div > div:nth-child(2) > div > div > input

    }
}
