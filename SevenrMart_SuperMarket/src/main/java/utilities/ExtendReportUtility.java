package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility {
    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        // Corrected the file path by removing surrounding quotes
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        
        // Configuring the report
        reporter.config().setReportName("SevenRMartSuperMarket");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("organization", "Obsqura");
        extentReports.setSystemInfo("Name", "Megha");
        
        return extentReports;
    }
}
