package com.stepdefinition;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.gherkin.model.Scenario;
import com.baseclass.BaseClass;
import com.pom.Login_Navia_POM;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends BaseClass {
	public static ATUTestRecorder recorder;

	Login_Navia_POM l = new Login_Navia_POM(driver);
	Actions ac = new Actions(driver);

	static Set<String> windowHandles = driver.getWindowHandles();
	static ArrayList<String> li = new ArrayList<String>(windowHandles);

	@Before
	public static void beforeStartTestCase() throws ATUTestRecorderException, InterruptedException {
	    try {
	        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
	        Date date = new Date();
	        recorder = new ATUTestRecorder("C:\\Users\\Venkateshwaran\\eclipse-workspace\\PreMarket\\VideoRecording",
	                "RecordedVideo-" + dateFormat.format(date), false);
	        recorder.start();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@After
	public static void afterTestCase() throws ATUTestRecorderException {
	    try {
	        recorder.stop();
	        driver.manage().deleteAllCookies();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@Given("User Navigate to Navia")
	public void user_navigate_to_navia() {
	    try {
	        driver.get("https://yopmail.com/");
	        String currentUrl = driver.getCurrentUrl();
	        System.out.println(currentUrl);

	        WebElement yopMail = driver.findElement(By.xpath("//input[@placeholder='Enter your inbox here']"));
	        yopMail.sendKeys("naviatesting@yopmail.com");

	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();

	        WebElement createAccount = driver.findElement(By.xpath("//a[@title='YOPmail - Temporary email']"));
	        Actions ac = new Actions(driver);
	        ac.contextClick(createAccount).perform();

	        Robot robot = new Robot();
	        robot.keyPress(KeyEvent.VK_DOWN);
	        robot.keyRelease(KeyEvent.VK_DOWN);

	        robot.keyPress(KeyEvent.VK_DOWN);
	        robot.keyRelease(KeyEvent.VK_DOWN);

	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);

	        Thread.sleep(8000);

	        Set<String> windowHandles = driver.getWindowHandles();
	        ArrayList<String> li = new ArrayList<String>(windowHandles);
	        int size = li.size();
	        System.out.println(size);

	        driver.switchTo().window(li.get(1));
	        driver.navigate().refresh();

	        getUrl("https://rocket.tradeplusonline.com/login.php");
	        sleep(5000);
	        clickOnElement(l.getLoginWithClientCode());
	        driver.findElement(By.xpath("//input[@name='clientCode']")).click();

	        sleep(1000);
	        sendValues(l.getClientCode(), "63748379");
	        clickOnElement(l.getPassWord());
	        sleep(1000);
	        sendValues(l.getPassWord(), "Testing@123");

	        clickOnElement(l.getCheckBox());
	        clickOnElement(l.getLogin());

	        driver.switchTo().window(li.get(0));
	        Thread.sleep(8000);

	        WebElement refresh = driver.findElement(By.xpath("//button[@id='refresh']"));
	        refresh.click();

	        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='ifmail']"));
	        driver.switchTo().frame(iframe);

	        Thread.sleep(3000);

	        WebElement otp = driver.findElement(
	                By.xpath("//font[text()='Your One Time Password (OTP) for BOLTPlus On Web login is ']//child::strong"));
	        String text = otp.getText();
	        System.err.println(text);

	        driver.switchTo().defaultContent();
	        Thread.sleep(2000);

	        driver.switchTo().window(li.get(1));
	        clickOnElement(l.getOtpClick());
	        Thread.sleep(2000);

	        driver.findElement(By.xpath("//input[@id='userotp']")).sendKeys(text);
	        driver.switchTo().window(li.get(0));
	        driver.close();
	        driver.switchTo().window(li.get(1));
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@When("User Click login with client code")
	public void user_click_login_with_client_code() {
	    try {
	        System.out.println("User Click login with client code");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@When("User Enter Client Code")
	public void user_enter_client_code() {
	    try {
	        System.out.println("User Enter Client Code");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	@When("User Enter Password")
	public void user_enter_password() {
	    try {
	        System.out.println("User Enter Password");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@When("User Click Agree CheckBox")
	public void user_click_agree_check_box() {
	    try {
	        System.out.println("User Click Agree CheckBox");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@When("User Click Login button")
	public void user_click_login_button() {
	    try {
	        System.out.println("User Click Login button");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@When("User Click Otp Verification and enter manualy")
	public void user_click_otp_verification_and_enter_manualy() {
	    try {
	        System.out.println("User Click Otp Verification and enter manually");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@When("User Click Login Again")
	public void user_click_login_again() {
	    try {
	        clickOnElement(l.getLoginAfterOTP());
	        setImplicitWait(24);

	        System.out.println("Home Page");
	        WebElement textBox = driver.findElement(By.xpath("//h2[text()='RISK DISCLOSURES ON DERIVATIVES ']"));

	        if (textBox.isDisplayed()) {
	            Thread.sleep(2000);
	            driver.findElement(By.xpath("//span[text()='Agree']//parent::button")).click();
	        } else {
	            System.out.println("Not Present in the Page");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@When("User Click the Watch List")
	public void user_click_the_watch_list() {
	    try {
	        Thread.sleep(4000);
	        WebElement element = driver
	                .findElement(By.xpath("(//div[@class='header-left']//descendant::span[@class='ind_syml'])[1]"));
	        element.click();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@When("User Select scrip {string}")
	public void user_select_scrip(String string) {
	    try {
	        driver.findElement(By.xpath("//div[@class='select-box active']//descendant::li//span[text()='" + string + "']"))
	                .click();
	        System.out.println(string);
	        Thread.sleep(4000);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	@When("User Click Watch List Again")
	public void user_click_watch_list_again() throws InterruptedException {
	    try {
	        WebElement element1 = driver
	                .findElement(By.xpath("(//div[@class='header-left']//descendant::span[@class='ind_syml'])[1]"));
	        element1.click();
	        Thread.sleep(2000);
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_click_watch_list_again': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("User mouse over the scrip {string}")
	public void user_mouse_over_the_scrip(String string) throws InterruptedException {
	    try {
	        WebElement contractSelectAgain = driver.findElement(
	                By.xpath("//div[@class='select-box active']//descendant::li//span[text()='" + string + "']"));
	        Thread.sleep(1000);

	        Actions ac = new Actions(driver);
	        ac.moveToElement(contractSelectAgain).perform();
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_mouse_over_the_scrip': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("User Click the Charts")
	public void user_click_the_charts() throws InterruptedException {
	    try {
	        WebElement charts = driver.findElement(By.xpath(
	                "//div[@class='select-box active']//descendant::span[text()='Nifty 50']//ancestor::li//descendant::img"));
	        charts.click();
	        Thread.sleep(2000);
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_click_the_charts': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("User Click the Candles Icon")
	public void user_click_the_candles_icon() throws InterruptedException {
	    try {
	        WebElement firstiFrame = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
	        driver.switchTo().frame(firstiFrame);
	        Thread.sleep(1000);

	        WebElement iframe = driver.findElement(By.xpath("//iframe[@title='Financial Chart']"));
	        driver.switchTo().frame(iframe);

	        driver.findElement(By.xpath("//div[@id='header-toolbar-chart-styles']")).click();
	        Thread.sleep(1000);
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_click_the_candles_icon': " + e.getMessage());
	        e.printStackTrace();
	    }
	}


	@When("User Choose Candle {string}")
	public void user_choose_candle(String string) throws InterruptedException {
	    try {
	        driver.findElement(By.xpath("//div[@data-value='" + string + "']")).click();
	        Thread.sleep(1000);
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_choose_candle': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("User Click the Mintues")
	public void user_click_the_mintues() throws InterruptedException {
	    try {
	        driver.findElement(By.xpath("//div[@id='header-toolbar-intervals']")).click();
	        Thread.sleep(1000);
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_click_the_mintues': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("User Choose One Minute")
	public void user_choose_one_minute() {
	    try {
	        driver.findElement(By.xpath("//div[text()='1 minute']//ancestor::div[@data-value='1']")).click();
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_choose_one_minute': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("Verify One Minute Feed Connection Value and Wait One Minute Very Feed Connection Changes")
	public void verify_one_minute_feed_connection_value_and_wait_one_minute_very_feed_connection_changes()
	        throws InterruptedException {
	    try {
	        WebElement element3 = driver.findElement(By.xpath(
	                "/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
	        Thread.sleep(4000);
	        String text2 = element3.getText();
	        System.err.println("Feed Connection Value of One Minute : " + text2);

	        Thread.sleep(60000);

	        System.out.println("Feed Connection Value of After One Minute : " + text2);
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'verify_one_minute_feed_connection_value_and_wait_one_minute_very_feed_connection_changes': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("User Click the Five Minute")
	public void user_click_the_five_minute() {
	    try {
	        driver.findElement(By.xpath("//div[@id='header-toolbar-intervals']")).click();
	        driver.findElement(By.xpath("//div[text()='5 minutes']//ancestor::div[@data-value='5']")).click();
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_click_the_five_minute': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("Verify Five Minute Feed Connection Valuebb")
	public void verify_five_minute_feed_connection_value() throws InterruptedException {
	    try {
	        WebElement element2 = driver.findElement(By.xpath(
	                "/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
	        Thread.sleep(4000);
	        String text = element2.getText();
	        System.err.println("Feed Connection Value of Five Minutes : " + text);
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'verify_five_minute_feed_connection_value': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("User Click One Day")
	public void user_click_one_day() {
	    try {
	        driver.findElement(By.xpath("//div[@id='header-toolbar-intervals']")).click();
	        driver.findElement(By.xpath("//div[text()='1 day']//ancestor::div[@data-value='1D']")).click();
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_click_one_day': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("Verify One Day Feed Connection Value and Wait One Minute Very Feed Connection Changes")
	public void verify_one_day_feed_connection_value_and_wait_one_minute_very_feed_connection_changes()
	        throws InterruptedException {
	    try {
	        WebElement element4 = driver.findElement(By.xpath(
	                "/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
	        Thread.sleep(4000);
	        String text3 = element4.getText();
	        System.err.println("Feed Connection Value of 1 hour : " + text3);
	        Thread.sleep(60000);

	        System.err.println("Feed Connection Value of 1 hour and 1 mins: " + text3);
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'verify_one_day_feed_connection_value_and_wait_one_minute_very_feed_connection_changes': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("User click the search box")
	public void user_click_the_search_box() throws InterruptedException {
	    try {
	        Thread.sleep(4000);
	        driver.findElement(By.xpath("//input[@id='project-id']")).click();
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_click_the_search_box': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("User Search any {string} Script")
	public void user_search_any_script(String string) throws InterruptedException {
	    try {
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys(string);
	        Thread.sleep(2000);
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_search_any_script': " + e.getMessage());
	        e.printStackTrace();
	    }
	}


	@When("User Mouse Over and Add a Script")
	public void user_mouse_over_and_add_a_script() throws InterruptedException {
	    try {
	        Thread.sleep(3000);
	        WebElement element = driver.findElement(By.xpath("(//div[@class='srh_results act']/descendant::span[text()='WIPRO'])[1]"));

	        Actions ac = new Actions(driver);
	        ac.moveToElement(element).perform();
	        Thread.sleep(3000);

	        driver.findElement(By.xpath("(//div[@class='srh_results act']/descendant::span[@class='s_add_sym'])[1]"))
	                .click();
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_mouse_over_and_add_a_script': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("User Mouse Over and Add a Script {string}")
	public void user_mouse_over_and_add_a_script(String string) throws InterruptedException {
	    try {
	        Thread.sleep(3000);
	        WebElement element = driver.findElement(By.xpath("(//div[@class='srh_results act']/descendant::span[text()='"+string+"'])[1]"));

	        Actions ac = new Actions(driver);
	        ac.moveToElement(element).perform();
	        Thread.sleep(3000);

	        driver.findElement(By.xpath("(//span[text()='"+string+"']//ancestor::li//descendant::span[@class='s_add_sym'])[1]"))
	                .click();
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_mouse_over_and_add_a_script': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("User POP Up Message Appear Verify POP UP")
	public void user_pop_up_message_appear_verify_pop_up() throws InterruptedException {
	    try {
	        WebElement popUp = driver.findElement(By.xpath("//span[text()='Symbol Has been Added Successfully']"));

	        if (popUp.isDisplayed()) {
	            System.out.println("Verify Pop is Displayed Successfully");
	        } else {
	            System.out.println("Verify Pop is Not Displayed ");
	        }
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_pop_up_message_appear_verify_pop_up': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("User Mouse over the {string} Script and Click")
	public void user_mouse_over_the_first_script_and_click(String string) throws InterruptedException {
	    try {
	        Thread.sleep(3000);
	        WebElement script = driver.findElement(By.xpath("(//ul[@class='list ui-sortable'])[1]"));
	        Actions ac = new Actions(driver);
	        ac.moveToElement(script).perform();
	        Thread.sleep(3000);

	        driver.findElement(By.xpath("(//ul[@class='list ui-sortable']//descendant::span)[15]")).click();
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_mouse_over_the_first_script_and_click': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("User Delete the Script")
	public void user_delete_the_script() throws InterruptedException {
	    try {
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//lable[text()='Delete']//parent::button")).click();
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_delete_the_script': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("User Verify Script Deleted SuccesFully")
	public void user_verify_script_deleted_succes_fully() {
	    try {
	        WebElement recordDelete = driver.findElement(By.xpath("//span[text()='Record Deleted Successfully']"));

	        if (recordDelete.isDisplayed()) {
	            System.out.println("Verify Pop is Displayed Script Deleted");
	        } else {
	            System.out.println("Verify Script is Not Deleted");
	        }
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_verify_script_deleted_succes_fully': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("User mouse the scrip Selected {string}")
	public void user_mouse_the_scrip_selected(String string) throws InterruptedException {
	    try {
	        WebElement element2 = driver.findElement(By.xpath("(//span[text()='" + string + "'])[1]"));
	        Actions ac = new Actions(driver);
	        ac.moveToElement(element2).perform();
	        Thread.sleep(2000);
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_mouse_the_scrip_selected': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("User Click the Buy scrip for Selected {string} Scrip")
	public void user_click_the_buy_scrip_for_selected_scrip(String string) {
	    try {
	        WebElement buyScript = driver.findElement(By.xpath(
	                "//span[text()='" + string + "']//ancestor::div[@class='m_bg_color']//descendant::span[text()='B']"));
	        buyScript.click();
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_click_the_buy_scrip_for_selected_scrip': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("User Click Market then Limit")
	public void user_click_market_then_limit() throws InterruptedException {
	    try {
	        WebElement chooseMarket = driver.findElement(By.xpath("//label[text()='Market']"));
	        chooseMarket.click();
	        Thread.sleep(2000);

	        WebElement chooseLimit = driver.findElement(By.xpath("//label[text()='Limit']"));
	        chooseLimit.click();
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_click_market_then_limit': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("User Enter Amount in Price Text Box {string}")
	public void user_enter_amount_in_price_text_box(String string) throws InterruptedException {
	    try {
	        Thread.sleep(2000);
	        // Example for further implementation
	        // WebElement clearPrice = driver.findElement(By.xpath("//label[text()='Price']//parent::div[@class='tag-box']//descendant::input[@type='number']"));
	        // clearPrice.clear();
	        // clearPrice.sendKeys(string);
	        // Thread.sleep(2000);
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_enter_amount_in_price_text_box': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("User Click Buy")
	public void user_click_buy() {
	    try {
	        WebElement clickBuy = driver.findElement(By.xpath("//button[text()='BUY']"));
	        clickBuy.click();
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_click_buy': " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@When("User Click Yes Popup")
	public void user_click_yes_popup() throws InterruptedException {
	    try {
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//div[@class='jconfirm-buttons']//child::button[text()='yes']")).click();
	        Thread.sleep(2000);
	    } catch (Exception e) {
	        System.out.println("Error occurred in 'user_click_yes_popup': " + e.getMessage());
	        e.printStackTrace();
	    }
	}


	@Then("Verify the Buy Scrip Notification Pop up")
	public void verify_the_buy_scrip_notification_pop_up() {
	    try {
	        WebElement buyPopup = driver.findElement(By.xpath("//span[@class='dhx_message__text']"));
	        if (buyPopup.isDisplayed()) {
	            System.err.println("Verify the buyPop is Displayed Successfully");
	        } else {
	            System.err.println("Verify the buyPop is Not Displayed ");
	        }
	    } catch (Exception e) {
	        System.err.println("Error verifying the buy pop: " + e.getMessage());
	    }
	}

	@When("User Click Pending Orders")
	public void user_click_pending_orders() throws InterruptedException {
	    try {
	        Thread.sleep(4000);
	        driver.findElement(By.xpath("//span[text()='Pending Orders']//parent::a")).click();
	        Thread.sleep(2000);
	    } catch (Exception e) {
	        System.err.println("Error clicking pending orders: " + e.getMessage());
	    }
	}

	@When("User Click Edit Icon for Selected Scrip {string}")
	public void user_click_edit_icon_for_selected_scrip(String string) throws InterruptedException {
	    try {
	        WebElement editScript = driver.findElement(By.xpath("//span[text()='" + string
	                + "']//parent::div[@role='button']//descendant::span[@class='cntx_menu order_context']"));
	        editScript.click();
	        Thread.sleep(2000);
	    } catch (Exception e) {
	        System.err.println("Error clicking edit icon for selected script: " + e.getMessage());
	    }
	}

	@When("User Click Modify")
	public void user_click_modify() {
	    try {
	        driver.findElement(By.xpath("//span[text()='Modify']//ancestor::button")).click();
	    } catch (Exception e) {
	        System.err.println("Error clicking modify: " + e.getMessage());
	    }
	}

	@When("User Modify Quality")
	public void user_modify_quality() throws InterruptedException {
	    try {
	        WebElement qty = driver.findElement(By.xpath("//label[text()='Qty']//following-sibling::input"));
	        Actions ac = new Actions(driver);
	        ac.moveToElement(qty).perform();
	        Thread.sleep(2000);
	        qty.clear();
	        Thread.sleep(2000);
	        qty.sendKeys("2");
	    } catch (Exception e) {
	        System.err.println("Error modifying quantity: " + e.getMessage());
	    }
	}

	@When("User Modify Price")
	public void user_modify_price() throws InterruptedException {
	    try {
	        WebElement price = driver.findElement(By.xpath("//label[text()='Price']//following-sibling::input"));
	        price.clear();
	        price.sendKeys("513.20");
	        Thread.sleep(2000);
	    } catch (Exception e) {
	        System.err.println("Error modifying price: " + e.getMessage());
	    }
	}

	@When("User Click Update")
	public void user_click_update() {
	    try {
	        WebElement update = driver.findElement(By.xpath("//button[text()='Update']"));
	        update.click();
	    } catch (Exception e) {
	        System.err.println("Error clicking update: " + e.getMessage());
	    }
	}

	@When("User Click Yes in Pop up")
	public void user_click_yes_in_pop_up() throws InterruptedException {
	    try {
	        Thread.sleep(2000);
	        WebElement updateYes = driver.findElement(By.xpath("//button[text()='yes']"));
	        updateYes.click();
	    } catch (Exception e) {
	        System.err.println("Error clicking yes in popup: " + e.getMessage());
	    }
	}

	@Then("Verify the Modify Notification popup")
	public void verify_the_modify_notification_popup() {
	    try {
	        WebElement updatePopup = driver.findElement(By.xpath("//span[@class='dhx_message__text']"));
	        if (updatePopup.isDisplayed()) {
	            System.out.println("Verify the Update Successfully");
	        } else {
	            System.out.println("Verify the update is not completed");
	        }
	    } catch (Exception e) {
	        System.err.println("Error verifying the modify notification popup: " + e.getMessage());
	    }
	}

	@When("User Click Pending Order")
	public void user_click_pending_order() throws InterruptedException {
	    try {
	        driver.findElement(By.xpath("//span[text()='Pending Orders']//parent::a")).click();
	        Thread.sleep(2000);
	    } catch (Exception e) {
	        System.err.println("Error clicking pending order: " + e.getMessage());
	    }
	}

	@When("User Click Selected Scrip {string} Edit")
	public void user_click_selected_scrip_edit(String string) throws InterruptedException {
	    try {
	        WebElement editScript = driver.findElement(By.xpath("//span[text()='" + string
	                + "']//parent::div[@role='button']//descendant::span[@class='cntx_menu order_context']"));
	        editScript.click();
	        Thread.sleep(2000);
	    } catch (Exception e) {
	        System.err.println("Error clicking selected script edit: " + e.getMessage());
	    }
	}

	@When("User Click Cancel")
	public void user_click_cancel() throws InterruptedException {
	    try {
	        driver.findElement(By.xpath("//span[text()='Cancel']//ancestor::button[@type='button']")).click();
	        Thread.sleep(2000);
	    } catch (Exception e) {
	        System.err.println("Error clicking cancel: " + e.getMessage());
	    }
	}

	@When("User Click Yes for Confirmation")
	public void user_click_yes_for_confirmation() {
	    try {
	        driver.findElement(By.xpath("//button[text()='yes']")).click();
	    } catch (Exception e) {
	        System.err.println("Error clicking yes for confirmation: " + e.getMessage());
	    }
	}

	@Then("User Verify the Cancellation Notification Popup")
	public void user_verify_the_cancellation_notification_popup() {
	    try {
	        WebElement deletedScriptPopup = driver.findElement(By.xpath("//span[@class='dhx_message__text']"));
	        if (deletedScriptPopup.isDisplayed()) {
	            System.out.println("Verify Script Deleted Successfully");
	        } else {
	            System.out.println("Verify Script is Not Deleted");
	        }
	    } catch (Exception e) {
	        System.err.println("Error verifying the cancellation notification popup: " + e.getMessage());
	    }
	}

	@When("User Click Add Money")
	public void user_click_add_money() throws InterruptedException {
	    try {
	        Thread.sleep(4000);
	        WebElement element = driver.findElement(
	                By.xpath("//div[@data-cell-id='d']//descendant::div[@aria-label='tab-content-btn_addmoney']"));
	        element.click();
	    } catch (Exception e) {
	        System.err.println("Error clicking add money: " + e.getMessage());
	    }
	}

	@When("User enter money in amount to add")
	public void user_enter_money_in_amount_to_add() throws InterruptedException {
	    try {
	        Thread.sleep(2000);
	        WebElement addMoneyFrame = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
	        driver.switchTo().frame(addMoneyFrame);

	        driver.findElement(By.xpath("//input[@placeholder='Enter Amount']")).click();

	        WebElement enterAmount = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']"));
	        enterAmount.clear();
	        Thread.sleep(1000);

	        enterAmount.sendKeys("50");

	        Thread.sleep(1000);

	        driver.findElement(By.xpath("//input[@id='deposit_amount']")).click();

	        Thread.sleep(4000);

	        driver.switchTo().defaultContent();

	        Set<String> windowHandles1 = driver.getWindowHandles();
	        ArrayList<String> li1 = new ArrayList<>(windowHandles1);
	        int size = li1.size();
	        System.out.println(size);
	        Thread.sleep(1000);

	        driver.switchTo().window(li1.get(1));
	        Thread.sleep(2000);

	        driver.close();

	        driver.switchTo().window(li1.get(0));

	        driver.switchTo().frame(0);

	        driver.findElement(By.xpath("//input[@id='deposit_amount']")).click();

	        driver.switchTo().defaultContent();

	        Thread.sleep(4000);
	    } catch (Exception e) {
	        System.err.println("Error entering money in amount to add: " + e.getMessage());
	    }
	}

	@When("User Choose Pay Using UPI")
	public void user_choose_pay_using_upi() throws InterruptedException {
	    try {
	        Thread.sleep(2000);
	        Set<String> windowHandles1 = driver.getWindowHandles();
	        ArrayList<String> li1 = new ArrayList<>(windowHandles1);
	        int size = li1.size();
	        System.out.println(size);

	        driver.switchTo().window(li1.get(1));

	        Thread.sleep(1000);

	        Thread.sleep(5000);
	    } catch (Exception e) {
	        System.err.println("Error choosing UPI payment method: " + e.getMessage());
	    }
	}

	@When("User Enter UPI\\/ID\\/Mobile Number and click pay now")
	public void user_enter_upi_id_mobile_number_and_click_pay_now() throws InterruptedException, AWTException {
	    try {
	        driver.switchTo().frame(0);

	        Robot robot = new Robot();

	        Thread.sleep(1000);

	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0, 500)");
	        js.executeScript("window.scrollBy(0, 500)");
	        js.executeScript("window.scrollBy(0, -500)");

	        WebElement netBanking = driver.findElement(By.xpath("//input[@placeholder='example@okhdfcbank']"));

	        netBanking.click();
	        Thread.sleep(1000);

	        WebElement UPI = driver.findElement(By.xpath("//input[@placeholder='example@okhdfcbank']"));

	        UPI.sendKeys("9585191834");
	        Thread.sleep(1000);

	        WebElement clickPayUsingUPI = driver.findElement(By.xpath("//button[text()='Verify and Pay']"));
	        clickPayUsingUPI.click();

	        Thread.sleep(3000);

	        Thread.sleep(30000);
	        WebElement rejectedMessage = driver.findElement(By.xpath("//div[text()='Payment could not be completed']"));

	        if (rejectedMessage.isDisplayed()) {
	            js.executeScript("arguments[0].style.border='2px solid yellow'", rejectedMessage);
	            System.err.println("Payment Declined");

	        } else {
	            js.executeScript("arguments[0].style.border='2px solid red'", rejectedMessage);
	            System.err.println("Payment SuccessFul");
	        }

	        driver.switchTo().parentFrame();

	        driver.switchTo().defaultContent();
	    } catch (Exception e) {
	        System.err.println("Error entering UPI ID and completing payment: " + e.getMessage());
	    }
	}

	@When("Navigate to home page")
	public void navigate_to_home_page() throws InterruptedException {
	    try {
	        driver.navigate().to("https://rocket.tradeplusonline.com/");
	        Thread.sleep(2000);
	    } catch (Exception e) {
	        System.err.println("Error navigating to home page: " + e.getMessage());
	    }
	}



}
