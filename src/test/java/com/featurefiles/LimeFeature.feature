Feature: Limeroad
Scenario: Shop men
Given User launch the browser "chrome"
When User launch the url "https://www.limeroad.com/"
And User clicks on shop men
And User mouseHover Kids
And User mouseHover Boys Tshirt
And User clicks filter
And User clicks the product
And User clicks the size 
Then User close the browser