package projetoAutomacao.PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para criação das novas POs
 */

public class BasePO {

    protected static WebDriver driver;

    /**
     * Constutor base para criação da fábrica de elementos
     * @param driver Driver da página atual.
     */

    @SuppressWarnings("static-access")
    protected BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="user-name")
    public WebElement inputCampoLogin;

    @FindBy(id="password")
    public WebElement inputCampoSenha;

    @FindBy(id="login-button")
    public WebElement buttonLogin;

    @FindBy(className = "shopping_cart_link")
    public WebElement buttonCarrinho;

    @FindBy(xpath = "//button[contains(text(),'Add to cart')]")
    public WebElement buttonSelectItem;

    public void login(){   
        inputCampoLogin.sendKeys("standard_user" + Keys.TAB);
        inputCampoSenha.sendKeys("secret_sauce" + Keys.TAB);
        buttonLogin.click();
    }

    public void irParaOCarrinho(){
        buttonCarrinho.click();
    }

    public void inserirNoCarrinho() {
        buttonSelectItem.click();
    }
    
}
