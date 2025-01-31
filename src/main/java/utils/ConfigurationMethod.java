package utils;
	import java.io.IOException;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
	import org.openqa.selenium.safari.SafariDriver;
	import org.openqa.selenium.safari.SafariOptions;
	import org.testng.Assert;

	import com.aventstack.extentreports.MediaEntityBuilder;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.markuputils.ExtentColor;
	import com.aventstack.extentreports.markuputils.MarkupHelper;

	import io.github.bonigarcia.wdm.WebDriverManager;
	import io.github.bonigarcia.wdm.config.DriverManagerType;

	public class ConfigurationMethod extends ReportUtils {

	    public  RemoteWebDriver driver;
		
		public void launchApplication() {

			if (Web_Constants.OS.equalsIgnoreCase("Mac")) {
				switch (Web_Constants.browser.toLowerCase()) {
				case "Firefox":
					driver = new FirefoxDriver();
					break;
				case "chrome":
					WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--disable-notifications");
					driver = new ChromeDriver(options);
					break;
				case "ie":
					WebDriverManager.iedriver().setup();
					
					InternetExplorerOptions capabilities = new InternetExplorerOptions();
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
					capabilities.setCapability("requireWindowFocus", true);
					driver = new InternetExplorerDriver();
					break;
				case "safari":

					try {
						Runtime.getRuntime().exec("killall safaridriver");
					} catch (IOException e1) {

					}
					try {
						DriverManagerType safari = DriverManagerType.SAFARI;
						WebDriverManager.getInstance(safari).setup();
						Class<?> safariClass = Class.forName(safari.browserClass());
						driver = (RemoteWebDriver) safariClass.getDeclaredConstructor().newInstance();
					} catch (Exception a) {
						System.out.println("Error ::: " + a);
					}

					break;
				case "safaritechnologypreview":
					try {
						Runtime.getRuntime().exec("killall safaridriver");
					} catch (IOException e) {
					}
					SafariOptions safariOptions = new SafariOptions();
					safariOptions.setUseTechnologyPreview(true);
					driver = new SafariDriver(safariOptions);
					
					SafariOptions capabilities1=new SafariOptions();
					capabilities1.setCapability("requireWindowFocus", true);
					break;
				default:
					Assert.assertTrue(false, "Given OS : '" + Web_Constants.OS + "'or Given Browser :'"
							+ Web_Constants.browser + "' is invalid");
					break;
				}
			} else if (Web_Constants.OS.equalsIgnoreCase("windows")) {
				switch (Web_Constants.browser.toLowerCase()) {
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				case "chrome":
					WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--disable-notifications");
					options.addArguments("disable-infobars");
					driver = new ChromeDriver(options);
					break;
				case "ie":
					WebDriverManager.iedriver().setup();
					driver = new InternetExplorerDriver();
					break;

				default:
					Assert.assertTrue(false, "Given OS : '" + Web_Constants.OS + "'or Given Browser :'"
							+ Web_Constants.browser + "' is invalid");
					break;
				}

				driver.manage().window().maximize();

			}

			driver.manage().deleteAllCookies();
			driver.get(Web_Constants.URL);
			test.info("Launched Application URL:-" + Web_Constants.URL);

		}

		public void logStatus(String status, String Message) {

			switch (status.toLowerCase()) {
			case "info":
				test.info(Message);
				System.out.println("[" + status.toUpperCase() + "]" + " : " + Message);
				test.info(MarkupHelper.createLabel(Message, ExtentColor.WHITE));
				break;
			case "warning":
//				test.warning(Message);
				System.err.println("[" + status.toUpperCase() + "]" + " : " + Message);
				test.warning(MarkupHelper.createLabel(Message, ExtentColor.PINK));
				break;
			case "error":
//				test.error(Message);
				System.err.println("[" + status.toUpperCase() + "]" + " : " + Message);
				test.warning(MarkupHelper.createLabel(Message, ExtentColor.RED));
				logScreenShot(Status.INFO, Message);
				break;
			case "pass":
//				test.pass(Message);
				System.out.println("[" + status.toUpperCase() + "]" + " : " + Message);
				test.pass(MarkupHelper.createLabel(Message, ExtentColor.GREEN));
				break;
			case "fail":
//				test.fail(Message);
				System.err.println("[" + status.toUpperCase() + "]" + " : " + Message);
				test.fail(MarkupHelper.createLabel(Message, ExtentColor.RED));
				logScreenShot(Status.INFO, Message);
				break;
			case "skip":
				test.skip(Message);
				break;
//			case "debug":
//				test.debug(Message);
//				logScreenShot(Status.INFO, Message);
//				break;
//			default:
//				test.error("Invalid Status");
//				break;
			}
			
			report.flush();

		}

		// To Kill the crome browser
		public void killBrowser() throws IOException {
			if (driver != null) {
				if (Web_Constants.OS.equalsIgnoreCase("windows")) {
					// driver.quit();
					try {
						driver.quit();
					} catch (Exception e) {
					}
				}
				if (Web_Constants.OS.equals("Mac")) {
					try {
						clearCookies();
						driver.manage().deleteAllCookies();
						driver.quit();

					} catch (Exception e) {
						driver.quit();
					}
				}
			}
		}

		public void clearCookies() {
			((JavascriptExecutor) driver)
					.executeScript(" var cookies = document.cookie.split(';');								"
							+ " for (var i = 0; i < cookies.length; i++) {							"
							+ " var cookie = cookies[i];      										"
							+ " var eqPos = cookie.indexOf('=');  									"
							+ " var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;			"
							+ " document.cookie = name + '=;expires=Thu, 01 Jan 1970 00:00:00 GMT';	" + " };");
		}

		public void logScreenShot(Status status, String details) {

			Utilities utilities = new Utilities();
			Web_Constants Constants = new Web_Constants();

			if (Constants.SCREENSHOT_TO_FOLDER) {
				try {
					test.log(status, details, MediaEntityBuilder.createScreenCaptureFromPath(
							utilities.captureScreenshot(driver, Constants.SCREENSHOT_TO_FOLDER)).build());
				} catch (Exception e) {
					e.printStackTrace();
					test.log(Status.INFO, "Unable to take a screenshot");
				}
			} else if (!Constants.SCREENSHOT_TO_FOLDER) {
				try {
					test.log(status, details, MediaEntityBuilder.createScreenCaptureFromBase64String(
							utilities.captureScreenshot(driver, Constants.SCREENSHOT_TO_FOLDER)).build());
				} catch (Exception e) {
					e.printStackTrace();
					test.log(Status.INFO, "Unable to take a screenshot");
				}
			}
		}

		public void logScreenShot() {

			Utilities utilities = new Utilities();
			try {
				test.log(Status.INFO, "", MediaEntityBuilder
						.createScreenCaptureFromBase64String(utilities.captureScreenshot(driver, false)).build());
			} catch (IOException e) {
//				test.error("Unable to take the screenshot");
			}

		}

	}



