package practice;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import GenericUtilities.FileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.SeleniumUtility;
import ObjectRepository.CartPage;
import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;

public class AddProductToCart {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Read common Data
	
		FileUtility futil= new FileUtility();
		JavaUtility jutil=new JavaUtility();
		SeleniumUtility sutil=new SeleniumUtility();
		
		//Read data from common data file
	    String URL = futil.readDataFromPropertyfile("url");
	    String USERNAME = futil.readDataFromPropertyfile("username");
	    String PASSWORD = futil.readDataFromPropertyfile("password");
				
				//Read Data from excel file
        String PRODUCTNAME = futil.readDataFromExcel("sheet1", 1, 2); 
				
				//Launch the browser
				WebDriver driver = new EdgeDriver();
				sutil.MaxmiseWindow(driver);
				sutil.AddImplicitylyWait(driver);
				
				//Load the URL
				driver.get(URL);
				
				//Login to Application
				LoginPage lp=new LoginPage(driver);
//				lp.getUsernameText().sendKeys(USERNAME);
//				lp.getPasswordText().sendKeys(PASSWORD);
//				lp.getLoginBtn().click();
				//Optimise code
				lp.LoginToApp(USERNAME, PASSWORD);
				
//				driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//				driver.findElement(By.id("password")).sendKeys(PASSWORD);
//				driver.findElement(By.id("login-button")).click();
				
				
				//Click on a product - Tshirt - Dynamic xpath
				WebElement ele = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
				String productname = ele.getText();
				ele.click();
				
				//Click on add to cart
				
				
			
				String ScreenshotName = "addProductToCart-"+jutil.getSystemDate();
				String path=sutil.capturScreenshot(driver, ScreenshotName);
				System.out.println(path);
				
				//Navigate to Cart
				CartPage ct=new CartPage(driver);
				ct.getCartIcon().click();
				
				//Validate the product in Cart
				String productIncart = ct.getProductNameInCart().getText();
				if(productIncart.equals(productname))
				{
					System.out.println("PASS");
					System.out.println(productIncart);
				}
				else
				{
					System.out.println("FAIL");
				}
				
				//Logout of Application
				driver.findElement(By.id("react-burger-menu-btn")).click();
				driver.findElement(By.linkText("Logout")).click();
			}

	

}
