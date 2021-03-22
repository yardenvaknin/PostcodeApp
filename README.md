# PostcodeApp
A Java program that allows a user to query and show details for a given UK postcode.
Using the free REST API :  http://postcodes.io

## Postcode.java -
This class represents postcode object and has a get method
and a method that converts the postcode to be without space character.

## Validation.java -
    This class represents validation of the input of the postcode application, it has a method isValidPostcode
    that receives a Postcode object and ck if the postcode is a valid uk postcode.
## GetRequestHandler.java -
    This class represent the get request to the "postcode.io" REST API.
    It receives the postcode object and the name of the request we want to send to the REST API.
    It creates a appropriate urls to send in the request.
    Its main method is sendGetRequest.
    It's main method is sendGetRequest method.

## ResultHandler.java -
    This class represent the data that we get back from the get request that we send with the GetRequestHandler,
    I represent the data in JASON object.
    ResultHandler receives the output from the GetRequestHandler that called to the get request.
    The ResultHandler has print method that prints the data by the request we send.

## PostCodeApp.java -
    This class is responsible for the whole flow of the application it receives the postcode and the requestName and it holds the
    GetRequestHandler and ResultHandler Objects and calls to the relevant methods in them.
    Its main method is runApp();

## The project containing also a test folder with unit tests:

   ##### GetRequestHandlerTest.java -
   test GetRequestHandler class.
   ##### PostcodeTest.java - 
   test Postcode class.
   ##### ResultHandlerTest.java - 
   test ResultHandler class.
   ##### ValidationTest.java - 
   test Validation class.


# Output example:




![image](https://user-images.githubusercontent.com/24391093/111955073-b302f900-8af1-11eb-9d1a-663149a9c6d1.png)

