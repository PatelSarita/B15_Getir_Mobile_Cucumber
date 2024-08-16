# Go to Getir app and login
  # Verify login is successful
  # Go to basket
  # Verify that it is empty
  # Go to items list and print all list and verify that size is 12
  # Go to second category and add two different items
  # Go to basket again
  # Verify total amount

Feature: Getir E2E Test

  @wip
  Scenario: Getir E2E Test on Basket
    When The user opens the getir app and enters "hello@getir.com" and "hello"
    Then The user logins successfully
    When The user clicks on basket button
    Then The user verifies that the basket is empty and able to see "There is no result"
    And The user is able to see all item list on page and verifies the size is 14
    When The user clicks on category which is "Atıştırmalık"
    And If needed the user scrolls down and adds 2 items
      | Ürün 9  |
      | Ürün 13 |
    And The user clicks on basket button
    Then The user verifies that the "Total Amount : 42 ₺"