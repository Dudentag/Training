import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Alexis on 16/10/2015.
 */
public class Test1 {
    WebDriver driver;

    @Before
    public void StartUp(){
        driver = new FirefoxDriver(); //ESTO ABRE EL DRIVER
    }

    @After
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

}
