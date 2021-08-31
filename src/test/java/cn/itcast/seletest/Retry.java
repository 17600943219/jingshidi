package cn.itcast.seletest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int retryCnt = 0;
    private int maxRetryCnt = 3;


    public boolean retry(ITestResult iTestResult) {
        if (retryCnt < maxRetryCnt) {
            retryCnt++;
            return true;
        }
        return false;
    }

    // 用于重置retryCnt
    public void reset() {
        retryCnt = 0;
    }
}
