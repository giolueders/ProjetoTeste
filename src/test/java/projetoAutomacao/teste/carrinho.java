package projetoAutomacao.teste;


import org.junit.BeforeClass;
import org.junit.Test;

import projetoAutomacao.PageObject.carrinhoPO;

public class carrinho extends BaseTeste{


    private static carrinhoPO carrinhoPage;
    @BeforeClass
    public static void prepararTeste(){
        carrinhoPage = new carrinhoPO(driver);
    }
    

    @Test
    public void TC001_AdicionarItensNoCarrinho(){
        carrinhoPage.login();
        carrinhoPage.inserirNoCarrinho();
        carrinhoPage.inserirNoCarrinho();
    }

    @Test
    public void TC002_ContinuarComprandoEAdicionarMaisItens(){
        carrinhoPage.login();
        carrinhoPage.inserirNoCarrinho();
        carrinhoPage.irParaOCarrinho();
        carrinhoPage.continueComprando();
        carrinhoPage.inserirNoCarrinho();
        carrinhoPage.irParaOCarrinho();
    }

    @Test
    public void TC003_AdicionarERemoverItens(){
        carrinhoPage.login();
        carrinhoPage.inserirNoCarrinho();
        carrinhoPage.irParaOCarrinho();
        carrinhoPage.buttonRemoveItemCarrinho.click();
    }

    @Test
    public void TC004_RemoverItemUsandoOBotaoDoItem(){
        carrinhoPage.login();
        carrinhoPage.inserirNoCarrinho();
        carrinhoPage.buttonRemoveItemCarrinho.click();
    }

    @Test
    public void TC005_RemoverItensdoCarrinho(){
        carrinhoPage.login();
        carrinhoPage.inserirNoCarrinho();
        carrinhoPage.inserirNoCarrinho();
        carrinhoPage.irParaOCarrinho();
        carrinhoPage.buttonRemoveItemCarrinho.click();
        carrinhoPage.buttonRemoveItemCarrinho.click();
    }
    
}
