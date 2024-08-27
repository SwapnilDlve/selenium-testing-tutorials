package tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryForAll implements IRetryAnalyzer{

	int counter = 1;
	int retry = 5;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(counter<=retry) {
			counter++;
			return true;
		}
		
		return false;
	}
	
}		
