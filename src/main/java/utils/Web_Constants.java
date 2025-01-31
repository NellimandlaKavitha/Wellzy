package utils;
import java.net.InetAddress;

	import org.testng.Assert;
	import org.testng.annotations.Optional;

	public class Web_Constants {

//		public static String URL = " https://mysql-uat.cwmaint.net/";
		public static String URL = " https://uat.cwmaint.com/login";

		/* WEB Configured Browsers and Platforms */
		public static String PROJECT = "WEB", OS = "Windows", PLATFORM_NAME = "Desktop", browser = "chrome";
//		 public static String PROJECT= "WEB", OS = "Windows", PLATFORM_NAME =
		// "Desktop", browser = "firefox";
		// public static String PROJECT= "WEB", OS = "Mac", PLATFORM_NAME = "Desktop",
		// browser = "Chrome";
		// public static String PROJECT= "WEB", OS = "Mac", PLATFORM_NAME = "Desktop",
		// browser = "Safari";
		// public static String PROJECT= "WEB", OS = "Mac", PLATFORM_NAME = "Desktop",
		// browser = "safaritechnologypreview";

		/* PWA Configured Browsers and Platforms */
		// public static String PROJECT= "PWA", OS = "Windows", PLATFORM_NAME =
		// "Android", browser = "Chrome";
		// public static String PROJECT= "PWA", OS = "Mac", PLATFORM_NAME = "iOS",
		// browser = "Safari";

		/* ScreenShot and Report Paths */
		public final static String REPORT_PATH = "C:\\Users\\iFocus\\Automation Reports\\";
		public final static String SCREENSHOT_PATH = "C:\\Users\\iFocus\\Automation Screenshot";
		public final static String REPORT_PATH_MAC = "";
		public final static String SCREENSHOT_PATH_MAC = "";

		public static final String HUB_URL = "http://127.0.0.1:4723/wd/hub";
		public static final String APPIUM_IPADDRESS = "127.0.0.1";
		public static final int PORT_NUMBER = 4724;
		public static final int APPIUM_PORT = 4723;
		public static final String Mac_UserName = "ifocus";

		public static final boolean SCREENSHOT_TO_FOLDER = false;
		// public static final boolean SCREENSHOT_TO_FOLDER = false;
		
		
		public static final boolean KLOV_FLAG = true;

		public static String ExtentReportPath = "";

		/*
		 * Note: You need to Download the latest version of ChromeDriver.exe and add to
		 * C:\Users\IFOCUS\AppData\Roaming\npm\node_modules\appium\node_modules\appium-
		 * chromedriver\chromedriver\win
		 */

		/*************************************************************************************
		 * 7.0 Select the proper Node.exe path according to the system that you are
		 * working on
		 **************************************************************************************/
		// Windows
		public static String NODEJS_PATH = "C:\\Program Files\\nodejs\\node.exe";
		// MAC
		// public static String NODEJS_PATH = "/usr/local/bin/node";
		/*************************************************************************************
		 * 8.0 Select the proper Appium.JS paths based on the system that you are
		 * working on.
		 **************************************************************************************/

		// APPIUM_JS_PATH
		public static String APPIUM_JS_PATH = "C:\\Users\\" + System.getProperty("user.name")
				+ "\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";

		/*************************************************************************************
		 * 9.0 Select the proper UDID based on the Device that you are working on.
		 **************************************************************************************/

		// OS 11
		public static String UDID = "RZ8R81FMMWK";
		public static String DEVICE_NAME = "m21";
		public static String DEVICE_VERSION = "11";

		// iOS 12.X
		// public static String UDID = "d2cac7e512d8c16c1b4ad94ad6120b2ca1a6deff";
		// public static String DEVICE_NAME = "iPhone 6"; public static String
		// DEVICE_VERSION = "12.4.7"; //Sudha

		// iOS 14.X

		// public static String UDID = "00008030-000A110126E0402E"; public static String
		// DEVICE_NAME = "iPhone 11"; public static String DEVICE_VERSION = "14.0.1";
		// //Office
		// public static String UDID = "00008030-000C6D4A0ED0402E"; public static String
		// DEVICE_NAME = "iPhone SE"; public static String DEVICE_VERSION = "14.0.1";
		// //Office

		public static InetAddress localhost;
		public static String ipAdress = "";
		public static String charleslogsName = "";
		public static String charlesName = "";
		public static String filePathxml = "";
		public static String filePathlogs = "";
		public static String charlesNameDFP = "";
		public static String filePathxmlDFP = "";
		public static String filePathlogsDFP = "";
		public static String charleslogsNameDFP = "";

		public void Web_ConstantsConfiguration(String OS, String browser) {

			if (OS != null) {
				this.OS = OS;
			}
			if (browser != null) {
				this.browser = browser;
			}

			if (OS.equalsIgnoreCase("windows")) {
				if (PROJECT.equalsIgnoreCase("web") || PROJECT.equalsIgnoreCase("mobilerw")) {
					Web_Constants.OS = "Windows";
					switch (browser.toLowerCase()) {
					case "chrome":
						Web_Constants.browser = "Chrome";
						break;
					case "firefox":
						Web_Constants.browser = "Firefox";
						break;
					case "edge":
						Web_Constants.browser = "edge";
						break;
					case "ie":
						Web_Constants.browser = "ie";
						break;
					default:
						Assert.assertTrue(false, "Selected Browser not Applicable:-" + browser);
						break;
					}
				}

			} else if (OS.equalsIgnoreCase("mac")) {
				Web_Constants.OS = "Mac";
				switch (browser.toLowerCase()) {
				case "chrome":
					Web_Constants.browser = "Chrome";
					break;
				case "safari":
					Web_Constants.browser = "Safari";
					break;
				default:
					Assert.assertTrue(false, "Selected Browser not Applicable:-" + browser);
					break;
				}

			} else {
				System.out.println("Selected OS not Applicable:-" + OS);
				Assert.assertTrue(false, "Selected OS not Applicable:-" + OS);
			}

			System.out.println("[INFO] OS - " + OS);

			System.out.println("[INFO] Browser - " + browser);

			System.out.println("[INFO] URL - " + URL);

		}

		public static boolean equalsIgnoreCase(String string) {
			
			return false;
		}

	}



