package projetoAutomacao.teste;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import projetoAutomacao.PageObject.sandwichPO;

public class sandwich extends BaseTeste{

    private static sandwichPO sandwichPage;
    @Before
    public void prepararTeste(){
       sandwichPage = new sandwichPO(driver);
    }


    @Test
    public void TC_001_verificarSeOItemAllItensDoSanduicheEstaFuncionado() throws InterruptedException{
        sandwichPage.login();
        sandwichPage.irParaOCarrinho();
        sandwichPage.abreOSanduiche();
        Thread.sleep(7);
        sandwichPage.buttonAllItens.click();
        boolean casaco = sandwichPage.verificaItemCasaconaTela();
        boolean mochila = sandwichPage.verificaItemMochilaNaTela();
        assertTrue(mochila);
        assertTrue(casaco);

    }

    @Test
    public void TC_002_verificarSeOItemAboutDoSanduicheEstaFuncionado() throws InterruptedException{
        sandwichPage.login();
        sandwichPage.abreOSanduiche();
        Thread.sleep(100);
        sandwichPage.buttonAbout.click();
        Thread.sleep(20);
        boolean solutions = sandwichPage.verificaSpanSolutions();
        boolean testFree = sandwichPage.verificaBotaoTelaAbout();
        assertTrue(solutions);
        assertTrue(testFree);
    }

    @Test
    public void TC_003_verificarSeOItemLogoutDoSanduicheEstaFuncionado() throws InterruptedException{
        sandwichPage.login();
        sandwichPage.abreOSanduiche();
        Thread.sleep(100);
        sandwichPage.buttonLogout.click();
        boolean usersLogin = sandwichPage.verificaLogout();
        assertTrue(usersLogin);

    }
    
}
