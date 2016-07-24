package testScripts;

import generic.BaseClass;

import org.testng.annotations.Test;

import pageObjectModel.HomePage;

public class Search_Scenario extends BaseClass {
	
	
	@Test(dataProvider = "DP_validSearch",dataProviderClass= dataProvider.SearchDataProvider.class, groups={"SmokeTest", "RegressionTest"})
	public void Valid_Search(String TC_ID, String Order,String Searchitem,String expected)
	{
		
		/*driver.findElement(By.id("srchword")).sendKeys(Searchitem);
		driver.findElement(By.className("newsrchbtn")).click();
		String actual = driver.findElement(By.id("find")).getText();*/
		HomePage home = new HomePage(driver);
		home.searchKeyword(Searchitem);
		String actual = home.getValidSearchText();
		if(actual.equalsIgnoreCase(expected))
		{
			System.out.println("Search TC passed");
		}
		else
		{
			System.out.println("SEarch TC failed");
			takeScreenshot(TC_ID, Order);
		}
		
	}
	
	@Test(dataProvider = "DP_invalidSearch",dataProviderClass= dataProvider.SearchDataProvider.class, groups={ "RegressionTest"})
	public void Invalid_Search(String TC_ID, String Order,String Searchitem,String expected)
	{
		
	/*	driver.findElement(By.id("srchword")).sendKeys(Searchitem);
		driver.findElement(By.className("newsrchbtn")).click();
		driver.findElement(By.className("sorrymsg")).getText();*/
		
		HomePage home = new HomePage(driver);
		home.searchKeyword(Searchitem);
		String actual = home.getInvalidSearchText();
		
		if(actual.contentEquals(expected))
		{
			System.out.println("Search TC passed");
		}
		else
		{
			System.out.println("Search TC failed");
		}
		
	}

}
