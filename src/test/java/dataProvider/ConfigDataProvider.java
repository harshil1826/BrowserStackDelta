package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigDataProvider 
{
	Properties pro;
	
	
	public ConfigDataProvider()
	{
		
		File src=new File("./Configuration/config.properties");
		
		try 
		{
			FileInputStream fis=new FileInputStream(src);
			
			 pro=new Properties();
			
			pro.load(fis);
			
		} catch (Exception e) 
		{
			System.out.println("Exception is "+e.getMessage());
		}
		
	}
	
	public String getApplicationURL()
	{
		String getApplicationURL=pro.getProperty("getApplicationURL");
		return getApplicationURL;
	}
	
	
	public String getUSERNAME()
	{
		String USERNAME=pro.getProperty("USERNAME");
		return USERNAME;
	}
	
	public String getAUTOMATE_KEY()
	{
		String AUTOMATE_KEY=pro.getProperty("AUTOMATE_KEY");
		return AUTOMATE_KEY;
	}
	

}
