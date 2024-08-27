package util;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
 
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
 
@SuppressWarnings("deprecation")
public class SharedDriver extends EventFiringWebDriver {
       //assign the webdriver instance to REAL_DRIVER
	private static final WebDriver REAL_DRIVER = BrowserUtility.getBrowserInstance("edge");
 
	private static final Thread CLOSE_THREAD = new Thread() {
		@Override
		public void run() {
			REAL_DRIVER.quit();
		}
	};
 
	static {
		Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
	}
 
	public SharedDriver() {
		super(REAL_DRIVER);
	}
 
	@Override
	public void quit() {
		if (Thread.currentThread() != CLOSE_THREAD) {
			throw new UnsupportedOperationException("You shouldn't quit this WebDriver. It's shared and will quit when the JVM exits.");
		}
		super.quit();
	}
 
	@After
	public void takeScreenshotOnFailure(Scenario scenario) {
		System.out.println("in screenshot");
 
		TakesScreenshot ts = (TakesScreenshot) REAL_DRIVER;
 
		byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(src, "image/png", "screenshot");
 
 
	}
}
