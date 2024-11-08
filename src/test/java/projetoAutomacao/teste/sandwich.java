package projetoAutomacao.teste;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import projetoAutomacao.PageObject.sandwichPO;

public class sandwich extends BaseTeste{

    private static sandwichPO sandwichPage;
    @BeforeClass
    public static void prepararTeste(){
       sandwichPage = new sandwichPO(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, 10);

    @Test
    public void TC_001_verificarSeOItemAllItensDoSanduicheEstaFuncionado() throws InterruptedException{
        sandwichPage.login();
        sandwichPage.irParaOCarrinho();
        sandwichPage.abreOSanduiche();
        Thread.sleep(3);
        sandwichPage.buttonAllItens.click();
        boolean casaco = sandwichPage.verificaItemCasaconaTela();
        boolean mochila = sandwichPage.verificaItemMochilaNaTela();
        assertTrue(mochila);
        assertTrue(casaco);

    }

    @Test
    public void TC_002_verificarSeOItemAboutDoSanduicheEstaFuncionado(){
        sandwichPage.login();
        sandwichPage.abreOSanduiche();
        @SuppressWarnings("unused")
        WebElement about = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("about_sidebar_link")));
        sandwichPage.buttonAbout.click();
        @SuppressWarnings("unused")
        WebElement solutionsbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Solutions')]")));
        boolean solutions = sandwichPage.verificaSpanSolutions();
        boolean testFree = sandwichPage.verificaBotaoTelaAbout();
        assertTrue(solutions);
        assertTrue(testFree);
    }

    @Test
    public void TC_003_verificarSeOItemLogoutDoSanduicheEstaFuncionado(){
        sandwichPage.login();
        sandwichPage.abreOSanduiche();
        @SuppressWarnings("unused")
        WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        sandwichPage.buttonLogout.click();
        boolean usersLogin = sandwichPage.verificaLogout();
        assertTrue(usersLogin);

    }
    
}
