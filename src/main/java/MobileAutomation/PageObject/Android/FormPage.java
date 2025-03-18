package MobileAutomation.PageObject.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import MobileAutomation.Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions {
	
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	//	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("xyzz");

	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement namefield;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement SelectFemalegender;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement SelectMalegender;
	
	//driver.findElement(By.id("android:id/text1")).click();
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement CountrySelection;
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement ShopButton;
	
	
	
	public void setNameField(String name)
	{
		namefield.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setGender(String gender)
	{
		if(gender.contains("female"))
			SelectFemalegender.click();
		else
			SelectMalegender.click();
	}
	
	public void setCountrySelection(String countryName)
	{
		
		CountrySelection.click();
		scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
	}
	
	public void submitbutton()
	{
		ShopButton.click();
	}
}
