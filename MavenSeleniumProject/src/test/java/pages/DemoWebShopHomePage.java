package pages;
 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
 
public class DemoWebShopHomePage {
 
	@FindBy(how = How.LINK_TEXT, using = "Register")
	@CacheLookup
	public WebElement register_link;
	
	@FindBy(how = How.LINK_TEXT, using = "Log in")
	public WebElement login_link;
	
}