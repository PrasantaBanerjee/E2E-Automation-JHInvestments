package org.jhi.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/*
 * @author: Prasanta.
 * @desc:   This class implements TestNG's IRetryListener to setup the retry logic for the execution.
 */
public class RetryListener implements IRetryAnalyzer {
	int count=0;
	int maxRetry = 3;
	
	@Override
	public boolean retry(ITestResult arg0) {
		if(count<maxRetry) {
			count++;
			return true;
		}
		return false;
	}

}
