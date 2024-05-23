package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	static public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups={"sanity","regression","master"})
	//@Parameters({"os","browser"})
	//public void setup(String os, String br) throws IOException
	public void setup() throws IOException
	{
		//Loading Properties file
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		
		//Loading log4j2 file
		logger = LogManager.getLogger(this.getClass());
		
//		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
//		{
//			DesiredCapabilities capabilities = new DesiredCapabilities();
//			
//			//operating system
//			if(os.equalsIgnoreCase("windows"))
//			{
//				capabilities.setPlatform(Platform.WINDOWS);
//			}
//			else if(os.equalsIgnoreCase("mac"))
//			{
//				capabilities.setPlatform(Platform.MAC);
//			}
//			else
//			{
//				System.out.println("No matching os..");
//				return;
//			}
//			
			//browser
//			switch(br)
//			{
//			case "chrome" : capabilities.setBrowserName("chrome"); break;
//			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
//			default: System.out.println("No matching browser...."); return;
//			}
			driver = new ChromeDriver();
			driver.get(p.getProperty("appURL"));

			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		}
		
//		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
//		{
//		
//		driver.get(p.getProperty("appURL"));
//		
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	}
//	}	
	
		@AfterClass(groups={"sanity","regression","master"})
		public void teardown()
		{
			driver.quit();
		}

		public String randomeString()
		{
			String generatedString = RandomStringUtils.randomAlphabetic(5);
			return generatedString;
		}
	
		public String randomeNumber()
		{
			String generatedString = RandomStringUtils.randomNumeric(10);
			return generatedString;
		}
	
		public String randomeAlphaNumeric()
		{
			String str = RandomStringUtils.randomAlphabetic(4);
			String num = RandomStringUtils.randomNumeric(4);
		
			return (str+"@"+num);
		}
		
		public String captureScreen(String tname) throws IOException {

			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
					
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			
			sourceFile.renameTo(targetFile);
				
			return targetFilePath;
			
		}
		

}
