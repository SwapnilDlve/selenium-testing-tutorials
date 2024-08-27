package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FluorescentHomePage {
	
		@FindBy(how = How.LINK_TEXT, using = "Register")
		@CacheLookup
		public WebElement register_link;
		
		@FindBy(how = How.LINK_TEXT, using = "Login")
		@CacheLookup
		public WebElement Login_link;
		
		@FindBy(how = How.LINK_TEXT, using = "Cart")
		@CacheLookup
		public WebElement Cart_link;
		
		@FindBy(how = How.ID, using = "search-input" )
		public WebElement Search_Box;
	
}
