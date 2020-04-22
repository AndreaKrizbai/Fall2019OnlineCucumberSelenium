package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPageBase{

    @FindBy (id="prependedInput")
    private WebElement username;
    //public WebElement username2 = Driver.getDriver().findElement(By.id("prependedInput"));

    @FindBy (id = "prependedInput2")
    private WebElement password;

    @FindBy (id = "_submit")
    private WebElement login;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPassword;

    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMessage;

    //public LoginPage() {
      //  PageFactory.initElements(Driver.getDriver(), this); //LoginPage.class);
   // }

    public String getWarningMessageText(){
        return warningMessage.getText();
    }

    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(2);
    }

    public void login(){
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(2);
    }

    /**
     * this method stands for login based on user type
     * For example: if parameter is equals to driver, user will login as a driver
     * If role parameter is not correct, method will throw exception
     * @param role - driver, sales manager or store manager
     */
    public void login(String role){
        String userName = "";
        if (role.equalsIgnoreCase("driver")){
            userName = "user15";
        }else if (role.equalsIgnoreCase("sales manager")){
            userName = "salesmanager110";
        }else if (role.equalsIgnoreCase("store manager")){
            userName = "storemanager85";
        }else {
            throw new RuntimeException("Invalid role!");
        }
        System.out.println("Login as "+role);
        login(userName, "UserUser123");
    }

}
