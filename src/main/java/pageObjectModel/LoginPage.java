package pageObjectModel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver = null;
	
	@FindBy(name = "logid")
	private WebElement Username;
	
	@FindBy(name = "pswd")
	private WebElement Password;
	
	@FindBy(css = "td[class='sb1'] input")
	private WebElement LoginButton;
	
	@FindBy(xpath = "//b[contains(text() , 'Sorry')]")
	private WebElement InvalidLoginText;
	
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loginUser(String Uname, String Pwd)
	{
		Username.sendKeys(Uname);
		Password.sendKeys(Pwd);
		LoginButton.click();
	}
	
	public String invalidLoginText()
	{
		return InvalidLoginText.getText();
	}
}
