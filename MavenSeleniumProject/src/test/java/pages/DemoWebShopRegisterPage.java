package pages;
 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
 
public class DemoWebShopRegisterPage {
 
	@FindBy(how = How.ID, using = "gender-male")
	public WebElement gender_radio;
	
	@FindBy(id="FirstName")
	public WebElement first_name_text;
	
	@FindBy(id ="LastName")
	public WebElement last_name_text;
	
	@FindBy(id="Email")
	public WebElement email_text;
	
	@FindBy(how = How.ID, using ="Password")
	public WebElement password_text;
	
//	@FindBy(how = How.ID, using ="ConfirmPassword")
	@FindBy(how = How.ID, using ="confirmPassword")
	public WebElement confirm_password_text;
	
	@FindBy(how = How.ID, using ="register-button")
	public WebElement register_button;
	
}