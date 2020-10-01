package com.tktv.tests;

import java.util.ArrayList;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class Assignment1 
{
	Assignment1()
	{
		System.setProperty("webdriver.chrome.driver","E:/pavan/Sel_Java_workspace/First_workspace/AutomationAssign/src/main/resources/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		// Enter URL 
		driver.get("https://www.collegeweeklive.com/chat/new.html?LTChatTestFive");
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//Switch to frame
		driver.switchTo().frame("cwlChat");
		// Click on widget
		driver.findElement(By.xpath("//p[contains(text(), 'Contact Us')]")).click();
		
		// Click on Privacy Policy
		WebElement ele = driver.findElement(By.linkText("Privacy Policy"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
	
		
		
		// Switch to newly opened window
		ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		// Perform assertion
		String DateText= driver.findElement(By.xpath("//div[@class='entry-content']/p[1]")).getText();
		Assert.assertEquals("Updated: July 29, 2020", DateText);
		
		//Close the browser
		driver.quit();
	}



public static void main(String[] args) 
{
	Assignment1 obj=new Assignment1();

	
}
}
