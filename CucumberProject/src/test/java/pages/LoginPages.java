package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPages {
	
	@FindBy(id="Email")
	public static WebElement Email;
	
	@FindBy(id="Password")
	public static WebElement Password;
	
	@FindBy(css=".button-1.login-button")
	public static WebElement Login;
	
	@FindBy(linkText ="Log out")
	public static WebElement Logout;
	
}
