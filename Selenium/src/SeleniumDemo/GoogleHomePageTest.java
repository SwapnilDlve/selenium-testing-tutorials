package SeleniumDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class GoogleHomePageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();	
		browser.get("https://www.google.com/");
		String title = browser.getTitle();
		System.out.println(title);
		browser.quit();
	}

}
