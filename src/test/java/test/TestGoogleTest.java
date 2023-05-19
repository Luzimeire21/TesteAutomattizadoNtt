package test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class TestGoogleTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testGoogleSearch() throws InterruptedException {
        driver.get("https://www.google.com.br");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("nttdata");
        searchBox.sendKeys(Keys.RETURN);

        Thread.sleep(3000);

        WebElement sponsoredLink = driver.findElement(By.xpath("//a[@href='https://nttdata-solutions.com/br/']"));
        Assert.assertNotNull(sponsoredLink);
    }

    @Test
    public void testCareerPage() throws InterruptedException {
        driver.get("https://www.google.com.br");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("nttdata");
        searchBox.sendKeys(Keys.RETURN);

        Thread.sleep(3000);

        WebElement sponsoredLink = driver.findElement(By.xpath("//a[@href='https://nttdata-solutions.com/br/']"));
        sponsoredLink.click();

        Thread.sleep(5000);

        WebElement buttonCookiesAll = driver.findElement(By.id("all"));
        buttonCookiesAll.click();

        Thread.sleep(5000);

        WebElement careerLink = driver.findElement(By.xpath("//div[@class='lower']//ul//a//span[text()='Carreira']"));
        careerLink.click();

        Thread.sleep(5000);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://nttdata-solutions.com/br/carreira-na-nttdata/", currentUrl);
    }

    @Test
    public void testJobSearch() throws InterruptedException {
        driver.get("https://www.google.com.br");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("nttdata");
        searchBox.sendKeys(Keys.RETURN);

        Thread.sleep(3000);

        WebElement sponsoredLink = driver.findElement(By.xpath("//a[@href='https://nttdata-solutions.com/br/']"));
        sponsoredLink.click();

        Thread.sleep(5000);

        WebElement buttonCookiesAll = driver.findElement(By.id("all"));
        buttonCookiesAll.click();

        Thread.sleep(5000);

        WebElement careerLink = driver.findElement(By.xpath("//div[@class='lower']//ul//a//span[text()='Carreira']"));
        careerLink.click();
        
        driver.findElement(By.cssSelector("a.button.highlight")).click();

        Thread.sleep(5000);
        
        

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        

        WebElement vagasSearchInput = driver.findElement(By.xpath("//input[@ng-model='vm.search']"));
        vagasSearchInput.sendKeys("Arquiteto");

        Thread.sleep(2000);

        String searchInputValue = vagasSearchInput.getAttribute("value");
        Assert.assertEquals("Arquiteto", searchInputValue);
    }
}
