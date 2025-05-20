package GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;

public class BaseClass {
	
	public FileUtility fUtil = new FileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	
	public WebDriver driver;
	
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsconfig() {
		System.out.println("---------Database connection Successful---------");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcconfig(/*String PValue*/) throws IOException {
		
		driver=new ChromeDriver();
		// For cross browser testing opening 2 browsers
//		if(PValue=="edge") {
//			driver=new ChromeDriver();
//		}else if(PValue=="chrome") {
//			driver=new ChromeDriver();
//		}else{
//			driver=new EdgeDriver();
//		}
		
		sUtil.MaxmiseWindow(driver);
		sUtil.AddImplicitylyWait(driver);
		driver.get(fUtil.readDataFromPropertyfile("url"));
		System.out.println("---------Browser launch Successful---------");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmconfig() throws IOException
	{
		String USERNAME = fUtil.readDataFromPropertyfile("username");
		String PASSWORD = fUtil.readDataFromPropertyfile("password");
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		System.out.println("---------Login to app Successful---------");
		
		sdriver=driver;
		
	}
	@AfterMethod(alwaysRun = true)
	public void amconfig() 
	{
		InventoryPage ip = new InventoryPage(driver);
		ip.logoutOfApp();
		System.out.println("---------Logout from app Successful---------");
	}
	
	//@AfterTest(alwaysRun = true)
	@AfterClass(alwaysRun = true)
	public void acconfig() {
		driver.quit();
		System.out.println("---------Broser closed Successful---------");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asconfig()
	{
		System.out.println("--------Database connection closed----------");
		}
	}
