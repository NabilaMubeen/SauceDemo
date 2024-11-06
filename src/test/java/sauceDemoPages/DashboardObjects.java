package sauceDemoPages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DashboardObjects {
	
	WebDriver driver = null;
	List<Double> prices;
	By filterDropDown = By.className("product_sort_container");
	By price = By.className("inventory_item_price");
	By AddToCartBtn = By.id("add-to-cart-sauce-labs-onesie");
	By AddToCartBtn1 = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
	By shoppingcart = By.className("shopping_cart_link");
	By cartItem = By.className("cart_item");

	public DashboardObjects(WebDriver driver) {

		this.driver = driver;
	}
	
	public void FilterDropDown() {
		
		WebElement dropdown = driver.findElement(filterDropDown);
		Select select = new Select(dropdown);
		select.selectByValue("lohi");
		List<WebElement>priceElements = driver.findElements(price);
		prices = new ArrayList<>();
		
		//Extract the price remove the dollar sign and convert it into double to use it further
		for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", ""); // Adjust based on format
            prices.add(Double.parseDouble(priceText));
        }
		
		//Comparing the original list and the sorted list
		List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);
        Assert.assertEquals(prices, sortedPrices, "Items are not sorted from low to high");
	}
	
	public void AddToCart() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(AddToCartBtn).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(AddToCartBtn1).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(shoppingcart).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Counting the items in the cart
		List<WebElement> cartItems = driver.findElements(cartItem);
		Assert.assertEquals(cartItems.size(), 2, "Cart does not contain exactly 2 items");
		
		//Verify the total price
		double expectedTotalPrice = prices.get(0) + prices.get(1); // Sum of the lowest 2 prices
        Assert.assertEquals(17.98, expectedTotalPrice, "Total price in cart is incorrect");
		
	}
	

}

