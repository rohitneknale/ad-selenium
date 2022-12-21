package vTiger.GenericLibrary;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplementationClass implements ITestListener 
{

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" ---> test execution started");
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" ---> test execution sucessful");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		WebDriverLibrary wLib = new WebDriverLibrary();
		JavaLibrary jLib = new JavaLibrary();
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" ---> test execution failed");
		System.out.println(result.getThrowable());
		
		String screenshotName = methodName+"-"+jLib.getSystemDateInFormat();
		try 
		{
			wLib.takeScreenShot(BaseClass.sdriver, screenshotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" ---> test execution skipped");
		
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
				System.out.println("Execution is started");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
				System.out.println("Execution finished");
	}
	
}
