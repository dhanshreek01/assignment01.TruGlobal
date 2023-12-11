#Author: kdhanshree01@gmail.com
@Assignment
Feature: Test amazon site

 @iphoneTest
  Scenario: Search and select the Iphone 

    Given User navigate to website
    When User searches for "iPhone"
    And User selects an iPhone from the search results
    And User goes to the product details page And adds the product to the cart
    Then User verifies the product, stores the price And procced to checkout
    And register the user

  @FilterTest
  Scenario: Phone Search and Filter Validation
  
    Given User navigate to website
    When User searches for "Mobile Phones"
    And User applies filters for "brand", "memory" and "price"
    Then User validates the filtered phone list