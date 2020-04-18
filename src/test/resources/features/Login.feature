@login
Feature: Login
  As user, I want to be able to login with username and password
    # Agile story

  # Test Method = Test Case = Scenario
  # Test + DataProvider = Scenario Outline + Examples table

  Background: open login page
    Given user is on the login page

  @sales_manager
  Scenario: Login as sales manager and verify that tile is Dashboard
    When user logs in as a sales manager
    Then user should verify that title is Dashboard

  @store_manager
  Scenario: Login as store manager and verify that title is Dashboard
    When user logs in as a store manager
    Then user should verify that title is Dashboard

  @driver @dashboard
  Scenario: Login as a driver and verify that title is Dashboard
    When user logs in as a driver
    Then user should verify that title is Dashboard

    @login_with_params
    Scenario: Login with parameters
      When user enters "salesmanager115" username and "UserUser123" password
      Then user should verify that title is Dashboard
