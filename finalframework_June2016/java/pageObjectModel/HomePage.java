package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//driver.findElement(By.linkText("Sign In")).click();
	//driver.findElement(By.xpath("//a[@href='http://mypage.rediff.com/profile/myprofile']")).getText();
	WebDriver driver = null;
	@FindBy(linkText="Sign In")
	private WebElement SignInLink;
	
	@FindBy(xpath="//a[@href='http://mypage.rediff.com/profile/myprofile']")
	private WebElement ValidLoginText;
	
	/*driver.findElement(By.id("srchword")).sendKeys(Searchitem);
	driver.findElement(By.className("newsrchbtn")).click();
	 driver.findElement(By.id("find")).getText();
	 driver.findElement(By.className("sorrymsg")).getText();*/
	
	@FindBy(id="srchword")
	private WebElement searchword;
	
	@FindBy(className="sorrymsg")
	private WebElement InvalidSearchText;
	
	
	@FindBy(className="newsrchbtn")
	private WebElement searchbutton;
	
	@FindBy(id="find")
	private WebElement ValidSearchText;
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickSignIn()
	{
		SignInLink.click();
	}
	
	public String getValidLoginText()
	{
		return ValidLoginText.getText();
	}
	
	public void searchKeyword(String searchkey)
	{
		searchword.sendKeys(searchkey);
		searchbutton.click();
	}
	
	public String getValidSearchText()
	{
		return ValidSearchText.getText();
	}
	
	public String getInvalidSearchText()
	{
		return InvalidSearchText.getText();
	}

}
