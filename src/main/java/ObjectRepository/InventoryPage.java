package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.SeleniumUtility;

public class InventoryPage extends SeleniumUtility{ //Rule1
	//Rule 2 Declaration
	
	@FindBy (id="shopping_cart_container")
	private WebElement CartContainer;
	
	@FindBy (className ="product_sort_container")
	private WebElement sortbyoption;
	
	@FindBy (id="react-burger-menu-btn") 
	private WebElement hamburgerMennu;
	
	@FindBy (id="logout_sidebar_link")
	private WebElement logOutBtn;

	public InventoryPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCartContainer() {
		return CartContainer;
	}

	public WebElement getSortbyPrice() {
		return sortbyoption;
	}

	public WebElement getHamburgerMennu() {
		return hamburgerMennu;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}
	
	 
	
	 
	 public void logoutOfApp() {
		 hamburgerMennu.click();
		 logOutBtn.click();
	 }
	 
		// Business Library
		/**
		 * This method will click on a dynamic product
		 * 
		 * @param driver
		 * @param productName
		 */
		public void clickOnAProduct(WebDriver driver, String productName) {
			driver.findElement(By.xpath("//div[.='" + productName + "']")).click();
		}

		/**
		 * This method will click on cart container button
		 */
		public void clickOnCartContainer() {
			CartContainer.click();
		}

		/**
		 * This method will logout of Application
		 */
		

		/**
		 * This method will sort the lowest price product and click on it
		 * 
		 * @param driver
		 * @param sortoption
		 * @param productName
		 */
		public void clickOnLowestPriceProduct(WebDriver driver, String sortoption, String productName) {
			handdelDropdown(sortbyoption, sortoption);
			driver.findElement(By.xpath("//div[.='" + productName + "']")).click();
		}
	
	
	

}
