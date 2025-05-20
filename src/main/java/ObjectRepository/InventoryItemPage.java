package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage {

	@FindBy (id="add-to-cart")
	private WebElement AddToCartBtn;
	
	@FindBy (id="remove")
	private WebElement RemoveBtn;
	
	@FindBy(className ="inventory_details_price")
	private WebElement PriceOfProduct;
	
	public InventoryItemPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddToCartBtn() {
		return AddToCartBtn;
	}

	public WebElement getRemoveBtn() {
		return RemoveBtn;
	}

	public WebElement getPriceOfProduct() {
		return PriceOfProduct;
	}
	//Business library
	
	/**
	 * this method will click on add to cart btn
	 */
	public void clickOnAddToCatBtn()
	{
		AddToCartBtn.click();
	}
}
