package com.OpenlyCRM.pages;

import com.OpenlyCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventPage extends HomePage{

    public EventPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "feed-cal-event-fromcal_3Jcl")
    public WebElement eventStartDateBox;

    @FindBy(id = "feed_cal_event_from_timecal_3Jcl")
    public WebElement eventStartTimeBox;

    @FindBy(id = "feed-cal-event-tocal_3Jcl")
    public WebElement eventEndDateBox;

    @FindBy(id = "feed_cal_event_to_timecal_3Jcl")
    public WebElement eventEndTimeBox;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;

}
