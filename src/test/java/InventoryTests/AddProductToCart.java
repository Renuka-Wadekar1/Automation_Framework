package InventoryTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.FileUtility;
//import GenericUtilities.JavaUtility;
//import GenericUtilities.JavaUtility;
import GenericUtilities.SeleniumUtility;
import ObjectRepository.CartPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;
@Listeners(GenericUtilities.ListernersImplementation.class)
public class AddProductToCart extends BaseClass{
	@Test(groups = "SmokeTest")
	public void TC_01_AddProductToCartTest() throws IOException {
			
			// Read Data from excel file
			String PRODUCTNAME = fUtil.readDataFromExcel("Sheet1",1,2);
			// Run time data

			// Click on a product 
			InventoryPage ip = new InventoryPage(driver);
			ip.clickOnAProduct(driver, PRODUCTNAME);

			// Click on add to cart
			InventoryItemPage iip = new InventoryItemPage(driver);
			iip.clickOnAddToCatBtn();

			// Navigate to Cart
			ip.clickOnCartContainer();

			// Validate the product in Cart
			CartPage cp = new CartPage(driver);
			String ProductIncart = cp.captureItemName();
			if(ProductIncart.equals(PRODUCTNAME))
			{
				System.out.println("PASS");
				System.out.println(ProductIncart);
			}
			else {
				System.out.println("FAIL");
			}
			

		}
	
	@Test(groups = "SmokeTest")
	public void sample()
	{
		System.out.println("Sample");
	}
}
