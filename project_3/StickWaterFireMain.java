import java.util.*;

public class StickWaterFireMain{

   public static void main(String[] args){
   
      //StickWaterFireGame game = new StickWaterFireGame();
      StickWaterFireGame game = new StickWaterFireGame(1234);
      Scanner scan = new Scanner(System.in);
      boolean keepGoing = true;
      String playerChoice = "";
   
      // Greet the user and state the rules:
      System.out.println("Welcome to Stick-Water-Fire!\n");
      System.out.println("Rules:");
      System.out.println("\tYou will play against the computer for the specified number of rounds.");
      System.out.println("\tYou will make a choice: 'S', 'W', or 'F' to represent 'Stick', 'Water', or 'Fire'.");
      System.out.println("\tThe computer will also make a choice, and the winner is chosen as follows:");
      System.out.println("\t\t Stick beats Water (it floats on top)");
      System.out.println("\t\t Water beats Fire (extinguishes the fire)");
      System.out.println("\t\t Fire beats Stick (burns the stick)");
      System.out.println("\tIn the event of a tie, there is no winner.");
      System.out.println("\tEach round, the winner will have their score incremented.");
      System.out.println("\tA report of scores and number of rounds will be displayed at the end of each round.");
      System.out.println("\tEnter X to quit.");
      System.out.println("\tGood luck!");
      
      // begin the game loop.
      while(keepGoing){
         System.out.println("Enter 'S' for Stick, 'W' for Water, 'F' for Fire, or X to quit:");
         playerChoice = scan.nextLine();
         if(playerChoice.equalsIgnoreCase("X"))
            keepGoing = false;
         else{  // Handle round of play
            // validate input
            if(!game.isValidInput(playerChoice))
              System.out.println("\tInvalid input entered: "+playerChoice+"\n");  
            else {
               game.playRound(playerChoice);
               String computerChoice = game.getComputerChoice();
               System.out.println("You chose " + playerChoice + " and the computer chose " + computerChoice);
               // report winner
               if(game.isTie()){
                  System.out.println("You tied!");
               } else if (game.playerWins()) {
                   System.out.println("You won! Nice job!\n");
               } else { // Computer won
                   System.out.println("You lost. Better luck next time!\n");
               }
              // Print report
              System.out.println("Game summary:");
              System.out.println(getScoreReportStr(game));
               System.out.println(" ");
            }
         }//end of round
       }// end loop
    System.out.println("Thanks for playing!");
    } // end main
    
    public static String getScoreReportStr(StickWaterFireGame game){
      return "Total plays: " + game.getNumRounds() + "\nYour total score: "+ game.getPlayerScore() + 
      ", computer total score: " + game.getComputerScore();
   }
}// end class