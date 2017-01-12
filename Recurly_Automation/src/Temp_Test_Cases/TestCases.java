/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temp_Test_Cases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import ui_framework.*;

/**
 *
 * @author J. Drill
 */
public class TestCases {
    
    public static void main(String[] args) {
        String privateUsername = "";
        String privatePassword = "";
        
        // Stored my username and pass in the private.properties file
        // so it does not get pushed to Github
        try {
            Properties props = new Properties();
            InputStream input = new FileInputStream("nbproject\\private\\private.properties");
            props.load(input);
            privateUsername = props.getProperty("login.username");
            privatePassword = props.getProperty("login.password");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestCases.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestCases.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Chrome
        Browser browser = new Browser();
        WebDriver driver = browser.Get_Driver(Browser.Browser_Type.CHROME);
        browser.Window_Maximize(driver);
        browser.Set_Implicit_Wait(driver, 5);
        browser.Set_Page_Timeout(driver, 5);
        
        driver.get("https://app.recurly.com/login");
        Login login = new Login(driver);
        login.loginUser(privateUsername, privatePassword);
        login = null;
        
        Menus menu = new Menus(driver);
        Customers_Accounts accounts = menu.Nav_Customers_Accounts();
        String acct_stat_all = accounts.Get_Account_Status(Customers_Accounts.Account_Status_Types.All);
        String page_title = accounts.Get_Page_Title();
        
        Customers_Subscriptions subscriptions = menu.Nav_Customers_Subscriptions();
        Customers_Invoices invoices = menu.Nav_Customers_Invoices();
        Customers_Transactions transactions = menu.Nav_Customers_Transactions();
        menu.Nav_LogOut();
        menu = null;
        
        driver.close();
        browser.Clear_Driver();
        
        //EDGE
        //driver = browser.Get_Driver(Browser.Browser_Type.EDGE);
        //browser.Window_Maximize(driver);
        //browser.Set_Implicit_Wait(driver, 5);
        //browser.Set_Page_Timeout(driver, 5);
        
        //driver.close();
        //browser.Clear_Driver();
    }
    
}
