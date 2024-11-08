package projetoAutomacao.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class sandwichPO extends BasePO{

    public sandwichPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "react-burger-menu-btn")
    public WebElement buttonSandwich;

    @FindBy(id = "logout_sidebar_link")
    public WebElement buttonLogout;

    @FindBy(id = "about_sidebar_link")
    public WebElement buttonAbout;

    @FindBy(id = "inventory_sidebar_link")
    public WebElement buttonAllItens;

    @FindBy(css = "#item_4_title_link > div")
    public WebElement titleMochila;

    @FindBy(css = "#item_3_title_link > div")
    public WebElement titleCasacoLaranja;
    
    @FindBy(xpath = "//button[contains(text(),'Test it all. Free')]")
    public WebElement buttonTestFree;
    
    @FindBy(xpath = "//span[contains(text(),'Solutions')]")
    public WebElement spanSolutions;

    @FindBy(id = "login_credentials")
    public WebElement divCredentials;

    public boolean verificaItemMochilaNaTela(){
        return titleMochila.isDisplayed();        
    }

    public boolean verificaItemCasaconaTela(){
        return titleCasacoLaranja.isDisplayed();
    }

    public boolean verificaBotaoTelaAbout(){
        return buttonTestFree.isDisplayed();
    }

    public boolean verificaSpanSolutions(){
        return spanSolutions.isDisplayed();
    }

    public void abreOSanduiche(){
        buttonSandwich.click();   
    }

    public boolean verificaLogout(){
        return divCredentials.isDisplayed();
    }


}
