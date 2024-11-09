package projetoAutomacao.teste;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTeste {

    protected static WebDriver driver;
    private static final String URL_BASE = "https://www.saucedemo.com/";
    private static final String CAMINHO_DRIVER = "src/test/java/projetoAutomacao/resource/chromedriver.exe";

   @Before
    public void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    @After
    public void fechar(){
        driver.quit();
    }
    
}
