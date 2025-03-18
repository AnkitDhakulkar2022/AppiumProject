package MobileAutomation.PageObject.Android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import MobileAutomation.Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions {

	AndroidDriver driver;

	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productprice;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement TotalSumofTwoProduct;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement termsButton;

	@AndroidFindBy(id = "android:id/button1")
	private WebElement acceptbutton;

	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement CheckBox;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement Proceed;
	
	public List<WebElement>getProductList()
	{
		return productprice;
	}

	public double getProductSum() {

		int count = productprice.size();
		double totalsum = 0;
		for (int i = 0; i < count; i++) {
			String amountofProduct = productprice.get(i).getText();
			// amountofProduct.substring(1); // in our case the price is $160.23 so we need
			// to remove the $ symbole to sum of two price thats whay we use substring to
			// start from 1st index
			// Double price=Double.parseDouble(amountofProduct.substring(1)); // convert
			// String into double
			Double price = getFormatedAmount(amountofProduct);
			totalsum = totalsum + price; // 160.97+ 120.0 =280.97
			System.out.println("Totalamount is" + totalsum);

		}
		return totalsum;

	}
	
	public Double getTotalAmountDisplayed()
	{
		return getFormatedAmount(TotalSumofTwoProduct.getText());
	}
	
	public void acceptTermsAndCondition()
	{
		LongPressElement(termsButton);
		acceptbutton.click();
	}

	public void SubmitOrder()
	{
		CheckBox.click();
		Proceed.click();
	}
}
