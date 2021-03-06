package TestCases;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class SearchByPeople extends Base {
	
	public AndroidDriver<AndroidElement> Login() throws InterruptedException, MalformedURLException
	{
		//Login Stage
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		TouchAction t = new TouchAction(driver);		
				
		//Locate Email TextBox:
		driver.findElement(By.xpath("(//android.widget.Button)")).click();
		WebElement EmailAddress = driver.findElementByXPath("//*[@text='Email address']");
		t.tap(tapOptions().withElement(element(EmailAddress))).perform();
						
		//type Email:
		Actions action = new Actions(driver);
		action.sendKeys(EmailAddress, "tarek.niazy2@gmail.com").perform();
						
		//Click next
		driver.findElementByXPath("//*[@content-desc='Next']").click();
						
		//Locate Password TextBox:
		WebElement Password = driver.findElementByXPath("//android.widget.EditText[@text='Password']");
		t.tap(tapOptions().withElement(element(Password))).perform();
						
		//type Password:
		action.sendKeys(Password,"Tarek1741999").perform();
				
		//Remove Keyboard:
		driver.hideKeyboard();
						
		//Click SignIn Button:
		driver.findElementByXPath("//*[@content-desc='Sign in']").click();
		Thread.sleep(3000);
		
		return driver;
		
	}
	
	@Test
	public void SearchingForValidAccount() throws MalformedURLException, InterruptedException
	{
		AndroidDriver<AndroidElement> driver = Login();
		Thread.sleep(18000);
		Actions action = new Actions(driver);
		
		//Click on Search Button:
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		//Click on EditTextBox:
		driver.findElementByXPath("//android.widget.EditText").click();
				
		//Click on People:
		driver.findElementByXPath("//*[contains(@content-desc,'People')]").click();
		
		//Click on EditTextBox:
		driver.findElementByXPath("//android.widget.EditText").click();
		
		//Type tarek:
		WebElement SearchBar = driver.findElementByXPath("//android.widget.EditText");
		action.sendKeys(SearchBar,"tarek").perform();
		
		//Click on Run:
		driver.findElementsByXPath("//android.widget.Button").get(3).click();
		
		//Follow Tarek:
		driver.findElementsByClassName("android.widget.Button").get(8).click();
		Thread.sleep(3000);
		
		Thread.sleep(3000);
		driver.quit();
	}

}
