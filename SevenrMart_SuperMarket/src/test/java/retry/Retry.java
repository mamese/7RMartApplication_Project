//retry is used in the scenario were the test case may fail due to some external factors like resource availability method issues we can use the retry class to re-try the failed testcases

package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	int counter = 0;
	int retryLimit = 2;

	public boolean retry(ITestResult result) {

		if (counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
	}
}