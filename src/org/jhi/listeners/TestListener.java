package org.jhi.listeners;

import org.jhi.main.Base;
import org.jhi.utils.ScreenshotUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/*
 * @auth: Prasanta.
 * @desc: This class implements TestNG's ITestListener to setup logs & screenshot logic for success & failed TCs.
 * 
 */
public class TestListener extends Base implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
			System.err.println(getTestMethodName(arg0) + " FAILED");
			ScreenshotUtils.captureScreenshot(getDriver(), "Failure_");
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println(getTestMethodName(arg0) + " PASSED.");
		ScreenshotUtils.captureScreenshot(getDriver(), "Screenshot_");
	}
	
	private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

}
