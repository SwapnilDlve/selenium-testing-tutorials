package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FluorescentRegisterPage {
	
	@FindBy(how = How.ID, using = "uname" )
	public WebElement Full_Name;
	
	@FindBy(how = How.ID, using = "email" )
	public WebElement Email;
	
	@FindBy(how = How.ID, using = "mgender" )
	public WebElement Male_Gender;
	
	@FindBy(how = How.ID, using = "fgender" )
	public WebElement Female_Gender;
	
	@FindBy(how = How.ID, using = "others" )
	public WebElement Other_Gender;
	
	@FindBy(how = How.ID, using = "DOB" )
	public WebElement Date_Of_Birth;
	
	@FindBy(how = How.ID, using = "uid" )
	public WebElement User_ID;
	
	@FindBy(how = How.ID, using = "pwd" )
	public WebElement Password;
	
	@FindBy(how = How.CSS, using = "input[type='submit']" )
	public WebElement Register_button;
}
