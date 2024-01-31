package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_WebElement {
	public WebDriver driver2;
	
	
	public Login_WebElement(WebDriver driver2) {
			PageFactory.initElements(driver2, this);
	}

	@FindBy(xpath = "//span[text()='SHOP MEN']")						//span[text()='SHOP MEN']
	private WebElement ShopMen;
	
	@FindBy(id="kids_category")											//a[@id='kids_category']
	private WebElement kids_category;
	
	@FindBy(xpath = "/html/body/div[1]/div[4]/div/div[2]/div/div[2]/div[3]/div/div[1]/div[2]/a")		//*[@id="kids_category_expand"]/div/div[1]/div[2]/a
	private WebElement TShirt;
	
// Filter			//div[@class="p8 tab fs15 bgFB has-sub"]//div[text()='           color         ']
	
	@FindBy(xpath = "//div[@data-a=\"color\"]")											//input[@id="fltr-multi"]
	private WebElement color;
	
	@FindBy(xpath = "//label[@for='fltr-white']")						//label[@for='fltr-white'
	private WebElement colorChkBox;
	
	@FindBy(xpath = "//div[@class='p8 tab fs15 bgFB has-sub open']")		//div[@class='p8 tab fs15 bgFB has-sub open']
	private WebElement Size;
	
	@FindBy(xpath = "//label[@for='fltr-11-12__Y']")					//label[@for='fltr-11-12__Y']
	private WebElement Age;
	
	@FindBy(xpath = "//div[@data-a='brandid']")							//div[@data-a='brandid']
	private WebElement brand;
	
	@FindBy(xpath = "//div[@data-a='brandid']")							//label[@for="fltr-60819"]
	private WebElement brandname;
	
	@FindBy(id= "18425820")												// id="18425820"
	private WebElement productWhiteTshirt;
	
	@FindBy(id= "size_29592242")										// id="size_29592242"
	private WebElement ProductSize;
	
	@FindBy(xpath = "//div[@data-srcid='navdeskTShirts__000']")			//div[@data-srcid='navdeskTShirts__000']
	private WebElement AddToCart;
	
	@FindBy(xpath = "//a[text()='BUY NOW']")							//a[text()='BUY NOW']
	private WebElement BuyNowBtn;

	public WebElement getShopMen() {
		return ShopMen;
	}

	public WebElement getKids_category() {
		return kids_category;
	}

	public WebDriver getDriver2() {
		return driver2;
	}

	public WebElement getTShirt() {
		return TShirt;
	}

	public WebElement getColor() {
		return color;
	}

	public WebElement getSize() {
		return Size;
	}
	
	public WebElement getcolorChkBox() {
		return colorChkBox;
	}

	public WebElement getAge() {
		return Age;
	}

	public WebElement getBrand() {
		return brand;
	}

	public WebElement getBrandname() {
		return brandname;
	}

	public WebElement getProductWhiteTshirt() {
		return productWhiteTshirt;
	}

	public WebElement getProductSize() {
		return ProductSize;
	}

	public WebElement getAddToCart() {
		return AddToCart;
	}

	public WebElement getBuyNowBtn() {
		return BuyNowBtn;
	}

	
	
	
	
}