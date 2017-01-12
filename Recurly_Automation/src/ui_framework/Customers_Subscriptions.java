/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui_framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author J. Drill
 */
public class Customers_Subscriptions {
    WebDriver driver = null;
    
    // Page Objects
    By Page_Title = By.className("Page-title");
    
    // Constructor
    public Customers_Subscriptions(WebDriver driver){
        this.driver = driver;
    }
    
    public String Get_Page_Title(){
        return driver.findElement(Page_Title).getText();
    }
}
