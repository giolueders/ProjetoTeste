package projetoAutomacao.teste;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import projetoAutomacao.PageObject.checkoutPO;

public class checkout extends BaseTeste {

    private static checkoutPO checkoutPage;
    @Before
    public void prepararTeste(){
        checkoutPage = new checkoutPO(driver);
    }

    @Test
    public void TC001_CheckoutSemValores(){
        checkoutPage.login();
        checkoutPage.inserirNoCarrinho();
        checkoutPage.irParaOCarrinho();
        checkoutPage.checkout("", "", "");   
        String erro = checkoutPage.verificaErroCheckout();
        assertTrue(erro, erro.contains("Error: First Name is required"));   
    }

    @Test
    public void TC002_CheckoutSemPrimeiroNome(){
        checkoutPage.login();
        checkoutPage.inserirNoCarrinho();
        checkoutPage.irParaOCarrinho();
        checkoutPage.checkout("", "Silva", "12345");   
        String erro = checkoutPage.verificaErroCheckout();
        assertTrue(erro, erro.contains("Error: First Name is required"));   
    }

    @Test
    public void TC003_CheckoutSemUltimoNome(){
        checkoutPage.login();
        checkoutPage.inserirNoCarrinho();
        checkoutPage.irParaOCarrinho();
        checkoutPage.checkout("José", "", "12345");   
        String erro = checkoutPage.verificaErroCheckout();
        assertTrue(erro, erro.contains("Error: Last Name is required"));   
    }

    @Test
    public void TC003_CheckoutSemCodigoPostal(){
        checkoutPage.login();
        checkoutPage.inserirNoCarrinho();
        checkoutPage.irParaOCarrinho();
        checkoutPage.checkout("José", "Silva", "");   
        String erro = checkoutPage.verificaErroCheckout();
        assertTrue(erro, erro.contains("Error: Postal Code is required"));   
    }

    @Test
    public void TC004_Checkout(){
        checkoutPage.login();
        checkoutPage.inserirNoCarrinho();
        checkoutPage.irParaOCarrinho();
        checkoutPage.checkout("José", "Silva", "12345");   
        String titulo = checkoutPage.verificaTituloPagina();
        assertTrue(titulo, titulo.contains("Checkout: Overview"));  
        checkoutPage.buttonFinish.click(); 
        String sucesso = checkoutPage.verificaTituloPagina();
        assertTrue(sucesso, sucesso.contains("Checkout: Complete!"));
    }

    @Test
    public void TC005_verificarSeOBotaoBackHomeRetornaParaPaginaInicial(){
        checkoutPage.login();
        checkoutPage.inserirNoCarrinho();
        checkoutPage.irParaOCarrinho();
        checkoutPage.checkout("José", "Silva", "12345");   
        String titulo = checkoutPage.verificaTituloPagina();
        assertTrue(titulo, titulo.contains("Checkout: Overview"));  
        checkoutPage.buttonFinish.click(); 
        String sucesso = checkoutPage.verificaTituloPagina();
        assertTrue(sucesso, sucesso.contains("Checkout: Complete!"));
        checkoutPage.buttonBackHome.click();
    }
    
}
