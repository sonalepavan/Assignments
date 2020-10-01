package com.tktv.tests;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 
{
	Assignment2()
	{
		System.setProperty("webdriver.chrome.driver","E:/pavan/Sel_Java_workspace/First_workspace/AutomationAssign/src/main/resources/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		// Enter URL 
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		//Close sign in window
		WebElement sign_in_cross = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
		sign_in_cross.click();
		
		// Enter iphone as a value to search box
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("iphone");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// Find list of all products, their prices and their ratings.
		List<WebElement> list_of_products = driver.findElements(By.xpath("//div[@class='_3wU53n']"));
		List<WebElement> list_of_products_price = driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
		List<WebElement> ratings=driver.findElements(By.xpath("//div[@class='niH0FQ']/span[1]/div"));
		List<WebElement> rom=driver.findElements(By.xpath("//div[@class='_3ULzGw']/ul/li[1]"));
		List<WebElement> camera=driver.findElements(By.xpath("//div[@class='_3ULzGw']/ul/li[3]"));
		List<WebElement> display=driver.findElements(By.xpath("//div[@class='_3ULzGw']/ul/li[2]"));
		
	
		String product_price,product_rating;
		String[] ProdName = new String[list_of_products.size()];
		int[] IntProdPrice = new int[list_of_products_price.size()]; 
		String[] StrRating =new String[ratings.size()];
		String[] ROM=new String[rom.size()];
		String[] CAMERA=new String[camera.size()];
		String[] DISPLAY=new String[display.size()];

        // Convert List of web element to String and integer array
        for (int i =0; i < list_of_products.size(); i++) 
        {
        	//Product Name Conversion
        	ProdName[i] = list_of_products.get(i).getText();
        	
        	//Product Price Conversion
        	product_price = list_of_products_price.get(i).getText();
			product_price = product_price.replaceAll("[^0-9]", "");
			IntProdPrice[i] = Integer.parseInt(product_price);
			
			//Product Ratings conversion
			product_rating=ratings.get(i).getText();
			product_rating=product_rating.replaceAll("[^0-9.]", "");
			StrRating[i]=product_rating;
			
			//Product ROM conversion
			ROM[i]=rom.get(i).getText();
			
			//Camera Specification
			CAMERA[i]= camera.get(i).getText();
			
			DISPLAY[i]=display.get(i).getText();
			
		
        }
        	 
        // Find index of the maximum price available in array
        int maximum,index=0,j=1; 
		maximum=IntProdPrice[0]; 
		while(j<IntProdPrice.length) 
		{ 
			if(maximum<IntProdPrice[j]) 
			{ 
				maximum=IntProdPrice[j]; 
				index=j; 
			} 
			j++; 
		} 
		
		System.out.println("Maximum Price is: Rs. "+IntProdPrice[index]);
		System.out.println("Name of Product with maximum Price: "+ProdName[index]);
		System.out.println("Rating of product with maximum price "+StrRating[index]+"*");
		System.out.println("ROM of the product: "+ ROM[index]);
		System.out.println("Camera Specification: "+CAMERA[index]);	
		System.out.println("Display Specification: "+DISPLAY[index]);
	}
	public static void main(String[] args) 
	{
		Assignment2 a=new Assignment2();
		
	}

}
