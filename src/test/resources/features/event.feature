# US04
Feature: Creating events, by clicking on Event tab, under Activity Stream

    #AC1: User should be able to add Event start and ending date and time, select "All day" and specify the time zone.

    #OPC-911: Verify today's date is default as Event start date and end date
  Scenario:
    Given user is at the home page
    When user clicks Event tab
    Then user should see today's date in the event start date box
    Then user should see today's date in the event end date box

  @wip
    #OPC-912: Verify user is able to add Event start and ending date and time (Positive Scenario)
    Scenario:
      Given user is at the home page
      When user clicks Event tab
      And user enters Event Start Date
      And user enters Event Start Time
      And user enters Event End Date
      And user enters Event End Time
      And user clicks Send button
      Then user should see the event in the Activity Stream

