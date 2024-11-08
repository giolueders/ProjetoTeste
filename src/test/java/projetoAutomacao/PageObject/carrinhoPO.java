package projetoAutomacao.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class carrinhoPO extends BasePO{

    @FindBy(id = "continue-shopping")
    public WebElement buttonContinueShopping;

    @FindBy(xpath = "//button[contains(text(),'Remove')]")
    public WebElement buttonRemoveItemCarrinho;

    @FindBy(xpath = "//button[contains(text(),'Remove')]")
    public WebElement buttonRemoveItem;

    /**
     * @param driver
     */
    public carrinhoPO(WebDriver driver) {
        super(driver);
    }

    public void continueComprando(){
        buttonContinueShopping.click();
    }

    
    
}
