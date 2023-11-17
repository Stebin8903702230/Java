package com.Runner;

import org.junit.runner.RunWith;

import com.BaseMethods.BaseMethods;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features ="C:\\Users\\Public\\Jdk\\Cucumber\\src\\test\\java\\com\\featurefiles\\LimeFeature.feature",
								glue = "com.Step_Defntn",
								plugin= {"json:Folder/limelog.json", "html:F2/limelogn.html",
										"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class EmptyRunner {
	
}
