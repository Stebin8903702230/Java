package com.Step_Defntn;

import com.BaseMethods.BaseMethods;
import com.POM.Login_WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination extends BaseMethods{
	
	public static  Login_WebElement WebElemnt;

	@Given("User launch the browser {string}")
	public void user_launch_the_browser(String string) {
	   launch_Browser(string);
	}

	@When("User launch the url {string}")
	public void user_launch_the_url(String string) {
	   getUrl(string);
	}

	@When("User clicks on shop men")
	public void user_clicks_on_shop_men() throws InterruptedException {
		Thread.sleep(2000);
		WebElemnt = new Login_WebElement(getDriver());
		Click(WebElemnt.getShopMen());
		Thread.sleep(2000);
	}

	@When("User mouseHover Kids")
	public void user_mouse_hover_kids() {
			mouseHover(WebElemnt.getKids_category());
	}

	@When("User mouseHover Boys Tshirt")
	public void user_mouse_hover_boys_tshirt() throws InterruptedException {
		Thread.sleep(2000);
		mouseHover(WebElemnt.getTShirt());
			MouseClick(WebElemnt.getTShirt());
			Thread.sleep(2000);
	}

	@When("User clicks filter")
	public void user_clicks_filter() throws InterruptedException {
		Click(WebElemnt.getColor());
		Thread.sleep(1000);
		Click(WebElemnt.getcolorChkBox());
		Thread.sleep(1000);
		Click(WebElemnt.getColor());
		Thread.sleep(5000);
		}

	@When("User clicks the product")
	public void user_clicks_the_product() {
		Click(WebElemnt.getProductWhiteTshirt());
	}

	@When("User clicks the size")
	public void user_clicks_the_size() throws InterruptedException {
		Thread.sleep(5000);
		Click(WebElemnt.getProductSize());
	}

	@Then("User close the browser")
	public void user_close_the_browser() {
		Quit();
	}

}
