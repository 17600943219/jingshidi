package cn.itcast.seletest;

import org.testng.ITestResult;
import org.testng.util.RetryAnalyzerCount;

public class RetryAnalyzer extends RetryAnalyzerCount {
    {
        super.setCount(3);
    }
    public boolean retryMethod(ITestResult result) {
        return false;
    }
}
