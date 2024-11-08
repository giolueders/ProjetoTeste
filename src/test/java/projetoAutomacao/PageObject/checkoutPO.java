package projetoAutomacao.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkoutPO extends BasePO {

    public checkoutPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "checkout")
    public WebElement buttonCheckout;

    @FindBy(id = "first-name")
    public WebElement inputFirstname;

    @FindBy(id = "last-name")
    public WebElement inputLastname;

    @FindBy(id = "postal-code")
    public WebElement inputPostalCode;

    @FindBy(id = "continue")
    public WebElement buttonContinueCheckout;

    @FindBy(css = "#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error > h3")
    public WebElement buttonMensagemErro;

    @FindBy(xpath = "//button[contains(text(),'Finish')]")
    public WebElement buttonFinish;

    @FindBy(className = "title")
    public WebElement spanTitle;

    @FindBy (css = "#checkout_complete_container > h2")
    public WebElement checkoutComplete;

    @FindBy(xpath = "//button[contains(text(),'Back Home')]")
    public WebElement buttonBackHome;

    public void checkout(String primeiroNome, String segundoNome, String codigoPostal){
        buttonCheckout.click();
        inputFirstname.sendKeys(primeiroNome);
        inputLastname.sendKeys(segundoNome);
        inputPostalCode.sendKeys(codigoPostal);
        buttonContinueCheckout.click();
    }

    public String verificaErroCheckout(){
        return buttonMensagemErro.getText();
    }

    public String verificaTituloPagina(){
        return spanTitle.getText();
    }
    
    public String verificaSucessoCheckout(){
        return checkoutComplete.getText();
    }
}
