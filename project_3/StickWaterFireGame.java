import java.util.Random;

/* This class ecapsulates the state and logic required to play the 
   Stick, Water, Fire game. The game is played between a user and the computer. 
   A user enters their choice, either S for stick, F for fire, W for water, and 
   the computer generates one of these choices at random- all equally likely.
   The two choices are evaluated according to the rules of the game and the winner
   is declared.
   
   Rules of the game:
   S beats W
   W beats F
   F beats S
   no winner on a tie.
   
   Each round is executed by the playRound method. In addition to generating the computer 
   choice and evaluating the two choices, this class also keeps track of the user and computer
   scores, the number of wins, and the total number of rounds that have been played. In the case
   of a tie, neither score is updated, but the number of rounds is incremented.
   
   NOTE: Do not modify any of the code that is provided in the starter project. Additional instance variables and methods 
   are not required to make the program work correctly, but you may add them if you wish as long as
   you fulfill the project requirements.
   
*/
public class StickWaterFireGame {

   // TODO 1: Declare private instance variables here:
   Random rand = new Random();
   private static int rounds;
   private static int playerScores;
   private static int computerScores;
   private static boolean playerWins;
   private static boolean isTie;
   private static String computerChoice;
    
  /*  This constructor assigns the member Random variable, rand, to 
   *  a new, unseeded Random object.
   *  It also initializes the instance variables to their default values:
   *  rounds, player and computer scores will be 0, the playerWins and isTie
   *  variables should be set to false.
   */ 
   public StickWaterFireGame() {
      
   // TODO 2: Implement this method.
      rand = new Random();
      rounds = 0;
      playerScores = 0;
      computerScores = 0;
      playerWins = false;
      isTie = false;
   }
       
  /*  This constructor assigns the member Random variable, rand, to 
   *  a new Random object using the seed passed in.
   *  It also initializes the instance variables to their default values:
   *  rounds, player and computer scores will be 0, the playerWins and isTie
   *  variables should be set to false.
   */    
   public StickWaterFireGame(int seed) {
   // TODO 3: Implement this method.
      rand = new Random();
      long s = seed;
      rand.setSeed(s);
      rounds = 0;
      playerScores = 0;
      computerScores = 0;
      playerWins = false;
      isTie = false;
   }   

  /*  This method returns true if the inputStr passed in is
   *  either "S", "W", or "F", false otherwise.
   *  Note that the input can be upper or lower case.
   */ 
   public boolean isValidInput(String inputStr) {
   // TODO 4: Implement this method.
      if (inputStr == "S" || inputStr == "W" || inputStr == "F" || inputStr == "s" || inputStr == "f" || inputStr == "w"){
         return true;
      }else 
         return false; 
   }
    
  /*  This method carries out a single round of play of the SWF game. 
   *  It calls the isValidInput method and the getRandomChoice method. 
   *  It implements the rules of the game and updates the instance variables
   *  according to those rules.
   */
   public void playRound(String playerChoice) {
   // TODO 12: Implement this method.
      
      computerChoice = getRandomChoice();
      if (isValidInput(playerChoice) == true){
         
         playerChoice = playerChoice.toUpperCase();
         if ((playerChoice == "S" && computerChoice == "W") || (playerChoice == "W" && computerChoice == "F") 
         || (playerChoice == "F" && computerChoice == "S")){
            playerWins = true;
            playerScores++;
         }
         else if(playerChoice == computerChoice){
            isTie=true;}
         else {
            computerScores++;}
      }else {computerScores++;
      }
            
         
         
      
      rounds ++;
   }
    
   // Returns the choice of the computer for the most recent round of play
   public String getComputerChoice(){
   // TODO 5: Implement this method.
      return computerChoice;
   }

   // Returns true if the player has won the last round, false otherwise.    
   public boolean playerWins(){
   // TODO 6: Implement this method.
      if (playerWins == true){
         return true;
      }else{  
         return false;
      }
   }
   
   // Returns the player's cumulative score.    
   public int getPlayerScore(){
   // TODO 7: Implement this method.
      return playerScores;
   }
   
   // Returns the computer's cumulative score.   
   public int getComputerScore(){
   // TODO 8: Implement this method.
      return computerScores;
   }
   
   // Returns the total nuber of rounds played.   
   public int getNumRounds(){
   // TODO 9: Implement this method.
      return rounds;
   }

   // Returns true if the player and computer have the same score on the last round, false otherwise.    
   public boolean isTie(){
   // TODO 10: Implement this method.
      if (playerScores == computerScores){
         return true;
      }else{
         return false;}
   }

  /*  This "helper" method uses the instance variable of Random to generate an integer
   *  which it then maps to a String: "S", "W", "F", which is returned.
   *  This method is called by the playRound method.
   */
   private String getRandomChoice() {
   // TODO 11: Implement this method.
      String[] choice = {"S","W","F"};
      int choiceNum;
      choiceNum = rand.nextInt(2);
      return choice[choiceNum];
   }
}
