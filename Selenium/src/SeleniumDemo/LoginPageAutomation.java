package SeleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
import SeleniumDemo.LoginPageData;
 
public class LoginPageAutomation {
    
    WebDriver browser;
    LoginPageData loginPageData;
    
    @BeforeClass
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        
        browser.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407&AdSource=aw-DC-Templates-SEM&gad_source=1&gclid=CjwKCAiArfauBhApEiwAeoB7qK1f-5BwfkN7CY4u4giITdBh9mEYi6Bu-LjJoOAwqJvs18pfKFNE1hoCgHwQAvD_BwE");
        loginPageData = new LoginPageData();
    }
 
    @Test
    public void testLoginIn(){
        WebElement firstName = browser.findElement(By.id("RESULT_TextField-1"));
        firstName.sendKeys(loginPageData.getFirstName()); //FirstName
        
        WebElement lastName = browser.findElement(By.id("RESULT_TextField-2"));
        lastName.sendKeys(loginPageData.getLastName()); //LastName
        
        WebElement phone = browser.findElement(By.id("RESULT_TextField-3"));
        phone.sendKeys(loginPageData.getphone()); //Phone
        
        WebElement country = browser.findElement(By.id("RESULT_TextField-4"));
        country.sendKeys(loginPageData.getCountry()); //Country
        
        WebElement city = browser.findElement(By.id("RESULT_TextField-5"));
        city.sendKeys(loginPageData.getCity()); //City
        
        WebElement emailAddress = browser.findElement(By.id("RESULT_TextField-6"));
        emailAddress.sendKeys(loginPageData.getEmail()); //Email
        
        //Select Gender
        String gender = loginPageData.getGender();
        if(gender.equals("male")) {
            browser.findElement(By.id("RESULT_TextField-7_0")).click();
        }
        else {
            browser.findElement(By.id("RESULT_TextField-7_1")).click();
        }
        
        //Select Days Worked
        String daysWorked = loginPageData.getDaysWorked();
        String[] days = daysWorked.split(" ");
        for(String day : days) {
            browser.findElement(By.id("RESULT_TextField-8")).sendKeys(day);
        }
        
        //Select Timings
        String time = loginPageData.getTime();
        Select timeDropDown = new Select(browser.findElement(By.id("RESULT_TextField-9")));
        timeDropDown.selectByVisibleText(time);
        
        //Upload File
        String filePath = loginPageData.getFilePath();
        browser.findElement(By.id("RESULT_TextField-10")).sendKeys(filePath);
        
        //Click on Submit
        WebElement submit = browser.findElement(By.id("RESULT_TextField-11"));
        submit.click();
    }
        
    @AfterClass
    public void tearDown() {
        browser.quit();
    }
}
