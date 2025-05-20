package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGPractice1 {
	@Test()
	public void ModifySample() {
		System.out.println("Modify");
		
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		//3row- 3data sets and each has 2 columns
		Object[][] data=new Object[3][2];
		
		//1st data set
		data[0][0]="Chaitra";
		data[0][1]=12;
		
		//2nd data set
		data[0][0]="Sam";
		data[0][1]=14;
		
		//3rd data set
		data[0][0]="Albert";
		data[0][1]=8;
		
		return data;
		
	}
}
