//TODOa complete this javadoc comment
/**
* [A class to execute a game of "Snap, Crackle and Pop"]
* @author [Nhan Lai]
* @version 1.0
*/

//TODO1: declare the SnapCracklePop class
public class SnapCracklePop{ 
   //TODOb Complete Comments
   /**
   * [Private variables "snap", "crackle" and "pop" of type int are used to hold the values Snap, Crackle and Pop that are used in the game]
   */
   
   //TODO2 Declare private instance variables 
   //to store Snap, Crackle, and Pop values
   private int snap;
   private int crackle;
   private int pop; 
   
   //TODOc complete comments
   /**
   * Assign s to Snap, c to Crackle, p to Pop
   * @param s the value of Snap
   * @param c the value of Crackle
   * @param p the value of Pop
   */
    
   /*  The constructor takes in three ints,
   *  which must be assigned to their instance variables and initialized.
   */
   	
   //TODO3 Write the constructor
   public SnapCracklePop(int s,int c,int p) {
	   snap = s;
	   crackle = c;
	   pop = p;
   }
   
   //TODOe complete comments
   /**
   * Execute a single round of "Snap, Crackle and Pop"
   * @param round Current round of play
   * @return Result for this round
   */ 
     
   /* playRound() is a helper method for playGame(). 
   *  It takes an int parameter representing the 
   *  current round of play, and returns the 
   *  String result for that specific round only.
   */
   
   //TODO4 implement the playRound method 
   private String playRound(int round) {
	   String result = "";
	   if (round%snap == 0) {
		   result += "snap";
	   }
	   if (round%crackle == 0) {
		   result += "crackle";
	   }	  
	   if (round%pop == 0) {
		   result += "pop";
	   }
	   if (result == "") {
		   result = result + round;
	   } 
	   return result;
   }
   
   //TODOd complete comments
   /**
   * Execute a whole game of play, implementing the playRound() method.
   * @param rounds Total number of rounds
   * @return All the results of rounds played
   */ 
   
   /* playGame() takes a single parameter representing the rounds and returns
   *  a String representing the result of the entire game. The helper method
   *  playRound() may be useful here, so you may want to complete it first.
   */
   
   //TODO5 implement the playGame method
   public String playGame(int rounds) {
	   String results = "";
	   for (int i = 1; i <= rounds; i++) {
		   results += ("Round " + i + ": " + playRound(i)+"\n");
	   }
	   return results; 
   }
      //Loop through the rounds of the game
         //call playRound to handle the specific round
      //return the total aggregated game results
   
   //TODOf complete comments
   /**
   * Get the value of Snap
   * @return The value of Snap
   */ 
   
   //TODO6 implement the getSnap method
   public int getSnap() {
	   return snap;
   }
   //TODOg complete comments
   /**
   * Get the value of Crackle
   * @return The value of Crackle
   */
   
   //TODO7 implement the getCrackle method  
   public int getCrackle() {
	   return crackle;
   }
   //TODOh complete comments
   /**
   * Get the value of Pop
   * @return The value of Pop
   */ 
     
   //TODO8 implement the getPop method
   public int getPop() {
	   return pop;
   }
}//end class