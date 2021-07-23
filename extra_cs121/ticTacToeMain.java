import java.util.*;
public class ticTacToeMain {

	public static void main(String[] args) {
		
		int player1Move = 0;
		int player2Move = 0;
		boolean keepGoing = true;
		
		System.out.println("Welcome to Tic-Tac-Toe!\n");
	    System.out.println("Player 1: X / Player 2: O");
		System.out.println("\tEnter 1-9 to choose a square.");
	    System.out.println("\tGood luck!");
	    defaultValueBoard();
	    
	    while (keepGoing == true){
	    	
	    	printBoard();
	    	Scanner scan = new Scanner(System.in);
	    	System.out.println("Player 1's turn (X): ");
	    	while ((isMoveValid(player1Move) == false) || player1Move < 1 || player1Move >9) {
	    		System.out.println("Please enter an integer from 1 to 9: ");
	    		try {
	    			player1Move = Integer.parseInt(scan.nextLine());
	    		} catch (Exception e) {
	    			System.out.println("The input you entered is invalid. Try again!");
	    		}
	    		if (isMoveValid(player1Move) == false) {
	    			System.out.println("Square occupied, please select another one!");
	    		}
	    	}
	    	makeMove1(player1Move);
	    	if (checkWin(player1List) == true) {
	    		System.out.println("Player 1 Wins!");
	    		keepGoing = false;
	    	}else if (isTie() == true) {
    			System.out.println("Game Tied!");
    			keepGoing = false;
    		}  	
	    	

	    	printBoard();
	    	if (keepGoing == true) {  
		    	System.out.println("Player 2's turn (O): ");
		    	while ((isMoveValid(player2Move) == false) || player2Move < 1 || player2Move >9) {
		    		System.out.println("Please enter an integer from 1 to 9: ");
		    		try {
		    			player2Move = Integer.parseInt(scan.nextLine());
		    		} catch (Exception e) {
		    			System.out.println("The input you entered is invalid. Try again!");
		    		}
		    		if (isMoveValid(player2Move) == false) {
		    			System.out.println("Square occupied, please select another one!");
		    		}
		    	}
		    	makeMove2(player2Move);
		    	if (checkWin(player2List) == true) {
		    		System.out.println("Player 2 Wins!");
		    		keepGoing = false;
		    		printBoard();
		    	}
	    	}
	    }
	}
	public static String[] square = new String[9];
 
	public static void defaultValueBoard(){
		for (int i = 0; i<9; i++) {
			square[i]=" ";
		}
	}
	
	public static boolean isMoveValid(int move) {
		if (move > 0 && move <10) {
			if (square[move-1] == " "){
				return true;
			}else{ 
				return false;
			}
		}else return true;
	}
	
	public static ArrayList<Integer> player1List = new ArrayList<Integer>();
	public static ArrayList<Integer> player2List = new ArrayList<Integer>();
	
	public static void makeMove1(int playerMove){
		square[playerMove-1] = "X";
		player1List.add((playerMove));
	}
	
	public static void makeMove2(int playerMove) {
		square[playerMove-1] = "O";
		player2List.add((playerMove));
	}
	
	public static boolean checkWin(ArrayList<Integer> playerList){
		List<Integer> vertical1 = Arrays.asList(1,2,3);
		List<Integer> vertical2 = Arrays.asList(4,5,6);
		List<Integer> vertical3 = Arrays.asList(7,8,9);
		List<Integer> horizontal1 = Arrays.asList(1,4,7);
		List<Integer> horizontal2 = Arrays.asList(2,5,8);
		List<Integer> horizontal3 = Arrays.asList(3,6,9);
		List<Integer> diagonal1 = Arrays.asList(1,5,9);
		List<Integer> diagonal2 = Arrays.asList(3,5,7);
		boolean winning = false ;
		if ((playerList.containsAll(vertical1)) 
		|| (playerList.containsAll(vertical2))
		|| (playerList.containsAll(vertical3))	 
		|| (playerList.containsAll(horizontal1))	 
		|| (playerList.containsAll(horizontal2))	 
		|| (playerList.containsAll(horizontal3))	 
		|| (playerList.containsAll(diagonal1))	 
		|| (playerList.containsAll(diagonal2))) {
			winning = true;
		}

		return winning;
	}
	 
	public static boolean isTie() {
		if (((player1List.size() + player2List.size()) == 9) && (checkWin(player1List) == false )){
			return true;
		}else return false;
	}
	
	public static void printBoard(){
		System.out.println("1["+square[0]+"]"+"2["+square[1]+"]"+"3["+square[2]+"]");
		System.out.println("4["+square[3]+"]"+"5["+square[4]+"]"+"6["+square[5]+"]");
		System.out.println("7["+square[6]+"]"+"8["+square[7]+"]"+"9["+square[8]+"]");
	}
	
	

}


