package GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer {

	int count=0;
	int RetryCount=3;  //Manually Analysed
	
	@Override
	public boolean retry(ITestResult result) {
		
		
		while(count<RetryCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
