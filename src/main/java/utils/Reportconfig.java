package utils;

import java.net.Inet4Address;
	import java.net.InetAddress;
	import java.net.UnknownHostException;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import org.testng.ITestContext;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.Optional;
	import org.testng.annotations.Parameters;

	 
	import io.cucumber.testng.AbstractTestNGCucumberTests;

	public class Reportconfig extends AbstractTestNGCucumberTests {

		public ReportUtils reportUtils;

		public InetAddress systemAddress;
		
		@BeforeSuite
		@Parameters({"OS","Browser"})
		public void beforeSuite(@Optional ITestContext ctx,@Optional String OS, @Optional String Browser) {
			
			Web_Constants constants = new Web_Constants();
			OS = System.getProperty("OS");
		
			if (OS == null || OS.equalsIgnoreCase("Windows_NT")) {
				System.out.println("Jenkins OS Value:-" + OS);
				OS = Web_Constants.OS;
			}else {
				System.out.println("Constants OS Value:-" + OS);
			}
			
			Browser = System.getProperty("Browser");
			
			if (Browser == null || !Browser.equalsIgnoreCase("Windows_NT")) {
				System.out.println("Jenkins Browser Value:-" + Browser);
				Browser = Web_Constants.browser;
			}else {
				System.out.println("Constants Browser Value:-" + Browser);
			}
			 
			constants.Web_ConstantsConfiguration(OS, Browser);
			
			reportUtils = new ReportUtils();
			
			Utilities utilities = new Utilities();
			
			String suiteName = ctx.getCurrentXmlTest().getSuite().getName()+ "_" + Web_Constants.browser;
			
			reportUtils.initializeReport(suiteName);
			
			try {
				systemAddress = Inet4Address.getLocalHost();
			} catch (UnknownHostException e) {

			}
			
			String IP_adress = systemAddress.getHostAddress().replace(".", "_");
			if (Web_Constants.OS.equalsIgnoreCase("Windows")) {
				utilities.createFolder(Web_Constants.REPORT_PATH);
				ReportUtils.screenShotFolderPath=Web_Constants.SCREENSHOT_PATH;
				ReportUtils.screenShotFilePath= Web_Constants.SCREENSHOT_PATH + IP_adress + "\\" + getDateStamp() + "\\";
			}
			else if (Web_Constants.OS.equalsIgnoreCase("Mac")) {
				utilities.createFolder(Web_Constants.REPORT_PATH_MAC);
				reportUtils.screenShotFolderPath = Web_Constants.SCREENSHOT_PATH_MAC;
				reportUtils.screenShotFolderPath = Web_Constants.SCREENSHOT_PATH_MAC + IP_adress + "/" + getDateStamp() + "/";
			}
		}
		
		@AfterSuite
		public void afterSetUp() {
			ReportUtils.report.flush();
		}

		public String getDateStamp() {
			DateFormat dfor = new SimpleDateFormat("ddMMyyyy");
			Date obj = new Date();
			String date = dfor.format(obj);
			return date;
		}

		public String hourStamp() {
			Date d = new Date();
			String hour = String.valueOf(d.getHours());
			return hour;
		}

		// To get current time
		public static String getTimeStamp() {
			Date d = new Date();
			return d.toString().replace(":", "_").replace(" ", "_");
		}

	}

	


