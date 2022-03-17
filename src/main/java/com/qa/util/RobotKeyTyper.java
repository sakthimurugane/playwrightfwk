/**
 * 
 */
package com.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author esmfa
 *
 */
public class RobotKeyTyper {

	/**
	 * @param args
	 * @throws AWTException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chrome\\chromedriver96.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://qa.fundstransfer.cashedge.com/jsp/relh/base/login.jsp");
		driver.manage().window().maximize();
		WebElement crossBox = driver.findElement(By.name("loginName"));//.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
		String dds = (String) js.executeScript("return arguments[0].innerHTML", crossBox);
		System.out.println("dddds -->" + dds);
		String DomainName = js.executeScript("return document.domain;").toString();			
        System.out.println("Domain name of the site = "+DomainName);					
          		
        //Fetching the URL of the site. Tostring() change object to name		
        String url = js.executeScript("return document.URL;").toString();			
        System.out.println("URL of the site = "+url);					
          		
       //Method document.title fetch the Title name of the site. Tostring() change object to name		
       String TitleName = js.executeScript("return document.title;").toString();			
       System.out.println("Title of the page = "+TitleName);	
		
		
/*		Robot robot = new Robot();
		
		String otysLink="epnics.otsyapp.com";
		KeyBoard kb = new KeyBoard(robot);
		
		 * kb.type(otysLink);
		 * 
		
		for(int i=0; i < otysLink.length(); i++){
			kb.type(otysLink.charAt(i));
			Thread.sleep(1000);
		}
		
		Thread.sleep(2000);
		robot.mouseMove(30,100);*/
		Thread.sleep(2000);
		driver.quit();

	}
	

}
