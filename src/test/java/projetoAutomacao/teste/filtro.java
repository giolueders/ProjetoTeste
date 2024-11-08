package projetoAutomacao.teste;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import projetoAutomacao.PageObject.filtroPO;

public class filtro extends BaseTeste{

    private static filtroPO filtroPage;
    @BeforeClass
    public static void prepararTeste(){
        filtroPage = new filtroPO(driver);
    }

    @Test
    public void TC_001_filtro_de_A_to_Z(){
        filtroPage.login();
        filtroPage.buttonFilter.click();
        filtroPage.filterAtoZ.click();
        boolean itemA = filtroPage.verificaItemInicialA();
        assertTrue(itemA);
    }

    @Test
    public void TC_002_filtro_de_Z_to_A(){
        filtroPage.login();
        filtroPage.buttonFilter.click();
        filtroPage.filterZtoA.click();
        boolean itemZ = filtroPage.verificaItemInicialZ();
        assertTrue(itemZ);
    }

    @Test
    public void TC_001_filtro_de_Low_to_High(){
        filtroPage.login();
        filtroPage.buttonFilter.click();
        filtroPage.filterlowtoHigh.click();
        boolean itemLow = filtroPage.verificaItemInicialA();
        assertTrue(itemLow);
    }

    @Test
    public void TC_001_filtro_de_High_to_Low(){
        filtroPage.login();
        filtroPage.buttonFilter.click();
        filtroPage.filterhightolow.click();
        boolean itemHigh = filtroPage.verificaItemInicialA();
        assertTrue(itemHigh);
    }
    
}
