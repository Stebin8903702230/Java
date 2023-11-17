package com.BaseMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseMethods {
	private static WebDriver driver;
	static JavascriptExecutor js;
	static Robot r;						//= new Robot();
	static WebDriverWait wait;			// = new WebDriverWait(driver, 30);
	static Select s;
	static Actions a;

//Selection of Browser			
	public static WebDriver launch_Browser (String Browser_Name) {
		try {
		if (Browser_Name.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromiumdriver().setup();
			setDriver(new ChromeDriver());
		}
		else if (Browser_Name.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			setDriver(new EdgeDriver());
		}
		else if (Browser_Name.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			setDriver(new FirefoxDriver());
		}
		else if (Browser_Name.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			setDriver(new InternetExplorerDriver());
		}
		else {
			System.out.println("Invalid browser name.");
		}
		} catch (Exception e) {
			System.out.println("Browser getting error");
		}
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
//getURl
	public static WebDriver getUrl(String url)	{
		try {
			getDriver().get(url);
		} catch (Exception e) {
			System.out.println("Invalid Url");
			}
		return getDriver();
	}
//getCurrentUrl	
	public static void getCurrentUrl() {
		String currentUrl = getDriver().getCurrentUrl();
		System.out.println(currentUrl);
	}
//mouseHover		
	public static void mouseHover(WebElement Element) {
		a = new Actions(getDriver());
		try {
			if (Element.isDisplayed()) {
				a.moveToElement(Element).build().perform();
			}
			else  {
				wait.until(ExpectedConditions.visibilityOf(Element));
			}
		} catch (Exception e) {
			System.out.println("Unable to find element.");
		}
	}
//Scroll_Into_View
	public static void Scroll_Into_View(WebElement Element) {
		js = (JavascriptExecutor) driver;
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", Element);
	}
//sendKeys
	public static void sendKeys(WebElement Element, String StringValue) {
		try {
			if (Element.isEnabled()) {
				Element.clear();
			}else {
				wait.until(ExpectedConditions.visibilityOf(Element));
			}
		} catch (Exception e) {
			System.out.println("Unable to find element");
		}
		
		Element.sendKeys(StringValue);
	}
//getTitle
	public static void getTitle() {
		String Title_name = getDriver().getTitle();
		System.out.println(Title_name);
	}
//dropDown
	public static void dropDown(WebElement Element, String SelectOption, String Value) {
		s = new Select(Element);
		if (SelectOption.equalsIgnoreCase("value")) {
			s.selectByIndex(0);
		}
		else if (SelectOption.equalsIgnoreCase(Value))
		Element.click();
	}
//Click
	public static void Click(WebElement Element) {
		Element.click();
	}
//navigate_To
	public static void navigate_To(String URL) {
		getDriver().navigate().to(URL);
	}
//navigate_Back
	public static void navigate_Back() {
		getDriver().navigate().back();
	}
//navigate_Forword				
	public static void navigate_Forword() {
		getDriver().navigate().forward();
	}
//navigate_Refresh				
	public static void navigate_Refresh() {
		getDriver().navigate().refresh();
	}
//getText
	public static void getText(WebElement Element) {
		Element.getText();
	}
//getAttribute
	public void getAttribute(WebElement Element, String AttributeValue) {
		Element.getAttribute(AttributeValue);
	}
//radio_Btn
	public void radio_Btn(WebElement Element, WebElement RadioBtn) {
		Element.click();
		RadioBtn.click();
	}
//CheckBox
	public void CheckBox(WebElement CheckBox_Element) {
		CheckBox_Element.click();
	}
//getOptions
	public void getOptions(WebElement Element) {
		Element.click();
	}
//firstSelectedOptions
	public void firstSelectedOptions(WebElement Element) {
		s = new Select(Element);
		s.getFirstSelectedOption();
	}
//ScreenShot
//	public void ScreenShot(String ScreenShot_Name) throws IOException {
//		TakesScreenshot ts = (TakesScreenshot)driver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		File dest = new File("C:\\Users\\Public\\Jdk\\Nykaa\\src\\ScreenshotEvidance\\"+ScreenShot_Name+".png");
//		FileUtils.copyFile(src, dest);
//	}
	
	public void WindowHandle(String First_Tab_id) {
		First_Tab_id = getDriver().getWindowHandle();				
	}
//Switch to next tab			
	public void WindowHandles(String First_Tab_id) {
		First_Tab_id = getDriver().getWindowHandle();
		
		Set<String> AllTabId = getDriver().getWindowHandles();				
			
			for(String Second_Tab_ID: AllTabId) {
				if(!First_Tab_id.equals(Second_Tab_ID)) {
					getDriver().switchTo().window(Second_Tab_ID);
				}
			}
	}
//Alert
//	public void Alert(WebElement Alert_btn, String AcceptDismiss) {
//		Alert_btn.click();
//		Alert alert = driver.switchTo().alert();
//		if (AcceptDismiss.equalsIgnoreCase("Accept")) {
//		alert.accept();
//		}
//		if (AcceptDismiss.equalsIgnoreCase("Dismiss")){
//		alert.dismiss();
//		}
//	}
//Tab Close
	public void Close() {
		getDriver().close();
	}
//Browser Close
	public static void Quit() {
		getDriver().quit();
	}
//MouseClick
	public static void MouseClick(WebElement Element) {
		a.click(Element).build().perform();
	}
//Keyboard
	public void Keyboard() throws AWTException {
		r = new Robot();
	}
//DragAndDrop
	public void DragAndDrop(WebElement DragElement, WebElement DropElement) {
		a.dragAndDrop(DragElement, DropElement).build().perform();
	}
//I_frame_navigate
	public void I_frame_navigate(WebElement Element) {
		getDriver().switchTo().frame(Element);
	}
//Wait_VisibilityOfElement		
	public static void Wait_VisibilityOfElement(WebElement Element) {
		wait.until(ExpectedConditions.visibilityOf(Element));
	}
//Wait_ElementToBeClickable
	public static void Wait_ElementToBeClickable(WebElement Element) {
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
//element_isDisplayed
	public void element_isDisplayed(WebElement Element) {
		Element.isDisplayed();
	}
//element_isEnabled
	public void element_isEnabled(WebElement Element) {
		Element.isEnabled();
	}
//element_isSelected
	public void element_isSelected(WebElement Element) {
		Element.isSelected();
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		BaseMethods.driver = driver;
	}

}

