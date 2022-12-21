	package vTiger.GenericLibrary;

	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Iterator;
	import java.util.Set;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class WebDriverLibrary {

		
		/**
		 * This is used to maximize web page
		 * @param driver
		 */
		public void maximizeWindow(WebDriver driver)
		{
			driver.manage().window().maximize();
		}
		
		/**
		 * This is used to minimize web page
		 * @param driver
		 */
		public void minimizeWindow(WebDriver driver)
		{
			driver.manage().window().minimize();
		}
		
		/**
		 * This is used to wait for 20 seconds to load the web page
		 * @param driver
		 */
		public void waitForPageLoad(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
		}
		
		/**
		 * this method will wait for 10 seconds for element to be visible
		 * @param driver
		 * @param element
		 */
		public void waitForElementToBeVisiale(WebDriver driver, WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10L));
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
		}
		
		/**
		 * This method will wait for 10 seconds for element to be clickable
		 * @param driver
		 * @param element
		 */
		public void waitForElementToBeClickable(WebDriver driver,WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		/**
		 * This is a custom wait which is used to wait for element and perform click operation
		 * @param element
		 * @throws InterruptedException
		 */
		public void waitAndClickOnElement(WebElement element) throws InterruptedException
		{
			int count=0;
			while(count<10)
			{
				try
				{
				element.click();
				break;
				}
				catch(Exception e)
				{
					Thread.sleep(1000);
					count++;
				}
			}
			
		}
		
		/**
		 * this method is used to handle drop-down by select class and select by data indexing
		 * @param element
		 * @param index
		 */
		public void handleDropDown(WebElement element, int index)
		{
			Select s = new Select(element);
			s.selectByIndex(index);
		}
		/**
		 * this method is used to handle drop-down by select class and select by data value
		 * @param element
		 * @param value
		 */
		public void handleDropDown(WebElement element, String value)
		{
			Select s= new Select(element);
			s.selectByValue(value);
		}
		
		/**
		 * this method is used to handle drop-down by select class and select by data by visible text
		 * @param text
		 * @param element
		 */
		public void handleDropDown(String text, WebElement element)
		{
			Select s= new Select(element);
			s.selectByVisibleText(text);
		}
		
		/**
		 * This method will perform mouseHover action
		 * @param driver
		 * @param element
		 */
		public void mouseHoverOn(WebDriver driver, WebElement element)
		{
			Actions a = new Actions(driver);
			a.moveToElement(element).perform();
		}
		
		/** 
		 * this method is used to mouseHover by using x and y co-ordinates
		 * @param driver
		 * @param xOff
		 * @param yOff
		 */
		public void mouseHoverOn(WebDriver driver, int xOff, int yOff)
		{
			Actions a = new Actions(driver);
			a.moveByOffset(xOff,yOff).perform();
		}
		
		/**
		 * this method will perform right click on web page
		 * @param driver
		 */
		public void rightClickOn(WebDriver driver)
		{
			Actions a = new Actions(driver);
			a.contextClick().perform();
		}
		
		/**
		 * This method is used to perform right click on particular element
		 * @param driver
		 * @param element
		 */
		public void rightClickOn(WebDriver driver, WebElement element)
		{
			Actions a = new Actions(driver);
			a.contextClick(element).perform();
		}
		
		/**
		 * this method is used to double click on web page
		 * @param driver
		 */
		public void doubleClickOn(WebDriver driver)
		{
			Actions a = new Actions(driver);
			a.doubleClick().perform();
		}
		
		/**
		 * this method is used to perform double click on particular element
		 * @param driver
		 * @param element
		 */
		public void doubleClickOn(WebDriver driver, WebElement element)
		{
			Actions a = new Actions(driver);
			a.doubleClick(element).perform();
		}
		
		/**
		 * this method will drag and drop from source to destination
		 * @param driver
		 * @param srcElement
		 * @param dstElement
		 */
		public void dragAndDrop(WebDriver driver, WebElement srcElement, WebElement dstElement)
		{
			Actions a = new Actions(driver);
			a.dragAndDrop(srcElement, dstElement).perform();
		}
		
		/**
		 * this method will used to switch the frame by using name or id
		 * @param driver
		 * @param nameOrId
		 */
		public void switchToFrame(WebDriver driver, String nameOrId)
		{
			driver.switchTo().frame(nameOrId);
		}
		
		/**
		 * This method will be used to switch the frame by using element
		 * @param driver
		 * @param element
		 */
		public void switchToFrame(WebDriver driver, WebElement element)
		{
			driver.switchTo().frame(element);
		}
		
		/**
		 * this method will be used to switch to parent frame
		 * @param driver
		 */
		public void switchToParentFrame(WebDriver driver)
		{
			driver.switchTo().parentFrame();
		}
		
		/**
		 * This method will switch to current frame to default frame
		 * @param driver
		 */
		public void switchtoDefaultFrame(WebDriver driver)
		{
			driver.switchTo().defaultContent();
		}
		
		/** 
		 * this method is used to accept the alert pop-up
		 * @param driver
		 */
		public void acceptAlert( WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		
		/**
		 * This method is used to dismiss the alert pop-up
		 * @param driver
		 */
		public void dismissAlert(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		
		/**
		 * This method used to return the alert text to caller
		 * @param driver
		 * @return
		 */
		public String getAlertText(WebDriver driver)
		{
			String text = driver.switchTo().alert().getText();
			return text;
		}
		
		/**
		 * This method will press the enter key
		 * @throws AWTException
		 */
		public void pressEnter() throws AWTException
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		
		/**
		 * This method will switch to window based on partial window title
		 * @param driver
		 * @param partialWindowTitle
		 */
		public void switchTowindow(WebDriver driver, String partialWindowTitle)
		{
			//step1: get all the window handles
			Set<String> windowIds = driver.getWindowHandles();
			
			//step2: iterate through all the windows
			Iterator<String> it = windowIds.iterator();
			
			//step3: navigate to each window and get the title
			while(it.hasNext())
			{
				//step4: capture the individual winddow id
				String winID = it.next();
				
				//step5: switch to that window and capture the title
				String currentTitle = driver.switchTo().window(winID).getTitle();
				
				//step6: compare current title with parent title
				if(currentTitle.contains(partialWindowTitle))
				{
					break;
				}
			}
		}
		
		/**
		 * This method will take screenshot
		 * @param driver
		 * @param screenShotName
		 * @return
		 * @throws IOException 
		 */
		public String takeScreenShot(WebDriver driver, String screenShotName) throws IOException
		{
			TakesScreenshot ts= (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dst= new File(".\\ScreenShot\\"+screenShotName+".png");
			FileUtils.copyFile(src, dst);	//This file is from commons.io
			return dst.getAbsolutePath();
		}
		
		/**
		 * This method will scroll down for 500 units
		 * @param driver
		 */
		public void scrollAction(WebDriver driver)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)", "");
		}
		
		/**
		 * This method will scroll untill it find specified element
		 * @param driver
		 * @param element
		 */
		public void scrollAction(WebDriver driver,WebElement element)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("arguments[0],scrollIntoview(),", element);	or
			int y = element.getLocation().getY();
			js.executeScript("window.scrollBy(0,500)", element);
		}

}

