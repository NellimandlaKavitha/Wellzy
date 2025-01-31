package utils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.Scenario;

public class ReportUtils {

	public ExtentSparkReporter reporter;
	public static ExtentReports report;
	protected static ExtentTest mainTest;
	public ExtentTest test;
	public InetAddress systemAddress;
	public String suiteName;
	public String testName;
	public String Report_Name;
	private String report_folder;
	public static String className;
	public static String methodName;
	public static String testCaseName;
	public static String hour;
	
	public static String screenShotFolderPath;
	public static String screenShotFilePath;
	
	public static String scenarioName;


	public void initializeReport(String suiteName) {
		
		Utilities utils = new Utilities();
	if (Web_Constants.OS.equalsIgnoreCase("mac")) {
			report_folder = Web_Constants.REPORT_PATH_MAC ;
		} else {
			report_folder= Web_Constants.REPORT_PATH ;
		}		
		
		utils.createFolder(report_folder);

		Report_Name = report_folder + "Wellzy" + getTimeStamp() + ".html";
		reporter = new ExtentSparkReporter(Report_Name);
		reporter.config().setDocumentTitle("Wellzy");
		reporter.config().setProtocol(Protocol.HTTPS);
		reporter.config().setEncoding("UTF-8");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Wellzy");
		report = new ExtentReports();
		report.attachReporter(reporter);
		Web_Constants.ExtentReportPath=Report_Name;
		try {
			systemAddress = Inet4Address.getLocalHost();
		} catch (UnknownHostException e) {
			test.log(Status.INFO, "Unable to get the local host");
		}

		report.setSystemInfo("IP Address", systemAddress.getHostAddress());
		report.setSystemInfo("Host Name", systemAddress.getHostName());
		report.setSystemInfo("UserName", System.getProperty("user.name"));
		report.setSystemInfo("Operating System", System.getProperty("os.name"));

		report.flush();
		
//		if (Web_Constants.KLOV_FLAG) {
//			try {
//				if(Web_Constants.OS.equalsIgnoreCase("Windows")) {
//					ExtentKlovReporter klovReporter = new ExtentKlovReporter(suiteName);
//					klovReporter.initMongoDbConnection("103.50.212.111", 27017);
//					klovReporter.setProjectName(suiteName);
//					klovReporter.setReportName(Report_Name);
//					klovReporter.initKlovServerConnection("http://103.50.212.111/");
//					report.attachReporter(klovReporter, reporter);
//					createTest("Klov Server Connected for: "+Web_Constants.PROJECT);
//					}
//			} catch (Exception e) {
//				System.out.println("[INFO] KLOV Server is down");
//				report = new ExtentReports();
//				report.attachReporter(reporter);
//			}
//		} else {
//			report.attachReporter(reporter);
//		}
		report.attachReporter(reporter);
	}
	
	public void createTest(String name) {
		
		mainTest = report.createTest(name);
//		System.out.println(mainTest.getClass().getTypeName());
	}

	public void createNode(String stepDefinitionName) {
		test = mainTest.createNode(stepDefinitionName);
//		test=mainTest;
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
	
	public String getFeature(String featureFile) {
		int count = 0;
		for (int i = 0; i < featureFile.length() - 1; i++) {

			char ch = featureFile.charAt(featureFile.length() - (i + 1));

			String str = String.valueOf(ch);

			if (str.equals("/")) {
				break;
			}
			count++;
		}

		featureFile = featureFile.substring(featureFile.length()-count);

		return featureFile;
	}
	
	public String getScenario(Scenario scenario) {
		
		String name = getFeature(scenario.getUri().toString())+" : "+this.getClass().getSimpleName()+" : "+scenario.getName();
		
		scenarioName=name;
		
		return name;
	}

}



