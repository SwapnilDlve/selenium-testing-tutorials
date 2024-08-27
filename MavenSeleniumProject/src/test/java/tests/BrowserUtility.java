package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtility {
	
	static public WebDriver getBrowserInstance(String browserName) {
		if(browserName.equalsIgnoreCase("edge")) {
			WebDriver edge = new EdgeDriver();
			edge.manage().window().maximize();
			edge.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			return edge;
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriver fire = new FirefoxDriver();
			fire.manage().window().maximize();
			fire.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			return fire;
		}else {
			return null;
		}
	}
	
}
