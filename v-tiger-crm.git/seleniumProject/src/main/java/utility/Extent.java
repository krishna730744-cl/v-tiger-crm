//package utility;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//public class Extent {
//	  public static ExtentReports extent;
//	    public static ExtentTest test;
//
//	    // One-time initialization method
//	    public static ExtentReports  setUpReport() {
//
//	    	String reportName = "./reports/ExtentReport_"
//	                + new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())
//	                + "_"
//	                + System.currentTimeMillis()
//	                + ".html";
//	        ExtentSparkReporter spark =  new ExtentSparkReporter(reportName);
//	        
//	        spark.config().setDocumentTitle("saucec demo report");
//	        spark.config().setReportName("login report");
//	        spark.config().setTheme(Theme.DARK);
//
//	        extent = new ExtentReports();
//
//	        extent.attachReporter(spark);
//	        extent.setSystemInfo("browser", "edge");
//	        extent.setSystemInfo("window", "10");
//	        return extent;
//	    }
//
//	    // Create test
//	    public static void createTest(String testName) {
//
//	        test = extent.createTest(testName);
//	    }
//
//	    // Log PASS
//	    public static void pass(String message) {
//
//	        test.pass(message);
//	    }
//
//	    // Log FAIL
//	    public static void fail(String message) {
//
//	        test.fail(message);
//	    }
//
//	    // Log INFO
//	    public static void info(String message) {
//
//	        test.info(message);
//	    }
//
//	    // Generate/save report
//	    public static void flushReport() {
//
//	        extent.flush();
//	    }
//	}
//
//
