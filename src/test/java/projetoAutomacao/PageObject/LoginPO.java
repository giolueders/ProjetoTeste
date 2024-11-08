package projetoAutomacao.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{

    public LoginPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#login_button_container > div > form > div.error-message-container.error > h3")
    public WebElement buttonErrorMessage;

    @FindBy(css = "#login_button_container > div > form > div.error-message-container.error > h3")
    public WebElement buttonLoginError;

    @FindBy(id = "user-name")
    public WebElement inputCampoLogin;

    @FindBy(id = "password")
    public WebElement inputCampoSenha;

    public String retorna_mensagem(){
         return this.buttonErrorMessage.getText();
    }

    public String retorna_mensagem_erro(){
        return this.buttonLoginError.getText();
   }
    
}
