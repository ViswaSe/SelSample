package practise;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingLinks extends PreActions{
	
	String url;
	
	@BeforeTest
	public void provideData()
	{
		url="http://www.leafground.com/pages/Link.html";
	}

	@Test
	public void links()
	{
		driver.get(url);
		
		driver.findElementByLinkText("Go to Home Page").click();
		System.out.println("You're in the page:"+driver.getTitle());
		driver.findElementByXPath("//h5[text()='HyperLink']").click();
		
		String nav=driver.findElementByPartialLinkText("Find where").getAttribute("href");
		System.out.println("You will be navigated to: "+nav);
		
		try 
		{
			String urlToValidate=driver.findElementByLinkText("Verify am I broken?").getAttribute("href");
			URL tempUrl=new URL(urlToValidate);
			HttpURLConnection httpConnect=(HttpURLConnection)tempUrl.openConnection();
			httpConnect.setConnectTimeout(3000);
			httpConnect.connect();
			
			if(httpConnect.getResponseCode()==200)
				System.out.println(urlToValidate+" is not a broken one--"+httpConnect.getResponseMessage()+"--"+httpConnect.getResponseCode());
			else
				System.out.println(urlToValidate+" is broken--"+httpConnect.getResponseMessage()+"--"+httpConnect.getResponseCode());
		} 
		
		catch (Exception e) {
			System.out.println("Issue in validating the broken links"+e.getMessage());
		}
		
		driver.findElementByXPath("(//a[contains(text(),'Home Page')])[2]").click();
		System.out.println("You're now in: "+driver.getTitle());
		driver.findElementByXPath("//h5[text()='HyperLink']").click();

		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		System.out.println("Number of links in this page:"+allLinks.size());
		for(WebElement each:allLinks)
		{
			System.out.println(each.getText());
		}
		
	}
	
}
