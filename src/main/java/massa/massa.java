package massa;

import java.util.ArrayList;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class massa {

	public static void main(String[] args) throws InterruptedException {
        // Definir o local do driver do Chrome (certifique-se de ter baixado o driver correspondente)
    	System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver_win32\\chromedriver.exe");

        // Inicializar o WebDriver
        WebDriver driver = new ChromeDriver();
     

        // Abrir a página do Google
        driver.get("https://www.google.com.br");
        driver.manage().window().maximize();
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("nttdata");
        searchBox.sendKeys(Keys.RETURN);
        

        // Aguardar a pagina de resultado do google ser carregada
        
       try {
    	   Thread.sleep(3000);
       }   catch (InterruptedException e) {
    	   e.printStackTrace();
       }
    
        // clicar no primeiro link apresentado na pesquisa 
        //WebElement firstLink = driver.findElement(By.xpath("//div[@id= 'search']//a"));
        //firstLink.click();
       WebElement sponsoredLink = driver.findElement(By.xpath("//a[@href='https://nttdata-solutions.com/br/']"));
       sponsoredLink.click();
            
       
        Thread.sleep(5000);
      
        //aceitar cookie
       //WebElement frame = driver.findElement(By.id("ifrmCookieBanner"));
       //WebElement firstLink1 = driver.findElement(By.xpath("//button[contains(text(),'Aceitar')]"));
       //JavascriptExecutor executor = (JavascriptExecutor)driver;
      // executor.executeScript("arguments[0].click();", firstLink1);
      
      //div[@id="main-cookie-banner"]//iframe
        
        //WebElement firstLink1 = driver.findElement(By.cssSelector("#main-cookie-banner>iframe"));

        //driver.switchTo().frame(firstLink1);
        //WebElement firstLink2 = driver.findElement(By.xpath("//button[contains(text(),'Aceitar')]"));
        //firstLink2.click();
        WebElement buttonCookiesAll = driver.findElement(By.id("all"));
        buttonCookiesAll.click();



        
        // Clicar em "carreira"
        Thread.sleep(5000);
        WebElement careerLink = driver.findElement(By.xpath("//div[@class='lower']//ul//a//span[text()='Carreira']"));
        careerLink.click();
        
     // Clicar em "junte-se a nossa equipe"
        driver.findElement(By.cssSelector("a.button.highlight")).click();
  
        //WebElement joinUsLink = driver.findElement(By.xpath("//html/body/main/div[4]/div/div/div[2]/a[contains(text(),'junte-se a nossa equipe')]"));
        //joinUsLink.click();
      
        

        // Localizar o campo de pesquisa de vagas e inserir "Arquiteto"
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles()); 
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(3000);
        WebElement vagasSearchInput = driver.findElement(By.xpath("//input[@ng-model='vm.search']"));
        vagasSearchInput.sendKeys("Arquiteto");
        //vagasSearchInput.sendKeys(Keys.ENTER);

        //ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles()); 
        //driver.switchTo().window(tabs.get(1));
        //WebElement vagasSearchInput = driver.findElement(By.xpath("//input[@ng-model='vm.search']"));
        //vagasSearchInput.clear(); // Limpar o campo antes de enviar o texto
        //vagasSearchInput.sendKeys("Arquiteto");
        //vagasSearchInput.submit(); // Submeter a pesquisa, se necessário

       
        // Encerrar o WebDriver
         // driver.quit();
    }
}
