import java.util.*;

public class SnapCracklePopMain{

   public static void main(String[] args){
      
      // The scanner we will be using to accept user input
      Scanner scan = new Scanner(System.in);
     /*  Initializing snap, crackle, pop, and round to invalid values to cause them
      *  to enter their respective User Input loops.
      */
      int snap = -1;
      int crackle = -1;
      int pop = -1;
      int rounds = -1;
      
      // Our SnapCracklePop object
      SnapCracklePop scp;
      
      // Capture user input for snap, while also ensuring correctness
      System.out.println("Enter an integer for your snap number.");
      while(snap < 0){
         System.out.println("Please enter a number greater than zero:");
         try{
            snap = Integer.parseInt(scan.nextLine());
         } catch (Exception e) {
            System.out.println("That is not a valid number. Please enter an integer greater than zero.");
         }
      }
      
      // Capture user input for crackle, while also ensuring correctness
      System.out.println("Enter an integer for your crackle number.");
      while(crackle < 0){
         System.out.println("Please enter a number greater than zero:");
         try{
            crackle = Integer.parseInt(scan.nextLine());
         } catch(Exception e) {
            System.out.println("That is not a valid number. Please enter an integer greater than zero.");
         }
      }
      
      // Capture user input for pop, while also ensuring correctness
      System.out.println("Enter an integer for your pop number.");
      while(pop < 0){
         System.out.println("Please enter a number greater than zero:");
         try{
            pop = Integer.parseInt(scan.nextLine());
         } catch(Exception e) {
            System.out.println("That is not a valid number. Please enter an integer greater than zero.");
         }
      }
      
      // Initializing our SnapCracklePop object with the values we just obtained from the user
      scp = new SnapCracklePop(snap, crackle, pop);
      
      // Capture user input for rounds, while also ensuring correctness 
      System.out.println("How many rounds would you like to play?");
      while(rounds < 0){
         System.out.println("Please enter a number greater than zero:");
         try{
            rounds = Integer.parseInt(scan.nextLine());
         } catch(Exception e) {
            System.out.println("That is not a valid number. Please enter an integer greater than zero.");
         }
      }
      
      // Printing results
      System.out.println("Results:");
      System.out.println(scp.playGame(rounds));
   
   }

}