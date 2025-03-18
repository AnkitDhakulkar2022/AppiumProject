package MobileAutomation.PageObject.Android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import MobileAutomation.Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalog extends AndroidActions {
	
	
AndroidDriver driver;
	
@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
private List<WebElement> addToCard;

@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
private WebElement cart;

	public ProductCatalog(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	public void addItemtoCardByIndex(int Index)
	{
		addToCard.get(0).click();
	}

	public void goToCartPage() throws InterruptedException
	{
		cart.click();
		Thread.sleep(2000);
	}
	
}
