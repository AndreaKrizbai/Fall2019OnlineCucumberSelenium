package com.vytrack.pages.activities;

import com.vytrack.pages.AbstractPageBase;
import com.vytrack.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CalendarEventsPage extends AbstractPageBase {

    @FindBy (css = "[title='Create Calendar event']")
    private WebElement createCalendarEvent;

    @FindBy(className = "select2-chosen")
    private WebElement owner;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    private WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    private WebElement endTime;

    @FindBy(className = "grid-header-cell__label")
    private List<WebElement> columnNames;

    @FindBy(css = "iframe[id^='oro_calendar_event_form_description-uid']")
    private WebElement descriptionFrame;

    @FindBy(css = "[id^='oro_calendar_event_form_title-uid']")
    private WebElement title;

    @FindBy(id = "tinymce")
    private WebElement descriptionTextArea;

    @FindBy(xpath = "(//div[@class='control-label'])[1]")
    private WebElement generalInfoTitle;

    @FindBy(xpath = "//label[text()='Description']/following-sibling::div//div")
    private WebElement generalInfoDescription;

    @FindBy(xpath = "//*[contains(text(),'View per page:')]/following-sibling::*//a")
    private List<WebElement> viewPerPageElements;

    @FindBy(css = "button[class*='btn dropdown-toggle']")
    private WebElement viewPerPageToggle;

    public List<String> getViewPerPageOptions() {
        BrowserUtils.waitForPageToLoad(25);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Create Calendar event']")));
        viewPerPageToggle.click();
        BrowserUtils.wait(2);
        return BrowserUtils.getTextFromWebElements(viewPerPageElements);
    }

    public void enterCalendarEventTitle(String titleValue) {
        BrowserUtils.waitForPageToLoad(25);
        wait.until(ExpectedConditions.visibilityOf(title)).sendKeys(titleValue);
        wait.until(ExpectedConditions.attributeToBe(title, "value", titleValue));
    }
    public void enterCalendarEventDescription(String description) {
        //wait until frame is available and switch to it
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionFrame));
        descriptionTextArea.sendKeys(description);
        wait.until(ExpectedConditions.textToBePresentInElement(descriptionTextArea, description));
        driver.switchTo().defaultContent();//exit from the frame
    }

    public String getGeneralInfoTitleText(){
        BrowserUtils.waitForPageToLoad(25);
        return generalInfoTitle.getText();
    }

    public String getGeneralInfoDescriptionText(){
        BrowserUtils.waitForPageToLoad(25);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Description']/following-sibling::div//div")));
        return generalInfoDescription.getText();
    }
//####################################################################

    public List<String>getColumnNames(){
        BrowserUtils.waitForPageToLoad(25);
        return BrowserUtils.getTextFromWebElements(columnNames);
    }

    public String getOwnerName(){
        BrowserUtils.waitForPageToLoad(25);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("select2-chosen")));
        wait.until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();
    }

    public void clickToCreateCalendarEvent(){
        BrowserUtils.waitForPageToLoad(25);
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();
        BrowserUtils.waitForPageToLoad(25);
    }

    public String getStartDate(){
        BrowserUtils.waitForPageToLoad(25);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        //BrowserUtils.scrollTo(startDate);
        return startDate.getAttribute("value");
    }

    public String getStartTime(){
        BrowserUtils.waitForPageToLoad(25);
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return startTime.getAttribute(("value"));
    }

    public String getEndTime(){
        BrowserUtils.waitForPageToLoad(25);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return endTime.getAttribute(("value"));
    }

}
