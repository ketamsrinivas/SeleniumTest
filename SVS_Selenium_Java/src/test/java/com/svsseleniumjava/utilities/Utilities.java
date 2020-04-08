package com.svsseleniumjava.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utilities {

	String projectPath = System.getProperty("user.dir");
	String filePAth = projectPath + File.separator
			+ "//src//test//java//com//seleniumjava//testdata//config.properties";

	public String getPropertyValue(String strKey) {

		String strValue = "";

		try {
			Properties prop = new Properties();
			File file = new File(filePAth);
			if (file.exists()) {
				FileInputStream fis = new FileInputStream(file);
				prop.load(fis);
				strValue = prop.getProperty(strKey);
			} else {
				System.out.println("<File not found!! Try again.>");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return strValue;

	}

}
