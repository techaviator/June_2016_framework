package dataProvider;

import generic.ExcelReader;
import generic.UtilityClass;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
	
	@DataProvider(name = "DP_validlogin")
	public static Object[][] validLoginDP()
	{
		
		
	/*	obj[0][0]="qtpworld2008@gmail.com";
		obj[0][1]="learn123";
		obj[0][2]="qtpworld2008 g";*/
		ArrayList<String> ls = getXLdata("Valid_Login_test");
		Object[][] obj = new Object[ls.size()][5];
		for(int i = 0;i<ls.size();i++)
		{
			obj[i][0]=ls.get(i).split(";")[0];
			obj[i][1]=ls.get(i).split(";")[1];
			obj[i][2]=ls.get(i).split(";")[2];
			obj[i][3]=ls.get(i).split(";")[3];
			obj[i][4]=ls.get(i).split(";")[4];
		}		
		return obj;
	}
	
	@DataProvider(name = "DP_invalidlogin")
	public static Object[][] invalidLoginDP()
	{
		//Object[][] obj = new Object[1][3];
		
		/*obj[0][0]="qtpworld2008@gmail.com";
		obj[0][1]="learn123";
		obj[0][2]="qtpworld2008 g";*/
		ArrayList<String> ls = getXLdata("Invalid_Login_test");
		Object[][] obj = new Object[ls.size()][5];
		for(int i = 0;i<ls.size();i++)
		{
			obj[i][0]=ls.get(i).split(";")[0];
			obj[i][1]=ls.get(i).split(";")[1];
			obj[i][2]=ls.get(i).split(";")[2];
			obj[i][3]=ls.get(i).split(";")[3];
			obj[i][4]=ls.get(i).split(";")[4];
		}
		return obj;
	}
	
	public static ArrayList<String> getXLdata(String scriptname)
	{
		ExcelReader xl = new ExcelReader(UtilityClass.getconfigfile("xlpath"));
		String sheetname = "Scenario_Login";
		ArrayList<String> ls = new ArrayList<String>();
		for(int i =1;i<=xl.getXLRowCount(sheetname);i++)
		{
			if((xl.readXLData(sheetname, i, "Execute_Flag").equalsIgnoreCase("Y"))&&(xl.readXLData(sheetname, i, "Scriptname").equalsIgnoreCase(scriptname)))
			{
				String TC_ID = xl.readXLData(sheetname, i, "TC_ID");
				String Order = xl.readXLData(sheetname, i, "Order");
				String Uname = xl.readXLData(sheetname, i, "Uname");
				String Pwd = xl.readXLData(sheetname, i, "Pwd");
				String Exp_Res = xl.readXLData(sheetname, i, "Exp_Res");
				ls.add(TC_ID+";"+Order+";"+Uname+";"+Pwd+";"+Exp_Res);
				
			}
		}return ls;
	}

}
