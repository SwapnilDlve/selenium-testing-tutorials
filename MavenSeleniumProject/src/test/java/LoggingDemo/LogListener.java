package LoggingDemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class LogListener implements ITestListener{
	
	Logger log = LogManager.getLogger(LogListener.class);

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("test started ->"+ result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("test success ->"+ result.getMethod().getMethodName());
		Reporter.log("test success -> "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("test failure ->"+ result.getMethod().getMethodName());
		log.info("Message : "+ result.getThrowable().getMessage());
		Reporter.log("test fail -> "+result.getMethod().getMethodName());
		Reporter.log("Message : "+result.getThrowable().getMessage());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("test skipped ->"+ result.getMethod().getMethodName());
		Reporter.log("test skipped -> "+result.getMethod().getMethodName());
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("test project start");
	}
 
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("test project finish");
	}
	
	
	
}
