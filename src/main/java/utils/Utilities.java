package utils;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Utilities {
 
	public AppiumDriverLocalService service;
	public AppiumServiceBuilder builder;
	public DesiredCapabilities cap;
	public String service_url;
	 

	public String getCredentialsFromPropertyFile(String key) {

		String fileName = System.getProperty("user.dir") + "\\PropertyFiles\\Credentials.properties";

		String value = "";

		FileInputStream fis;
		try {
			fis = new FileInputStream(fileName);
			Properties prop = new Properties();
			prop.load(fis);

			switch (key) {
			case "GlobalAdminUserName": {
				value = prop.getProperty("GlobalAdminUserName");
				break;
			}
			case "PartnerAdminUserName": {
				value = prop.getProperty("PartnerAdminUserName");
				break;
			}
			case "CompanyAdminUserName": {
				value = prop.getProperty("CompanyAdminUserName");
				break;
			}

			case "GlobalAdminPassword": {
				value = prop.getProperty("GlobalAdminPassword");
				break;
			}

			case "PartnerAdminPassword": {
				value = prop.getProperty("PartnerAdminPassword");
				break;
			}
			case "CompanyAdminPassword": {
				value = prop.getProperty("CompanyAdminPassword");
				break;
			}
			case "GlobalManagerUserName": {
				value = prop.getProperty("GlobalManagerUserName");
				break;
			}
			case "PartnerManagerUserName": {
				value = prop.getProperty("PartnerManagerUserName");
				break;
			}
			case "CompanyManagerUserName": {
				value = prop.getProperty("CompanyManagerUserName");
				break;
			}

			case "GlobalManagerPassword": {
				value = prop.getProperty("GlobalManagerPassword");
				break;
			}

			case "PartnerManagerPassword": {
				value = prop.getProperty("PartnerManagerPassword");
				break;
			}
			case "CompanyManagerPassword": {
				value = prop.getProperty("CompanyManagerPassword");
				break;
			}
			case "PartnerViewerUserName": {
				value = prop.getProperty("PartnerViewerUserName");
				break;
			}
			case "PartnerViewerPassword": {
				value = prop.getProperty("PartnerViewerPassword");
				break;
			}
			case "CompanyViewerUserName": {
				value = prop.getProperty("CompanyViewerUserName");
				break;
			}
			case "CompanyViewerPassword": {
				value = prop.getProperty("CompanyViewerPassword");
				break;
			}
			case "GlobalViewerUserName": {
				value = prop.getProperty("GlobalViewerUserName");
				break;
			}
			case "GlobalViewerPassword": {
				value = prop.getProperty("GlobalViewerPassword");
				break;
			}
			default:
				break;
			}

		} catch (IOException e) {

		}
		return value;
	}

	// To take the screen shot
	public String captureScreenshot(WebDriver driver, boolean screenshotToFile) throws IOException {
	    String screenShotFilePath = "";
	    String screenShotName = "";
	    String returnString = "";

	    try {
	        if (!screenshotToFile) {
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            String image = ts.getScreenshotAs(OutputType.BASE64);
	            String image2 = createResizedCopy(image, 800, 600, true);
	            return image2;
	        } else if (screenshotToFile) {
	            if (Web_Constants.equalsIgnoreCase("Windows")) {
	                screenShotFilePath = ReportUtils.screenShotFilePath + ReportUtils.className + "_"
	                        + ReportUtils.hour + "\\";
	            } else if (Web_Constants.OS.equalsIgnoreCase("Mac")) {
	                screenShotFilePath = ReportUtils.screenShotFilePath + ReportUtils.className + "_"
	                        + ReportUtils.hour + "/";
	            }

	            createFolder(screenShotFilePath);
	            screenShotName = ReportUtils.methodName + "_" + getTimeStampWithsec() + ".png";
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File ScreenShot = ts.getScreenshotAs(OutputType.FILE);
	            String destpath = screenShotFilePath + screenShotName;

	            File destPath = new File(destpath);

	            FileUtils.moveFile(ScreenShot, destPath);

	            returnString = destpath;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return returnString;
	}
	public String getDataFromPropertyFile(String propertyFile, String key) {

		String fileName = "";

		fileName = System.getProperty("user.dir") + "\\PropertyFiles\\" + propertyFile + ".properties";

		String value = "";

		FileInputStream fis;
		try {
			fis = new FileInputStream(fileName);
			Properties prop = new Properties();
			prop.load(fis);
			value = (String) prop.get(key);
		} catch (IOException e) {

		}
		return value;
	}

	// To convert compress the base64 screenshot
	public String createResizedCopy(String base64String, int scaledWidth, int scaledHeight, boolean preserveAlpha) {
		try {

			byte[] decodedBytes = Base64.getDecoder().decode(base64String);
			BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(decodedBytes));
			int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
			BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
			Graphics2D g = scaledBI.createGraphics();
			if (preserveAlpha) {
				g.setComposite(AlphaComposite.Src);
			}
			g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(scaledBI, "gif", bos);
			String imageString = Base64.getEncoder().encodeToString(bos.toByteArray());

			g.dispose();
			return imageString;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String generateRandomname() {
		String strRandomname = "";
		String strNumbers = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		for (int i = 0; i < 6; i++) {
			strRandomNumber.append(strNumbers.charAt(rnd.nextInt(strNumbers.length())));
		}
		strRandomname = strRandomNumber.toString();
		return strRandomname;
	}

	public String generateRandomId() {
		String strRandomname = "";
		String strNumbers = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		for (int i = 0; i < 3; i++) {
			strRandomNumber.append(strNumbers.charAt(rnd.nextInt(strNumbers.length())));
		}
		strRandomname = strRandomNumber.toString() + "#003";
		return strRandomname;
	}

	public String generateRandomEmailId() {
		String emailAddress = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		while (emailAddress.length() < 5) {
			int character = (int) (Math.random() * 24);
			emailAddress += alphabet.substring(character, character + 3);
			emailAddress += Integer.valueOf((int) (Math.random() * 99)).toString();
			emailAddress = "wellzy1email+" + emailAddress + "@" + "gmail.com";
		}
		return emailAddress;
	}

	public String generateRandomPassword() {

		Random random = new Random();
		String number = "";
		String password = "";
		int NumberLimit = 5;

		for (int i = 0; i < 20; i++) {
			number = String.valueOf(random.nextInt(NumberLimit));
			if (!number.startsWith("0")) {
				password = password + number;
				if (password.length() == 5) {
					NumberLimit = 9;
				}
				if (password.length() == 6) {
					break;
				}
			}
		}
		return password;
	}

	// Method To Create Folder
	public void createFolder(String foldPath) {
		File f = new File(foldPath);
		if (!f.exists()) {
			f.mkdirs();
		}
	}

	// To start the Appium Server
	public void startAppiumServer() {
		Map<String, String> env;
		if (Web_Constants.OS.equalsIgnoreCase("Mac")) {
			env = new HashMap<>(System.getenv());
			env.put("PATH", "/usr/local/bin:" + env.get("PATH"));
			AppiumServiceBuilder builder = new AppiumServiceBuilder().withIPAddress(Web_Constants.APPIUM_IPADDRESS)
					.usingPort(Web_Constants.APPIUM_PORT).withEnvironment(env)
					.usingDriverExecutable(new File(Web_Constants.NODEJS_PATH))
					.withAppiumJS(new File(Web_Constants.APPIUM_JS_PATH));
			service = AppiumDriverLocalService.buildService(builder);
		} else {
			AppiumServiceBuilder builder = new AppiumServiceBuilder().withIPAddress(Web_Constants.APPIUM_IPADDRESS)
					.usingPort(Web_Constants.APPIUM_PORT).usingDriverExecutable(new File(Web_Constants.NODEJS_PATH))
					.withAppiumJS(new File(Web_Constants.APPIUM_JS_PATH));
			service = AppiumDriverLocalService.buildService(builder);
		}

		if (service.isRunning() == true) {
			service.stop();
		} else {
			service.start();
		}
	}

	// To get the time stamp with seconds
	public String getTimeStampWithsec() {

		String timeStamp = "";
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		timeStamp = timeStamp + (c.get(Calendar.MONTH) + 1) + c.get(Calendar.DAY_OF_MONTH) + c.get(Calendar.HOUR)
				+ c.get(Calendar.MINUTE) + c.get(Calendar.SECOND) + c.get(Calendar.MILLISECOND);

		return timeStamp;
	}

	// To get the Time Stamp in Date and Time Format
	public String getTimeStamp() {
		Date d = new Date();
		return d.toString().replace(":", "_").replace(" ", "_");
	}

	public String generateRandomMobileNumber() {

		Random random = new Random();
		String number = "";
		String mobileNumber = "";
		int NumberLimit = 5;

		for (int i = 0; i < 20; i++) {
			number = String.valueOf(random.nextInt(NumberLimit));
			if (!number.startsWith("0")) {
				mobileNumber = mobileNumber + number;
				if (mobileNumber.length() == 5) {
					NumberLimit = 9;
				}
				if (mobileNumber.length() == 10) {
					break;
				}
			}
		}
		return mobileNumber.trim();
	}

	public String generateRandomserial() {
		String strRandomname = "";
		String strNumbers = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		for (int i = 0; i < 6; i++) {
			strRandomNumber.append(strNumbers.charAt(rnd.nextInt(strNumbers.length())));
		}
		strRandomname = strRandomNumber.toString() + "#003";
		return strRandomname;
	}

}
