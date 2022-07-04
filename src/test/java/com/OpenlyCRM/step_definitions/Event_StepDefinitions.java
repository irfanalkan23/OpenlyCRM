package com.OpenlyCRM.step_definitions;

import com.OpenlyCRM.pages.EventPage;
import com.OpenlyCRM.pages.HomePage;
import com.OpenlyCRM.pages.LoginPage;
import com.OpenlyCRM.utilities.BrowserUtils;
import com.OpenlyCRM.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    EventPage eventPage = new EventPage();

    LocalDate date = LocalDate.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    String currentDate = date.format(dateFormatter);

    LocalDateTime time = LocalDateTime.now();
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

    LocalDate tomorrow = LocalDate.now().plusDays(1);
    String tomorrowDate = tomorrow.format(dateFormatter);
//    LocalDate parsedDate = LocalDate.parse(text, formatter);

    @Given("user is at the home page")
    public void user_is_at_the_home_page() {
        loginPage.login();
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Portal"));
    }

    @When("user clicks Event tab")
    public void user_clicks_event_tab() {
        BrowserUtils.clickWithJS(homePage.eventTab);
    }

    @Then("user should see today's date in the event start date box")
    public void user_should_see_today_s_date_in_the_event_start_date_box() {
        String actualDate = readEventDateBox(eventPage.eventStartDateBox);
        Assert.assertEquals(actualDate, currentDate);
    }

    @Then("user should see today's date in the event end date box")
    public void user_should_see_today_s_date_in_the_event_end_date_box() {
        String actualDate = readEventDateBox(eventPage.eventEndDateBox);
        Assert.assertEquals(actualDate, currentDate);
    }



    @Given("user enters Event Start Date")
    public void user_enters_event_start_date() {
        eventPage.eventStartDateBox.clear();
        eventPage.eventStartDateBox.sendKeys(tomorrowDate);
    }
    @Given("user enters Event Start Time")
    public void user_enters_event_start_time() {
        String eventStartTime = time.plusHours(1).format(timeFormatter);
        eventPage.eventStartTimeBox.clear();
        eventPage.eventStartTimeBox.sendKeys(eventStartTime);
    }
    @Given("user enters Event End Date")
    public void user_enters_event_end_date() {

    }
    @Given("user enters Event End Time")
    public void user_enters_event_end_time() {

    }
    @Given("user clicks Send button")
    public void user_clicks_send_button() {

    }
    @Then("user should see the event in the Activity Stream")
    public void user_should_see_the_event_in_the_activity_stream() {

    }



    public String readEventDateBox(WebElement eventDateBox) {
        BrowserUtils.waitForClickablility(eventDateBox, 5);
        return eventDateBox.getAttribute("value");
    }

}
