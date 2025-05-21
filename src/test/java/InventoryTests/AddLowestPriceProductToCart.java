package InventoryTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.FileUtility;
import GenericUtilities.JavaUtility;
//import GenericUtilities.JavaUtility;
//import GenericUtilities.JavaUtility;
import GenericUtilities.SeleniumUtility;
import ObjectRepository.CartPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;
@Listeners(GenericUtilities.ListernersImplementation.class)
public class AddLowestPriceProductToCart extends BaseClass {
	@Test(groups="SmokeTest")
	public void TC_01_AddLowestPrciceProductToCartTest() throws IOException {
	
				// Read Data from excel file
				String PRODUCTNAME = fUtil.readDataFromExcel("Sheet1",4,3);
				// Run time data
				String SORTOPTION = fUtil.readDataFromExcel("sheet1",4,2);
				
				// Click on a product
				InventoryPage ip = new InventoryPage(driver);
				ip.clickOnLowestPriceProduct(driver, SORTOPTION, PRODUCTNAME);

				// Click on add to cart
				InventoryItemPage iip = new InventoryItemPage(driver);
				iip.clickOnAddToCatBtn();

				// Navigate to Cart
				ip.clickOnCartContainer();

				// Validate the product in Cart
				CartPage cp = new CartPage(driver);
				String ProductIncart = cp.captureItemName();
				AssertJUnit.assertEquals(PRODUCTNAME, ProductIncart);
				AssertJUnit.assertTrue(ProductIncart.contains(PRODUCTNAME));
	}

//@Test(groups = "RegressionSuite")
//public void sample()
//{
	//Assert.fail();
	//System.out.println("Sample");
//}
}
