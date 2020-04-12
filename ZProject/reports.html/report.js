$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/ZProjectFolder/project.feature");
formatter.feature({
  "name": "practiceautomation testing",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Practiceautomation"
    }
  ]
});
formatter.scenario({
  "name": "Deleting item from cart",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Practiceautomation"
    },
    {
      "name": "@TC_Deletecartitem"
    }
  ]
});
formatter.step({
  "name": "User on home page6",
  "keyword": "Given "
});
formatter.match({
  "location": "com.stepdefinitions.Test_Myaccount_Deletecartitem.user_on_home_page6()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select the shop for a product and add to cart",
  "keyword": "And "
});
formatter.match({
  "location": "com.stepdefinitions.Test_Myaccount_Deletecartitem.select_the_shop_for_a_product_and_add_to_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clicks on view basket",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Test_Myaccount_Deletecartitem.clicks_on_view_basket()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "delete the unwanted item",
  "keyword": "And "
});
formatter.match({
  "location": "com.stepdefinitions.Test_Myaccount_Deletecartitem.delete_the_unwanted_item()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "deleted message appear on screen",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepdefinitions.Test_Myaccount_Deletecartitem.deleted_message_appear_on_screen()"
});
formatter.result({
  "status": "passed"
});
});