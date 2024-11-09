package projetoAutomacao.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;

import projetoAutomacao.PageObject.LoginPO;

public class Login extends BaseTeste {

    private static LoginPO loginPage;

    @Before
        public void prepararTeste(){
        loginPage = new LoginPO(driver);
    }
   

    @Test
     public void TC001_login(){   
        loginPage.inputCampoLogin.sendKeys("standard_user" + Keys.TAB);
        loginPage.inputCampoSenha.sendKeys("secret_sauce" + Keys.TAB);
        loginPage.buttonLogin.click();
    }

    @Test
    public void TC002_LoginSemUsuario(){
        loginPage.inputCampoLogin.sendKeys("");
        loginPage.inputCampoSenha.sendKeys("secret_sauce");
        loginPage.buttonLogin.click();
        String mensagem = loginPage.retorna_mensagem();

        assertEquals("Epic sadface: Username is required",mensagem);
    }

    @Test
    public void TC003_LoginSemSenha(){
        loginPage.inputCampoLogin.sendKeys("standard_user");
        loginPage.inputCampoSenha.sendKeys("");
        loginPage.buttonLogin.click();
        String mensagem = loginPage.retorna_mensagem();

        assertEquals("Epic sadface: Password is required",mensagem);
    }

    @Test
    public void TC004_LoginSemUsuarioeSemSenha(){
        loginPage.inputCampoLogin.sendKeys("");
        loginPage.inputCampoSenha.sendKeys("");
        loginPage.buttonLogin.click();
        String mensagem = loginPage.retorna_mensagem();

        assertEquals("Epic sadface: Username is required",mensagem);
    }

    @Test
    public void TC005_LoginComUsuarioErrado(){
        loginPage.inputCampoLogin.sendKeys("aloha");
        loginPage.inputCampoSenha.sendKeys("secret_sauce");
        loginPage.buttonLogin.click();
        String mensagemErro = loginPage.retorna_mensagem_erro();

        assertEquals("Epic sadface: Username and password do not match any user in this service",mensagemErro);
    }
     
    @Test
    public void TC006_LoginComSenhaErrada(){
        loginPage.inputCampoLogin.sendKeys("standard_user");
        loginPage.inputCampoSenha.sendKeys("1234");
        loginPage.buttonLogin.click();
        String mensagemErro = loginPage.retorna_mensagem_erro();

        assertEquals("Epic sadface: Username and password do not match any user in this service",mensagemErro);
    }
    
    @Test
    public void TC007_LoginComUsuarioeSenhaErrados(){
        loginPage.inputCampoLogin.sendKeys("aloha");
        loginPage.inputCampoSenha.sendKeys("1234");
        loginPage.buttonLogin.click();
        String mensagemErro = loginPage.retorna_mensagem_erro();

        assertEquals("Epic sadface: Username and password do not match any user in this service",mensagemErro);
    }
}
