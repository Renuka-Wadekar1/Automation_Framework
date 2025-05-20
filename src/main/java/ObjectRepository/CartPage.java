package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	@FindBy (id="shopping_cart_container")
	private WebElement CartIcon;
	
	@FindBy (className = "inventory_item_name")
	private WebElement ProductNameInCart;
	
	@FindBy (id="remove-sauce-labs-onesie")
	private WebElement removeBtn;
	
	@FindBy (id="checkout")
	private WebElement checkoutBtn;
	
	@FindBy (id="continue-shopping")
	private WebElement continueShoppingBtn;
	
	@FindBy (className ="inventory_item_price")
	private WebElement PriceInCart;
	
	public CartPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getCartIcon() {
		return CartIcon;
	}

	public WebElement getProductNameInCart() {
		return ProductNameInCart;
	}

	public WebElement getRemoveBtn() {
		return removeBtn;
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}

	public WebElement getContinueShoppingBtn() {
		return continueShoppingBtn;
	}

	public WebElement getPriceInCart() {
		return PriceInCart;
	}
	//Business library
	
		/**
		 * This method will capture product name and return to caller
		 * @return
		 */
		public String captureItemName()
		{
			return ProductNameInCart.getText();
		}
		
		/**
		 * This method will click on remove btn
		 */
		public void clickOnRemoveBtn()
		{
			removeBtn.click();
		}

}
