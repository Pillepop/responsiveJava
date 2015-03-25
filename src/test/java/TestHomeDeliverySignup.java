package test.java;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.apache.commons.io.FileUtils;
import org.apache.xml.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
//import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.channels.ReadableByteChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.util.concurrent.TimeUnit;

//import com.sun.xml.internal.messaging.saaj.util.Base64;

public class TestHomeDeliverySignup{
	
	private static final char[] DeviceOs = null;
	public  String SELENIUM_HUB_URL;
	public  String TARGET_SERVER_URL;
	public static  String PM_CLOUD;
	public static  String PM_USER;
	public static  String PM_PASSWORD;
	public boolean device=false;
	public String deviceOS="";
	ScreenShotRemoteWebDriver driver = null;
	
	private static String getConfigurationProperty(String envKey,
			String sysKey, String defValue) {
		String retValue = defValue;
		String envValue = System.getenv(envKey);
		String sysValue = System.getProperty(sysKey);
		// system property prevails over environment variable
		if (sysValue != null) {
			retValue = sysValue;
		} else if (envValue != null) {
			retValue = envValue;
		}
		return retValue;
	}

	public void signUp(DesiredCapabilities browser)
			throws MalformedURLException, IOException, InterruptedException {
		try {
			driver = new ScreenShotRemoteWebDriver (new URL(SELENIUM_HUB_URL), browser);
			//driver = new RemoteWebDriver(new URL(SELENIUM_HUB_URL), browser);

			//  test starts in Codes entity list page
			driver.get(TARGET_SERVER_URL);
			
			System.out.println(System.getProperty("user.dir"));

//			DesiredCapabilities reportCap;
//			reportCap = (DesiredCapabilities) driver;
//			String reportkey = (String) browser.getCapability("reportKey");
//			String executionId = (String) browser.getCapability("executionId");
//			String deviceID = (String) browser.getCapability("deviceName");
//			System.out.println(deviceID);
//			System.out.println(reportkey);
//			System.out.println(executionId);

			System.out.println(SELENIUM_HUB_URL + " " + browser.getPlatform());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);


			driver.findElement(By.xpath("//input[@name='txtZip']")).sendKeys("02116");
			//driver.findElement(By.xpath("//*[contains(@id,'ubmit')]")).click();
			driver.findElement(By.xpath("//*[@class='modal-submit' or @name='cmdSubmit']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//label[@for='rdSubscription1']")).click();
			driver.findElement(By.xpath("//div[@id='continue_btn']")).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			driver.findElement(By.xpath("//input[@id='txtDeliveryFirstName']")).sendKeys("Patrick");
			driver.findElement(By.xpath("//input[@id='txtDeliveryLastName']")).sendKeys("McCartney");
			driver.findElement(By.xpath("//input[@id='txtDeliveryAddress1']")).sendKeys("28 Main St");
			driver.findElement(By.xpath("//input[@id='txtDeliveryAddress2']")).sendKeys("Apt. 2");
			driver.findElement(By.xpath("//input[@id='txtDeliveryAreaCode']")).sendKeys("781");
			driver.findElement(By.xpath("//input[@id='txtDeliveryPhone3']")).sendKeys("847");
			driver.findElement(By.xpath("//input[@id='txtDeliveryPhone4']")).sendKeys("4433");		
			driver.findElement(By.xpath("//input[@id='txtDeliveryEMail']")).sendKeys("patrickm@perfectomobile.com");
			
			
		} finally {
			if (driver != null) {
				driver.close();
				driver.quit();
				
			}
		}

	}

	public void searchInsurance(DesiredCapabilities browser)
			throws MalformedURLException, IOException, InterruptedException {
		
		String reportkey=null;
		String executionID=null;
		try {
			//driver = new RemoteWebDriver(new URL(SELENIUM_HUB_URL), browser);
			driver = new ScreenShotRemoteWebDriver (new URL(SELENIUM_HUB_URL), browser);
			
			DesiredCapabilities capabilities = (DesiredCapabilities) ((RemoteWebDriver) driver).getCapabilities();
			reportkey = (String) capabilities.getCapability("reportKey");
			executionID = (String) capabilities.getCapability("executionId");
			
			System.out.println("Reportkey: "+reportkey+" ExecutionID:"+executionID);
			//  test starts in Codes entity list page
			driver.get(TARGET_SERVER_URL);
			
			System.out.println(System.getProperty("user.dir"));
			
			System.out.println(SELENIUM_HUB_URL + " " + browser.getPlatform());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//
//			String command = "mobile:checkpoint:text";
//			Map<String, Object> Params = new HashMap<String,Object>();
//			Params.put("content","Continue");
//			Params.put("scrolling","scroll");
//			Params.put("next", "SWIPE_UP");
//			String isFound = (String)((RemoteWebDriver) driver).executeScript(command, Params);
//			
			
			driver.findElement(By.xpath("//label[@id='policytype_100label']")).click();
			driver.findElement(By.xpath("//label[text()='Spain']")).click();
			driver.findElement(By.xpath("//label[@id='startDate_Today_Label']")).click();
			driver.findElement(By.xpath("//span[text()='7']")).click();
						
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
					
		} finally {
			if (driver != null) {
				driver.close();
				downloadReport(reportkey);
				driver.quit();
				
			}
		}

	}

	public void Zalando(DesiredCapabilities browser, String targetEnvironment)
			throws MalformedURLException, IOException, InterruptedException {
		
		TARGET_SERVER_URL = getConfigurationProperty("TARGET_SERVER_URL",
				"test.target.server.url", "http://www.zalando.de");
		
		String reportkey=null;
		String executionID=null;
		try {
			//driver = new RemoteWebDriver(new URL(SELENIUM_HUB_URL), browser);
			driver = new ScreenShotRemoteWebDriver (new URL(SELENIUM_HUB_URL), browser);
			
			DesiredCapabilities capabilities = (DesiredCapabilities) ((RemoteWebDriver) driver).getCapabilities();
			reportkey = (String) capabilities.getCapability("reportKey");
			executionID = (String) capabilities.getCapability("executionId");
			deviceOS = (String)capabilities.getCapability("platformName");
			
			System.out.println("Reportkey: "+reportkey+" ExecutionID:"+executionID);
			//  test starts in Codes entity list page
			driver.get(TARGET_SERVER_URL);
			
			System.out.println(System.getProperty("user.dir"));			
			System.out.println(SELENIUM_HUB_URL + " " + browser.getPlatform());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			 
			if (device)
				driver.findElement(By.xpath("(//button[@id=\"buttonMenu\"])[1]")).click();
				
				driver.findElement(By.xpath("//*[@aria-controls='#navPanel0' or @name='header.navi.tab.damen']")).click();
				driver.findElement(By.xpath("//a[@name='header.navi.main.damen.schuhe']")).click();
				driver.findElement(By.xpath("(//a[@name='header.navi.sub.damen.schuhe.damenschuhe-sneaker' or @name='left.navi.category.1:schuhe.2:sneaker'])[1]")).click();
			  	
			if (device){
			  		Thread.sleep(2000);
			  		driver.findElement(By.xpath("//SPAN[contains(text(),'Filtern / Sortieren')]")).click();
			  		Thread.sleep(1000);
			  		visualClick("Preis ab", false,"");
			  		Thread.sleep(1000);
			  		visualClick("20.00", true,"SwipeWheel");
			  		System.out.println("DeviceOS is "+DeviceOs);
			  		if (deviceOS.equals("iOS")) {
			  			Thread.sleep(2000);
			  			System.out.println("Done button");
			  			visualClick("Done",false,"");
			  		}
			  		Thread.sleep(2000);
			  		visualClick("Preis bis", false,"");			  		
			  		visualClick("1380.00",true,"SwipeWheel");
			  		
			  		
			  		if (deviceOS.equals("iOS")) visualClick("Done",false,"");
			  		driver.findElement(By.xpath("//BUTTON[contains(text(),'Ergebnisse anzeigen')]")).click();	  		  	
			}	    
		  	else
		  	{		
		  			GetBrowserScreenshot("Pre-Filter"+targetEnvironment+".png");	  		
			  		driver.findElement(By.xpath("//span[text()='Preis']")).click();
			  		Thread.sleep(500);
			  		GetBrowserScreenshot("Filter"+targetEnvironment+".png");
			  		driver.findElement(By.xpath("//input[@name='price_from']")).sendKeys("25");
			  		Thread.sleep(500);
			  		GetBrowserScreenshot("PriceFrom"+targetEnvironment+".png");
			  		driver.findElement(By.xpath("//input[@name='price_to']")).sendKeys("10000");
			  		Thread.sleep(500);
			  		GetBrowserScreenshot("PriceTo"+targetEnvironment+".png");
			  		driver.findElement(By.xpath("//input[contains(@value,'bernehmen')]")).click();
			  	}
			  	//Evaluate all responses
		       
			       
			List<WebElement> objList  = driver.findElements(By.xpath("//span[contains(@class,'price')]"));
		  	
		  	for (int i = 0 ; i<5  ; i++)//<objList.size()
			{
				WebElement item = objList.get(i);
				System.out.println(targetEnvironment +": "+i+" :" + item.getText());
				//if (item.getText().equals("Flight Status"))
				//{
				//	item.click();
				//	i = objList.size();
				//}

			}
		  	GetBrowserScreenshot("screenshot"+targetEnvironment+".png");			
			Thread.sleep(2000);
			
			
		}catch	(Exception e) {
			// TODO Auto-generated catch block
			GetBrowserScreenshot("Error"+targetEnvironment+".png");
			e.printStackTrace();
				
		} finally {
			if (driver != null) {
				driver.close();
				downloadReport(reportkey);
				driver.quit();
				
			}
		}

	}
	
	private void GetBrowserScreenshot(String fileName) {
		// TODO Auto-generated method stub
		File f = driver.getScreenshotAs(OutputType.FILE);
	       File o = new File("test-output/screenshots/"+fileName);
	       try {
			FileUtils.copyFile(f, o);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean visualCheckpoint(String label, boolean swipe){
//		String command = "mobile:checkpoint:text";
//		Map<String, Object> Params = new HashMap<String,Object>();
//		Params.put("content","Continue");
//		Params.put("scrolling","scroll");
//		Params.put("next", "SWIPE_UP");
//		String isFound = (String)((RemoteWebDriver) driver).executeScript(command, Params);
		return true;	
	}
	
	private boolean clickElementScroll(String text, String Swipe){
	
		if (Swipe=="") 
			Swipe="SWIPE=(50%,90%),(50%,70%)";
		
		if (device){
			if (deviceOS=="Android") 
			Swipe = "SWIPE_UP";
			
			visualClick(text,false,Swipe);
		}				
		return true;	
	}
	
	private boolean clickElement(String xpath, String text){
		
		if(device)
			visualClick(text,false,"");
		else
			driver.findElement(By.xpath(xpath)).click();
		
		return true;	
	}
	
/*	private boolean visualClick(String label, boolean swipe){
		if(device)
		{
		String command2 = "mobile:button-text:click";
		Map<String, Object> Params2 = new HashMap<String,Object>();
		Params2.put("label",label);
		Params2.put("analysis", "automatic");
		if(swipe)
		{
			Params2.put("scrolling","scroll");
			Params2.put("next", "SWIPE_UP");
		}
		String isFound = (String)((RemoteWebDriver) driver).executeScript(command2, Params2);
		}
		return true;
	}*/
	
	private String visualClick(String label, boolean swipe,String SwipeAction){
		//"SWIPE=(50%,90%),(50%,70%)"
		String isFound="";
		System.out.println(deviceOS+" "+label);
		
		if(device)
		{		
				String command = "mobile:button-text:click";
				Map<String, Object> Params = new HashMap<String,Object>();
				Params.put("label",label);
				Params.put("analysis", "automatic");
				Params.put("threshold", "90");
				if(swipe)
				{
					if (SwipeAction=="SwipeWheel"){
						if (deviceOS=="iOS") 
							SwipeAction= "SWIPE=(50%,90%),(50%,80%)";				
						else SwipeAction = "SWIPE_UP";
					}
					Params.put("scrolling","scroll");
					Params.put("next", SwipeAction );			
				}
				isFound = (String)((RemoteWebDriver) driver).executeScript(command, Params);
		}
		return isFound;
	}
	
	private static void downloadReport(String reportId)
	{
		if (reportId != null)
		{
		URL Repurl;
		try {
			Repurl = new URL("https://"+ PM_CLOUD +"/services/reports/"+reportId+"?operation=download&user="+PM_USER+"&password="+PM_PASSWORD+"&format=html");
			ReadableByteChannel rbc = Channels.newChannel(Repurl.openStream());
			reportId=reportId.substring(30,53);
			FileOutputStream fos = new FileOutputStream("C:\\Results\\PMReport_"+ reportId+ ".html");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
 			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	@DataProvider(parallel = true)
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "Android", "Patrick", "Chrome" },
	      new Object[] { "iOS", "Patrick", "Safari" },
	    };
	  }
		
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeMethod
	public void setUp() throws Exception {
	}

	@AfterMethod
	public void tearDown() throws Exception {
	}

	@Parameters({ "targetEnvironment" })
	@Test
	public void test(String targetEnvironment) throws MalformedURLException,
	IOException, InterruptedException {

		device = false;
		DesiredCapabilities capabilities = new DesiredCapabilities();


		switch (targetEnvironment) {
		case "Galaxy S5":
			device = true;
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("description", "Philipp_workshop");
			capabilities.setCapability("browserName", "mobileChrome");
			break;
		
		case "Galaxy S5_":
			device = true;
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("description", "Philipp");
			capabilities.setCapability("browserName", "mobileChrome");
			break;
		
		case "Galaxy S4":
			device = true;
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("description", "Philipp_Temp_S4");
			capabilities.setCapability("browserName", "Chrome");
			break;
			
		case "iPhone 6":
			device = true;
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("description", "Philipp");
			capabilities.setCapability("browserName", "mobileSafari");
			break;

		case "Internet Explorer 11":
			device = false;
			DesiredCapabilities.internetExplorer();
			capabilities.setCapability("platform", Platform.ANY);
			capabilities.setCapability("browserName", "internet explorer");
			capabilities.setCapability("version", "11");
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			break;

		case "Internet Explorer 10":
			device = false;
			capabilities.setCapability("platform", Platform.ANY);
			capabilities.setCapability("browserName", "internet explorer");
			capabilities.setCapability("version", "10");
			capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
			break;	

		case "Firefox 34":
			device = false;
			capabilities.setCapability("platform", Platform.ANY);
			capabilities.setCapability("browserName", "firefox");
			capabilities.setCapability("version", "34.0");
			capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
			break;

		case "Firefox 35":
			device = false;
			capabilities.setCapability("platform", Platform.ANY);
			capabilities.setCapability("browserName", "firefox");
			capabilities.setCapability("version", "35.0");
			capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
			break;

		case "Chrome":
			device = false;
			capabilities.setCapability("platform", Platform.ANY);
			capabilities.setCapability("browserName", "chrome");
			capabilities.setCapability("version", "");
			capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
			break;
		}

		//TARGET_SERVER_URL = getConfigurationProperty("TARGET_SERVER_URL",
		//		"test.target.server.url", "http://homedelivery.bostonglobe.com/");
		TARGET_SERVER_URL = getConfigurationProperty("TARGET_SERVER_URL",
				"test.target.server.url", "https://www.moneysupermarket.com/travel-insurance/enquiry/");

		if (device) {

			System.out.println(targetEnvironment + ": device");
			PM_CLOUD = "demo.perfectomobile.com";
			PM_USER = URLEncoder.encode("philipps@perfectomobile.com",
					"UTF-8");
			PM_PASSWORD = URLEncoder.encode("Perfect0123", "UTF-8");
			URL gridURL = new URL("https://" + PM_USER + ':' + PM_PASSWORD + '@'
					+ PM_CLOUD + "/nexperience/wd/hub");

			SELENIUM_HUB_URL = getConfigurationProperty("SELENIUM_HUB_URL",
					"test.selenium.hub.url", gridURL.toString());

		} else {
			System.out.println(targetEnvironment + ": desktop");;
			SELENIUM_HUB_URL = getConfigurationProperty("SELENIUM_HUB_URL",
					"test.selenium.hub.url",
					"http://seleniumgrid.perfectomobilelab.net:4444/wd/hub"); 
			
		}

		//signUp(capabilities);
		//searchInsurance(capabilities);
		Zalando(capabilities, targetEnvironment);

	}
	

	private static void downloadReport(RemoteWebDriver driver, String type, String fileName, String suffix, String deviceID)
    { 
//    	try {
//    		
//			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd-HHmmss");
//			Calendar cal = Calendar.getInstance();
//			String reportTime = dateFormat.format(cal.getTime());
//    		
//            String command = "mobile:report:download"; 
//            Map<String, Object> Parms = new HashMap<String, Object>();
//            Parms.put("type", type); 
//            String report = (String) driver.executeScript(command, Parms);
//            String reportBytes = Base64.base64Decode(report);
//            File reportFile = new File(fileName + "-" + deviceID + "-" +reportTime + suffix);
//            FileUtils.write(reportFile, reportBytes, "UTF-8");
//    		}
//    		catch (Exception repEx) {
//    			repEx.printStackTrace();
//    		}
    }
	
	private void switchToContext(RemoteWebDriver driver, String context) {
		RemoteExecuteMethod executeMethod = new RemoteExecuteMethod(driver);
		Map<String,String> params = new HashMap<String,String>();
		params.put("name", context);
		executeMethod.execute(DriverCommand.SWITCH_TO_CONTEXT, params);
	}
	
	public class ScreenShotRemoteWebDriver extends RemoteWebDriver implements TakesScreenshot {
		public ScreenShotRemoteWebDriver(URL url, DesiredCapabilities dc) {
			super(url, dc);
		}

		@Override
		public <X> X getScreenshotAs(OutputType<X> target)
				throws WebDriverException {
			if ((Boolean) getCapabilities().getCapability(CapabilityType.TAKES_SCREENSHOT)) {
			    return target.convertFromBase64Png(execute(DriverCommand.SCREENSHOT).getValue().toString());
			}
			return null;
		}
	}
}
