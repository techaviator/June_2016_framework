package generic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	protected WebDriver driver  = null;
	@BeforeMethod(groups={"SmokeTest", "RegressionTest"})
	public void launchBrowser()
	{
		String browserType = UtilityClass.getconfigfile("browsertype");
		if(browserType.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		if(browserType.equalsIgnoreCase("firefox"))
		{
			driver  = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(UtilityClass.getconfigfile("URL"));
	}
	
	@AfterMethod(groups={"SmokeTest", "RegressionTest"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public void takeScreenshot(String TC_ID,String Order)
	{
		Date date = new Date();
		SimpleDateFormat simpledate = new SimpleDateFormat("dd-MM-yyyy-hhmmss");
		String format = simpledate.format(date);
		File file = new File(UtilityClass.getconfigfile("snapshot")+TC_ID+"_"+Order+"_"+format+".jpg");
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotAs,file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
