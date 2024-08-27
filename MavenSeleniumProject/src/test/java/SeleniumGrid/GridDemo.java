package SeleniumGrid;
import java.net.MalformedURLException;
import java.net.URL;
 
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
 
public class GridDemo {
	
	@Test
	public void testgrid() throws MalformedURLException {
		DesiredCapabilities ds = new DesiredCapabilities();
		ds.setBrowserName(Browser.EDGE.browserName());
		ds.setPlatform(Platform.ANY);
		
		WebDriver browser =new RemoteWebDriver(new URL("http://USMUMSDALVE1:4444/wd/hub"), ds);    //address of the created node
		browser.manage().window().maximize();
		browser.get("http://www.google.co.in/");
		String title = browser.getTitle();
		Assert.assertTrue(title.contains("Google"));
		browser.close();
		
	}
 
}
