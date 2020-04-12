@Practiceautomation
Feature: practiceautomation testing
@TC_login
Scenario: Sucessful Login with valid credentials
Given User on home page
And User lands on login page
When User enters valid username and password
And User clicks on login button
Then User lands on Weclome page

@TC_Billing
Scenario Outline: Saving user's Billing Address
Given User on home page1
And User enters to login page
When User enters details and clicks login button
And User clicks on Address
And User click on edit option
Then Start entering details "<firstname>" "<lastname>" "<companyname>" "<email>" "<phone>" "<address1>" "<address2>" "<city>"
And Click on savechanges
Then User get saving notification
Examples:
| firstname | lastname | companyname |        email           |   phone    | address1 | address2 | city    | 
| affu      | lucy     |  webtoon    | afreen54321@gmail.com  | 9876543210 | chivstrt | railpet  | guntur  |  

@TC_AddToCart
Scenario: Adding an item to cart
Given User on home page2
When User searches the product
When User select the product
And User select the filter
Then User choose the produc t
And Clicks on add to basket
Then User lands on cart page


@TC_Accountdetails
Scenario Outline: Login and adding user's Accountdetails  
Given User on home page3   
And User on login page   
When User clicks login button1   
And User clicks on Accountdetails1  
And User enters "<currentpassword>" and "<newpassword>" and "<confirmpassword>"   
Then User lands on password changed successfully
Examples:
|  currentpassword  |  newpassword |  confirmpassword   |
|  affu!@#123       |  affu!@#123  |  affu!@#123        |

@TC_Demofiledownload
Scenario: To Download a file
Given User on home page4
When User clicks on Demosite
And User clicks on Download file
And User enters the data
And User generates the file
And User downloads the file
Then File is downloaded

@TC_Placingorder
Scenario: User placingorder from cart
Given Enters the home page
When User login with valid credentials
Then User clicks on shop
Then User select an item to basket and view the product
And Clicks on proceed 
And Moveon to place order
Then User lands on other page which shows order is successfull

@TC_Deletecartitem
Scenario: Deleting item from cart
Given User on home page6
And select the shop for a product and add to cart
Then clicks on view basket
And delete the unwanted item
Then deleted message appear on screen

@TC_Testingvideo
Scenario: To play a sample video about the site
Given User lands on home page5
And clicks on demo site
And select the vimeo 
Then Play the obtained video

