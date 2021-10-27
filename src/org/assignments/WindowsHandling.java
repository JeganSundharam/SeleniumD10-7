package org.assignments;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowsHandling {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\Star\\eclipse-workspace\\SeleniumD10 7\\driver\\msedgedriver.exe");
		
		WebDriver driver=new EdgeDriver();
		driver.get("http://greenstech.in/selenium-course-content.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//h2[contains(text(),'Core Java Test papers  ')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@title='Test papers training in chennai'])[4]")).click();
		
		String parentWindow = driver.getWindowHandle();
		Set<String> Allwindows = driver.getWindowHandles();
		for (String eachWindow : Allwindows) {
			if (!parentWindow.equals(eachWindow)) {
				
				driver.switchTo().window(eachWindow);
			}
			
		}
		WebElement Element = driver.findElement(By.xpath("//pre[@style]"));
		String allText = Element.getText();
		
		int indexStart = allText.indexOf("1.What");
		int indexEnd = allText.indexOf("2.Whether");
		
		String reqText = allText.substring(indexStart, indexEnd);
		System.out.println(reqText);
		
		
		
		Set<String> Allwindows1 = driver.getWindowHandles();
		
		List<String> li=new ArrayList<>();
		li.addAll(Allwindows);
			li.get(2);
			
			
			System.out.println("completed");
		}
		
		
	}


