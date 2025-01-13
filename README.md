All the assignment task(UI and API) are present under demo.feature file. This file can be found in src/test/java/Feature/demo.feature

Demo feature has below steps:
Feature: Demo test

  @demoTest
  Scenario: Demo test
     * user navigate to "https://www.ebay.com"
     * user search "book" on search box on "Ebay" home page
     * user clicks on first product on "Product List" page
    * user click on "Add to Cart" button
    * user verify product count is "1" on "Prodcut Details" page
    * user make a get call to "/v1/bpi/currentprice.json"
    * user verify "bpi" has "3" objects
    * user verify value is "British Pound Sterling" at json path "$.bpi.GBP.description"
