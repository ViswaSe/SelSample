package practise;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public class PreActions {
	
	public static ChromeDriver driver;
	public String fileName;
	static double snapNumber;
	
	@BeforeSuite
	public void doBeforeSuite()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void doAfterSuite()
	{
		driver.close();
	}
	
	@DataProvider(name="fetchData")
	public Object[][] getData()
	{
		ReadExcel obj=new ReadExcel();
		return obj.readExcel(fileName);
	}
	
	public static void getScreenshot()
	{
		snapNumber = ((long) 1000000L + Math.random());
		
		try 
		{
			File src=driver.getScreenshotAs(OutputType.FILE);
			File desc=new File("./snaps/"+snapNumber+".jpg");
			FileUtils.copyFile(src, desc);
		} 
		catch (Exception e) {
			System.out.println("Issue while capturing the screenshot");
		} 
		
	}

}
