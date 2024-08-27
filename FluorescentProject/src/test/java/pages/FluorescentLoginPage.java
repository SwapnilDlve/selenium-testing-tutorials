package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FluorescentLoginPage {
	
	@FindBy(how = How.ID, using = "uid" )
	public WebElement Username;
	
	@FindBy(how = How.ID, using = "pwd" )
	public WebElement Password;
	
	@FindBy(how = How.ID, using = "submit" )
	public WebElement Login;
	
	@FindBy(how = How.LINK_TEXT, using = "Forgot password?" )
	public WebElement Forgot_Password;
}
