package projetoAutomacao.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class filtroPO extends BasePO {

    public filtroPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "select_container")
    public WebElement buttonFilter;

    @FindBy(className = "item_4_title_link")
    public WebElement aPrimeiroItem;

    @FindBy(className = "item_3_title_link")
    public WebElement aUltimoItem;

    @FindBy(css = "#inventory_container > div > div:nth-child(1) > div.inventory_item_description > div.pricebar > div")
    public WebElement precoItemMaisBarato;

    @FindBy(css = "#inventory_container > div > div:nth-child(1) > div.inventory_item_description > div.pricebar > div")
    public WebElement precoItemMaisCaro;    

    @FindBy(xpath = "//div[@class=\"inventory_item_name \" and contains(text(), 'Test.allTheThings() T-Shirt (Red)')]")
    public WebElement itemZ;

    @FindBy(xpath = "//div[@class=\"inventory_item_name \" and contains(text(), 'Sauce Labs Backpack')]")
    public WebElement itemA;

    @FindBy(css = "#header_container > div.header_secondary_container > div > span > select > option:nth-child(1)")
    public WebElement filterAtoZ;

    @FindBy(css = "#header_container > div.header_secondary_container > div > span > select > option:nth-child(2)")
    public WebElement filterZtoA;

    @FindBy(css = "#header_container > div.header_secondary_container > div > span > select > option:nth-child(3)")
    public WebElement filterlowtoHigh;

    @FindBy(css = "#header_container > div.header_secondary_container > div > span > select > option:nth-child(4)")
    public WebElement filterhightolow;

    public boolean verificaItemInicialA(){
        return itemA.isDisplayed();        
    }

    public boolean verificaItemInicialZ(){
        return itemZ.isDisplayed();  
    }

    public boolean verificaItemInicialLow(){
        return precoItemMaisBarato.isDisplayed();  
    }

    public boolean verificaItemInicialHigh(){
            return precoItemMaisCaro.isDisplayed();   
    }   
}
