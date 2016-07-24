package testScripts;

import generic.BaseClass;




import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;


public class Senario_login extends BaseClass{

	Logger log = Logger.getLogger(Senario_login.class);
	@Test(dataProvider= "DP_validlogin",dataProviderClass= dataProvider.LoginDataProvider.class, groups={"SmokeTest","Regression"})
	public void Valid_Login_test(String TC_ID, String Order, String Uname, String Pwd, String Exp_Res)
	{
	
	//driver.findElement(By.linkText("Sign In")).click();
		//driver.findElement(By.name("logid")).sendKeys(Uname);
		//driver.findElement(By.name("pswd")).sendKeys(Pwd);
		//driver.findElement(By.cssSelector("td[class='sb1'] input")).click();
		
		log.info("Initialized browser for valid login scenario");
		HomePage home = new HomePage(driver);
		log.info("launched home page");
		home.clickSignIn();
		log.info("successfully in login page");
		LoginPage login = new LoginPage(driver);
		login.loginUser(Uname, Pwd);
		log.info("Enter login info correctly");
		String actual = home.getValidLoginText();
		if(actual.equalsIgnoreCase(Exp_Res))
		{
			System.out.println("The TC has passed");
			log.info("Validation successfull");
			takeScreenshot(TC_ID, Order);
		}
		else
		{
			System.out.println("The TC has failed");
			log.error("Validation fail . Ending valid login search");
			Assert.fail("THe actual is " +actual);
			
		}
		log.info("Closing browser");
		
	}
	
	@Test(dataProvider= "DP_invalidlogin",dataProviderClass= dataProvider.LoginDataProvider.class, groups={"Regression"})
	public void Invalid_Login_test(String TC_ID, String Order,String Uname, String Pwd, String Exp)
	{
		HomePage home = new HomePage(driver);
		home.clickSignIn();
		LoginPage login = new LoginPage(driver);
		login.loginUser(Uname, Pwd);
		/*driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.name("logid")).sendKeys(Uname);
		driver.findElement(By.name("pswd")).sendKeys(Pwd);
		driver.findElement(By.cssSelector("td[class='sb1'] input")).click();*/
		//String actual = driver.findElement(By.xpath("//b[contains(text() , 'Sorry')]")).getText();
		String actual = login.invalidLoginText();
		if(actual.equalsIgnoreCase(Exp))
		{
			System.out.println("The TC has passed");
		}
		else
		{
			System.out.println("The TC has failed");
		}
		
	}
	
	

}
