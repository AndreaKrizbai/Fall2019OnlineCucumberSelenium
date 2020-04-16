Feature: Login
  As user, I want to be able to login with username and password
    # Agile story

  # Test Method = Test Case = Scenario
  # Test + DataProvider = Scenario Outline + Examples table
  @sales_manager
  Scenario: Login as sales manager and verify that tile is Dashboard
    Given user is on the login page
    When user logs in as a sales manager
    Then user should verify that title is Dashboard

  @store_manager
  Scenario: Login as store manager and verify that title is Dashboard
    Given user is on the login page
    When user logs in as a store manager
    Then user should verify that title is Dashboard

  @driver @dashboard
  Scenario: Login as a driver and verify that title is Dashboard
    Given user is on the login page
    When user logs in as a driver
    Then user should verify that title is Dashboard
