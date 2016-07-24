package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UtilityClass {
	
	public static String getconfigfile(String key)
	{
		FileInputStream fis=null;
		try {
			fis =  new FileInputStream("D:\\JavaWorkspace_2016\\SeleniumFrameWork_june_2016\\src\\main\\resources\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop.getProperty(key);
		//System.out.println(property);
		
		
	}
	
	/*public static void main(String[] args) {
		System.out.println(getconfigfile());
		
	}*/

}
