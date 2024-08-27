package pages;
 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
 
public class DemoWebShopLogin {
 
	@FindAll({@FindBy(name="Email"),@FindBy(id="Email")})
	public WebElement email_text;
	
	@FindBys({@FindBy(name="Password"),@FindBy(id="password")})
	public WebElement password_text;
	
	@FindBys({@FindBy(tagName="Password"),@FindBy(css = "input[value = 'Log in']")})
	public WebElement login_button;
}
