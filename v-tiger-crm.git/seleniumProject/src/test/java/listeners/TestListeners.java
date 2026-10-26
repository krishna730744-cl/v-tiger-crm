package listeners;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utility.BaseTest;
import utility.Screenshot;

public class TestListeners  implements ITestListener {
	public ExtentReports extent;

//	    private static ThreadLocal<ExtentTest> test =new ThreadLocal<>();
	    @Override
	    public void onTestStart(ITestResult result) {
	    	
//	        ExtentTest extentTest =extent.createTest(result.getMethod().getMethodName());
//	        	test.set(extentTest);
	    	String reportName = "./reports/ExtentReport_"
	                + new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())
	                + "_"
	                + System.currentTimeMillis()
	                + ".html";
	    	ExtentSparkReporter spark =  new ExtentSparkReporter(reportName);
	        
	        spark.config().setDocumentTitle("saucec demo report");
	        spark.config().setReportName("login report");
	        spark.config().setTheme(Theme.DARK);

	        extent = new ExtentReports();
	 	    extent.attachReporter(spark);
	        extent.setSystemInfo("browser", "edge");
	        extent.setSystemInfo("window", "10");
	    }
	    @Override
	    public void onTestSuccess(ITestResult result) {
	    	ExtentTest test = extent.createTest(result.getName());
	    	test.log(Status.PASS, result.getName()+"passed");

//	        test.get().pass("Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	ExtentTest test = extent.createTest(result.getName());
	    	test.log(Status.FAIL, result.getName()+"failed!");

//	        test.get().fail("Test Failed");
	        String filepath=null;
	        try {        	
	        	Screenshot cc = new Screenshot(BaseTest.sdriver);
	        	filepath=cc.getScreenshot(result.getMethod().getMethodName());	       
	        	test.addScreenCaptureFromPath(filepath);
	    }
	        catch(Exception e) {
        	e.printStackTrace();
	        }
	        if (result.getThrowable() != null) {
	            test.fail(result.getThrowable());
	        }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {

	    	ExtentTest test = extent.createTest(result.getName());
	    	test.log(Status.SKIP, result.getName()+"skipped!!");
	    }

	    @Override
	    public void onFinish(ITestContext context) {

	        extent.flush();
	    }
	}
