package practise;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingEdit extends PreActions{
	
	String url;
	
	@BeforeTest
	public void provideData()
	{
		url="http://www.leafground.com/pages/Edit.html";
		fileName="HandlingEdit";
	}
	
	@Test(dataProvider="fetchData")
	public void edit(String email,String value)
	{
		driver.get(url);
		getScreenshot();
		
		driver.findElementById("email").sendKeys(email);
		getScreenshot();
		
		driver.findElementByXPath("//input[@value='Append ']").sendKeys(value);
		getScreenshot();
		
		System.out.println("Value present in the text box: "+ driver.findElementByName("username").getAttribute("value"));
		getScreenshot();
		
		driver.findElementByXPath("(//input[@name='username'])[2]").clear();
		getScreenshot();
		
		WebElement ele=driver.findElementByXPath("//label[@for='disabled']/following::input[1]");
		boolean result=ele.isEnabled();
		
		System.out.println("Field enabled="+result);
		
	}

}
