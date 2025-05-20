package practice;

import org.testng.annotations.Test;

public class TestNGPractice {

	@Test(invocationCount=2,priority=2)
	public void createSample() {
		System.out.println("Create");
	}
	
	@Test
	public void ModifySample() {
		System.out.println("Modify");
	}
	
	@Test
	public void DeleteSample() {
		System.out.println("Delete");
	}
	
}
