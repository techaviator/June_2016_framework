package dataProvider;

import generic.ExcelReader;
import generic.UtilityClass;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;

public class SearchDataProvider {
	
	@DataProvider(name = "DP_validSearch")
	public static Object[][] validSearch_DP()
	{
		ArrayList<String> ls = getXLData("Valid_Search");
		Object[][] obj = new Object[ls.size()][4];
		
		for(int i = 0;i<ls.size();i++)
		{
			obj[i][0]= ls.get(i).split(";")[0];
			obj[i][1]= ls.get(i).split(";")[1];
			obj[i][2]= ls.get(i).split(";")[2];
			obj[i][3]= ls.get(i).split(";")[3];
		}
		
		return obj;
	}
	
	@DataProvider(name = "DP_invalidSearch")
	public static Object[][] invalidSearch_DP()
	{
		
		ArrayList<String> ls = getXLData("Invalid_Search");
		Object[][] obj = new Object[ls.size()][4];
		
		for(int i = 0;i<ls.size();i++)
		{
			obj[i][0]= ls.get(i).split(";")[0];
			obj[i][1]= ls.get(i).split(";")[1];
			obj[i][2]= ls.get(i).split(";")[2];
			obj[i][3]= ls.get(i).split(";")[3];
		}
		
		return obj;
		
	}
	
	public static ArrayList<String> getXLData(String scriptname)
	{
		ExcelReader xl = new ExcelReader(UtilityClass.getconfigfile("xlpath"));
		String sheetname = "Scenario_Search";
		ArrayList<String> ls = new ArrayList<String>();
		for(int i =1;i<=xl.getXLRowCount(sheetname);i++)
		{
			if((xl.readXLData(sheetname, i, "Execute_Flag").equalsIgnoreCase("Y"))&&(xl.readXLData(sheetname, i, "Scriptname").equalsIgnoreCase(scriptname)))
			{
				String TC_ID = xl.readXLData(sheetname, i, "TC_ID");
				String Order = xl.readXLData(sheetname, i, "Order");
				String searchitem = xl.readXLData(sheetname, i, "Search_Item");
				String Expected = xl.readXLData(sheetname, i, "Exp_Res");
				ls.add(TC_ID+";"+Order+";"+searchitem+";"+Expected);
			}
		}
		return ls;
	}

}
