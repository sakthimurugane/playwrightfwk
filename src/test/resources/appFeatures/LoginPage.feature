 Feature: Login page feature
 
 Scenario: Login with valid credentials
 Given user is on home page with url "https://www.rijksmuseum.nl/en"
 And user accept cookies consent
 When user clicks on Login link
 And user enters username "kalaiarasishiva@gmail.com"
 And user enters password "Suresh#4"
 And user clicks on Login button
 Then wait for 5 seconds to load avatar card
 And logged in avathar card should be "kA"