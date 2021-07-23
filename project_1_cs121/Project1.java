/* Project 1: Intro to Programming Projects.
 *
 * In this project, you will gain experience downloading, extracting and opening a project
 * in jGrasp. Then, you will make some changes to a java program, compile it, and run it.
 * You will check that the output is printed correctly.
 * Finally, you will create a zip file and upload it to Gradescope to verify that 
 * your project is correct in the autograder. 
 *
 * There are 5 steps to be completed in this source code file for this project.
 */
public class Project1{

   public static void main(String[] args){ 
     /*  Before you begin, a note about comments in Java:
         Comments are ignored by the compiler. They are important for documenting code.
         Comments help other programmers read and understand what your code is doing. 
         You do not comment everything, only the important parts of your program. 
         There are two ways to make comments in Java:
       */
   
      /* Comments for multiple lines starts with a forward slash and an asterisk and ends 
         with an asterisk and a forward slash. In the first coment at the top of this file, 
         the asterisks in between are decorative.
      */
      // Double slashes make a comment for a single line.
      
      /************** Tasks to complete ******************************/
      
      /* Task 1: Turn on line numbers in one of the following ways:
         1- Press ctrl+L on Windows or cmd+L on Mac
         OR
         2- Click the View menu in jGrasp and check the Line Numbers box.
      
         The statement below declares a variable named turnedOnLineNums of data type boolean,
         and assigns the value false to it. Boolean variables can be either true or false.
         After you have turned on line numbers in jGrasp, change the assignment statement
         so that the value of turnedOnLineNums is true.
      */
      boolean turnedOnLineNums = true;
      
      /* Task 2: Enter your class level. This is an integer data type, or int in Java. 
         Change the right hand side of the assignment statement below to represent 
         your class level: 1- first year, 2- second year, 3- third year, 4- fourth year.
      */ 
      int classLevel = 1;
      
      /* Task 3: Gradescope is where you will submit this and all future programming projects in this class. 
         Replace this value with the URL (the web address) of gradescope. To get this, point your browser to the gradescope 
         web site and copy the url in the address bar at the top. You can also type "gradescope" into
         a search engine and the url will appear.
      */
      String gradescopeUrl = "https://www.gradescope.com";
      
     /*  Task 4: How long did it take you to complete this assignent? The double data type represents 
         decimal numbers in Java. You can use decimal numbers to represent fractions of an hour. 
         For example, 1.5 represents 1 hour and 30 minutes.   
      */
      double numHoursToComplete = 0.125;
      
      System.out.println("I have turned on line numbers: " + turnedOnLineNums);
      System.out.println("My class level: " + classLevel);
      System.out.println("The website URL for where I submit my assignments is: " + gradescopeUrl);
      System.out.println("This assignment took me " + numHoursToComplete + " hours to complete."); 
     
      /* Task 5: Add your own output below! Add a line that prints on one line:
         "My name is: [your name here]" 
         to the console. For example, if my name is Grace Hopper, the code would print:
         
         My name is: Grace Hopper
         
         Write your print statement below.
      */
      System.out.println("My name is: Nhan Lai");
   }
}