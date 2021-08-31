package cn.itcast.seletest;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestngListener extends TestListenerAdapter {
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        // 对于dataProvider的用例，每次成功后，重置Retry次数
        Retry retry = (Retry) tr.getMethod().getRetryAnalyzer();
        retry.reset();
    }

    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        // 对于dataProvider的用例，每次失败后，重置Retry次数
        Retry retry = (Retry) tr.getMethod().getRetryAnalyzer();
        retry.reset();
    }
}
