   package com.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static Alert A;
	public static JavascriptExecutor js;
	public static TakesScreenshot tk;
	
	
	

	public static WebDriver launchBroswer(String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}

		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

		else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.edgedriver().setup();
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();

		return driver;
	}

	public static void getUrl(String url) {
		driver.get(url);
	}

	public static void toMaximize() {
		driver.manage().window().maximize();
	}

	public static void toGetTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void toGetCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void toFillInput(WebElement element, String input) {
		element.sendKeys(input);
	}

	public static void clickOnElement(WebElement element) {
		element.click();
	}

	public static void sendValues(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void toCloseBrowser() {
		driver.close();
	}

	public static void toQuitBrowser() {
		driver.quit();
	}

	// ***** Action Class ***** //
	public static void actionsHelper() {
		a = new Actions(driver);
	}

	public static void toPerformRightClick(WebElement element) {
		a.contextClick(element).perform();
	}

	public static void doubleClick(WebElement element) {
		a.doubleClick(element).perform();
	}

	public static void moveToElement(WebElement element) {
		a.moveToElement(element).perform();
	}

	public static void dragAndDrop(WebElement source, WebElement target) {
		a.dragAndDrop(source, target).perform();
	}

	public static void keyDown(WebElement element, CharSequence key) {
		a.keyDown(element, key).perform();
	}

	public static void keyUp(WebElement element, CharSequence key) {
		a.keyUp(element, key).perform();
	}

// ***** Robot Class ***** //
	public static void robotHelper() throws AWTException {
		r = new Robot();
	}

	public static void toKeyPress(int keyCode) {
		r.keyPress(keyCode);
	}

	public static void toKeyRelease(int keyCode) {
		r.keyRelease(keyCode);
	}

// ***** Alerts ***** //
	public static void alertswitchto() {
		A = driver.switchTo().alert();
	}

	public static void alertAccept() {
		A.accept();
	}

	public static void alertDismiss() {
		A.dismiss();
	}

	public static void getAlertText() {
		A.getText();
	}

	public static void sendTextToAlert(String text) {
		A.sendKeys(text);
	}

// ***** Frames ***** //
	public static void switchToFrame(String frameNameOrId) {
		driver.switchTo().frame(frameNameOrId);
	}

	public static void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	public static void switchToMainFrame() {
		driver.switchTo().defaultContent();
	}

	public static void navigateTo(String url) {

		driver.navigate().to(url);
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void refreshPage() {
		driver.navigate().refresh();
	}

	// ***** JavaScriptExecutor ***** //
	public static void SeleniumJavaScriptHelper() {
		js = (JavascriptExecutor) driver;
	}

	public static void executeJavaScript(String script) {
		js.executeScript(script);
	}

	// ***** TakesScreenshot ***** //
	public static void TakeScreenshotHelper() {
		tk = (TakesScreenshot) driver;
	}

	public static void getScreenshot(String Location) throws IOException {
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File(Location);
		Files.copy(src, des);

	}

	// ***** DropDown ***** //
	public static void selectByVisibleText(WebElement dropdownElement, String visibleText) {
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText(visibleText);
	}

	public static void selectByValue(WebElement dropdownElement, String value) {
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByValue(value);
	}

	public static void selectByIndex(WebElement dropdownElement, int index) {
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByIndex(index);
	}

	public static void deselectAll(WebElement dropdownElement) {
		Select dropdown = new Select(dropdownElement);
		dropdown.deselectAll();
	}

	public static void deselectByVisibleText(WebElement dropdownElement, String visibleText) {
		Select dropdown = new Select(dropdownElement);
		dropdown.deselectByVisibleText(visibleText);
	}

	public static void deselectByValue(WebElement dropdownElement, String value) {
		Select dropdown = new Select(dropdownElement);
		dropdown.deselectByValue(value);
	}

	public static void deselectByIndex(WebElement dropdownElement, int index) {
		Select dropdown = new Select(dropdownElement);
		dropdown.deselectByIndex(index);
	}

	public static void isMultiple(WebElement dropdownElement) {
		Select s = new Select(dropdownElement);
		if (s.isMultiple()) {
			System.out.println("We can select more than one option");
		} else {
			System.out.println("We can't select more than one option");
		}
	}

	// ***** Windows Handling ***** //

	// ***** WebTable ***** //

	// ***** Waits ***** //
	public static void setImplicitWait(long timeoutInSeconds) {
		driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
	}

	public static void sleep(long timeoutInSeconds) throws InterruptedException {

		Thread.sleep(timeoutInSeconds);
	}
	
	

}
