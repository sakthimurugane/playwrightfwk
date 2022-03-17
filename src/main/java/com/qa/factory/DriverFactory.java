package com.qa.factory;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.util.Browsers;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	//public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	private static HashMap<Browsers, WebDriver> driverMap = new HashMap<>();


	/**
	 * This method is used to initialize the threadlocal driver on the basis of
	 * given browser
	 * 
	 * @param browser
	 * @return this will return WebDriver.
	 */
	public void init_driver(Browsers browserId, String browser) {

		System.out.println("browser value is: " + browser);
		WebDriver wd = null;
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			wd = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			wd = new FirefoxDriver();
		} else if (browser.equals("safari")) {
			wd = new SafariDriver();
		} else {
			System.out.println("Please pass the correct browser value: " + browser);
		}

		wd.manage().deleteAllCookies();
		//wd.manage().window().maximize();
		if(browserId == Browsers.BrowserA){
			driverMap.put(Browsers.BrowserA, wd);
		}
		else{
			driverMap.put(Browsers.BrowserB, wd);
		}
	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
/*	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}*/

	public static synchronized WebDriver getDriver(Browsers browserId){
		if(browserId == Browsers.BrowserA){
			return driverMap.get(Browsers.BrowserA);
		}else{
			return driverMap.get(Browsers.BrowserB);
		}
	}
	

}
