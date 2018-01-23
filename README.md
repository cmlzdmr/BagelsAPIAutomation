#BagelsAPIAutomation
Hi Coffee Meets Bagel Team,

   Thanks for this opportunity for letting me prove my API testing knowledge.
I have completed the assessment and as you mentioned I have several test cases failed.    
I think my test suite has good coverage to ensure “Bagels” API is working as defined in the requirements. 
In order to run this project, you need to install Maven and JAVA. Import as a maven project and run with JUnit. 
I have covered some positive and negative scenarios for both GET and POST methods. 
You can find all data and results inside the Documents folder in “TestCases” excel file which consists of two sheets (GET and POST).
I have developed 5 Test cases for each method(GET and POST) using JAVA. 
If I had more time, I would have developed Data Driven Framework for POST method and test all the test cases.
    Here is the some of the bugs that I found:
 GET
- Gender filter is not working 
- Max_age filter is not inclusive 
- Offset parameter is not working without limit parameter
- Distance filter is not working properly (not updating results depending on the distance)
POST
-	Name field accepts numbers and special characters (depends on requirement)
-	Age field accepts below and above boundaries (negative value also)
-	Location accepts name parameter empty. 

Please do not hesitate if you have any questions.

Cemal Ozdemir 








