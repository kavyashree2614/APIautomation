Feature: Verify Bitcoin API details

  Scenario: Validate Bitcoin API response
    Given I send a GET request to "https://api.coingecko.com/api/v3/coins/bitcoin"
    Then Verify the response contains 3 BPIs: USD, GBP, EUR
    And Verify each cryptocurrency has market cap and total volume
    And Verify price change percentage over the last 24 hours is present
    And Verify homepage URL is not empty