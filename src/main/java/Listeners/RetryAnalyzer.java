package Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITest;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int count =0;
    int max_try = 2;
    public  boolean retry(ITestResult result){
        if(!result.isSuccess()){
            if(count<max_try){
                count++;
                return true;
            }
        }
        return  false;
    }
    private String getResultStatusName(int status) {
        if (status == 1) return "SUCCESS";
        if (status == 2) return "FAILURE";
        if (status == 3) return "SKIP";
        return null;
    }
}
