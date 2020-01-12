Feature: Log into Trello and create the board
  As a user, I want to Login into Trello

  Scenario : Log into Trello
    Given User Navigates to Trello Login page
    And Enters <username> and <password>
    Then user is Logged in successfully


  Scenario : User creates the board

    Given User Navigates to Trello Login page
    And Enters <username> and <password>
    And creates the boadrd
    Then the board is created successfully