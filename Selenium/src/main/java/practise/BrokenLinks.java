package practise;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		String url="https://www.google.co.in";
		driver.get(url);
		
		List<WebElement> ele=driver.findElements(By.tagName("a"));
		for(int i=0;i<ele.size();i++)
		{
			WebElement eachEle=ele.get(i);
			String eachUrl=eachEle.getAttribute("href");
			verifyActive(eachUrl);
		}
		
	}
	
	
	public static void verifyActive(String url)
	{
		try 
		{
			URL urlToValidate=new URL(url);
			HttpURLConnection httpConnect=(HttpURLConnection)urlToValidate.openConnection();
			httpConnect.setConnectTimeout(3000);
			httpConnect.connect();
			
			if(httpConnect.getResponseCode()==200)
				System.out.println(url+" response code:"+httpConnect.getResponseMessage());
			if(httpConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
				System.out.println(url+" response code:"+httpConnect.getResponseMessage());
			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
