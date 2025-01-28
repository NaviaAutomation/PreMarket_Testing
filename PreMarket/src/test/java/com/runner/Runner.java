package com.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.baseclass.BaseClass;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\Venkateshwaran\\git\\repository2\\PreMarket\\src\\test\\java\\com\\feature\\DailyEightFortyTesting.feature"
,glue ={"com.stepdefinition"} , 
// tags="@tools2",
plugin = {"pretty",
		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		  "html:reports/HtmlReports1/report.html",
         "json:reports/JSONReports/report.json",
         "junit:reports/JUnitReports/report.xml"})
public class Runner {
	
	public static WebDriver driver;

	
	@BeforeClass
	public static void browserLaunch(){
		
		driver=BaseClass.launchBroswer("chrome");
	}
	

}   

