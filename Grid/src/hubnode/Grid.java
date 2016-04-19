package hubnode;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Grid {
	static WebDriver driver = null;
	static String br = null;
	@Parameters({"browser", "remoteurl"})
	@Test
	public static void openGoogle(String browser, String remoteurl) throws InterruptedException, IOException
	{
		br=browser.toString();
		DesiredCapabilities cap = new DesiredCapabilities();
		switch (browser)
		{
			case "firefox":
			     cap = DesiredCapabilities.firefox();
			     //cap.setBrowserName("firefox");
			     break;
			case "ie":
				File file = new File("c:\\Grid\\IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			     cap = DesiredCapabilities.internetExplorer();	
			     //cap.setBrowserName("internet explorer");
			     break;
			case "chrome":
				 System.setProperty("webdriver.chrome.driver","c:\\Grid\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				options.addArguments("test-type");
		        //driver = new ChromeDriver(options);
			     cap.setCapability(ChromeOptions.CAPABILITY, options);
			     cap = DesiredCapabilities.chrome();
			     //cap.setBrowserName("chrome");
			     break;
			default:
			     cap = DesiredCapabilities.firefox();
			     //cap.setBrowserName("firefox");
			     break;
		}
		cap.setPlatform(Platform.WINDOWS);
		
		//driver = new RemoteWebDriver(new URL("http://10.112.70.32:9500/wd/hub"), cap);
		
		//Node Machine IP address
		//driver = new RemoteWebDriver(new URL("http://10.223.204.105:5552/wd/hub"), cap);
		driver = new RemoteWebDriver(new URL(remoteurl+"/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.navigate().to("http://www.gmail.com");
	}
}






//FileWriter fr=new FileWriter("c:/Grid/data.txt");
		//BufferedWriter br=new BufferedWriter(fr);
		//br.write(br.toString() + " This is sample");
		//br.close();
		//Thread.sleep(4000);
		//driver.close();