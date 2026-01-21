package Browser;

import java.io.File;
import java.io.FileReader;
import java.util.*;
import org.openqa.selenium.*;

public class utility {

	public static String properties(String data) throws Exception {
		String propertiesData = null;
		try {
			String filePath = System.getProperty("user.dir") 
					+ File.separator+"src"
					+ File.separator+"main"
					+ File.separator+"resources"
					+ File.separator+ "Configure.properties";
			FileReader reader = new FileReader(filePath);
			Properties p = new Properties();
			p.load(reader);
			propertiesData = p.getProperty(data); // url
		} catch (Exception e) {
			System.out.println("Properties : " + e);
		}
		return propertiesData;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(utility.properties("url"));
	}

}
