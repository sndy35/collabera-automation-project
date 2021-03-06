package com.collabera.android.pages;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.collabera.android.utils.AndroidActions;
import com.collabera.reporting.Logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends AndroidActions{
	private AppiumDriver driver;
    private WebDriverWait wait;
    private Logger logger;
    
    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/sign_in_button")
    private AndroidElement skipSignInButton;

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
    private AndroidElement searchBar;
    
    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/action_bar_cart_count")
    private AndroidElement cartButton;
 
    /*
     * Constructor to initialize the HomeScreen with driver
     */
    
    public HomeScreen(AppiumDriver driver, Logger logger){
    		super(driver,logger);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        this.logger = logger;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    /*
     * Searches for the item passed as argument
     * @param searchText- Item to the searched in the search bar 
     * @return boolean indicating if the item is searched successfully
     */
    public boolean searchItem(String searchText){
    		logger.info("searchItem: Searching for item "+searchText);
    		return enterText(searchBar, searchText);
    		
    }
    
    /*
     * This functions verifies if the cart is empty
     * @return String current value of the cart in string format
     */
    public String getCartValue() {
	    	logger.info("getCartValue: Getting the cart value");
	    if(verifyElementExists(cartButton)) {
	    		return cartButton.getText();
	    } else {
	    		logger.info("getCartValue: Cart is not found");
	    }
	    
	    	return null;
	    	
	}
    
}
