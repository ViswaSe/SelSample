package practise;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingButton extends PreActions{
	
	String url,title;
	
	@BeforeTest
	public void provideData()
	{
		url="http://www.leafground.com/pages/Button.html";
	}
	
	@Test()
	public void button()
	{
		
		driver.get(url);
		
		driver.findElementById("home").click();
		driver.findElementByXPath("//h5[text()='Button']").click();
		System.out.println("You're in the page:"+driver.getTitle());
		
		Point point=driver.findElementById("position").getLocation();
		int x=point.getX();int y=point.getY();
		System.out.println("Button located in the position of x & y: "+ x+","+y);
		
		String cssValue = driver.findElementByXPath("//button[text()='What color am I?']").getCssValue("background-color");
		System.out.println(cssValue);
		
		Dimension size=driver.findElementById("size").getSize();
		int height=size.height; int width=size.width;
		System.out.println("Size of the button in height & width:"+height+","+width);
		
		
	}

}
