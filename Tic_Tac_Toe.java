import java.util.*;
public class Tic_Tac_Toe{
    public static Scanner scn = new Scanner(System.in);
    
	private static boolean isGameFinished(char[][] board) {
        
		if (whoWons(board, 'X')) {	
			printBoard(board);
			System.out.println("Player wins!");
			return true;
		}
		
		if (whoWons(board, 'O')) {	
			printBoard(board);
			System.out.println("Computer wins!");
			return true;
		}
		int n = board.length;
        int m = board[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		printBoard(board);
		System.out.println("Game tie!");
		return true;
	}
    
	private static boolean whoWons(char[][] board, char symbol) {
		if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
			(board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
			(board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||
			
			(board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
			(board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
			(board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||
			
			(board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
			(board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
			return true;
		}
		return false;
	}
    
	private static void computerTurn(char[][] board) {
		Random rd = new Random();
		int computerMove;
		while (true) {
			computerMove = rd.nextInt(9) + 1;
			if (isValidMove(board, Integer.toString(computerMove))) {
				break;
			}
		}
		System.out.println("Computer chose " + computerMove);
		placeMove(board, Integer.toString(computerMove), 'O');
	}
    
	private static boolean isValidMove (char[][] board, String position) {
		switch(position) {
			case "1":
				return (board[0][0] == ' ');
			case "2":
				return (board[0][1] == ' ');
			case "3":
				return (board[0][2] == ' ');
			case "4":
				return (board[1][0] == ' ');
			case "5":
				return (board[1][1] == ' ');
			case "6":
				return (board[1][2] == ' ');
			case "7":
				return (board[2][0] == ' ');
			case "8":
				return (board[2][1] == ' ');
			case "9":
				return (board[2][2] == ' ');
			default:
				return false;
		}
	}

	private static void playerTurn(char[][] board, Scanner scn) {
		String userInput;
		while (true) {
			System.out.println("Would you like to play? Tic-Tac-Toe");
			userInput = scn.nextLine();
			if (isValidMove(board, userInput)){
				break;
			} else {
				System.out.println(userInput + " Try a valid move.");
			}
		}
		placeMove(board, userInput, 'X');
	}
    
	private static void placeMove(char[][] board, String position, char symbol) {
		switch(position) {
			case "1":
				board[0][0] = symbol;
				break;
			case "2":
				board[0][1] = symbol;
				break;
			case "3":
				board[0][2] = symbol;
				break;
			case "4":
				board[1][0] = symbol;
				break;
			case "5":
				board[1][1] = symbol;
				break;
			case "6":
				board[1][2] = symbol;
				break;
			case "7":
				board[2][0] = symbol;
				break;
			case "8":
				board[2][1] = symbol;
				break;
			case "9":
				board[2][2] = symbol;
				break;
			default:
				System.out.println(":(");
		}
	}
    
	private static void printBoard(char[][] board) {
		System.out.println(board[0][0] + "|" +  board[0][1] + "|" +  board[0][2] );
		System.out.println("-+-+-");
		System.out.println(board[1][0] + "|" +  board[1][1] + "|" +  board[1][2] );
		System.out.println("-+-+-");
		System.out.println(board[2][0] + "|" +  board[2][1] + "|" +  board[2][2] );
	}
    
 public static void main(String[] args) {
		char[][] board = {{' ', ' ', ' '},
				 	      {' ', ' ', ' '}, 
				 	      {' ', ' ', ' '}};
		
		printBoard(board);
		
		while (true) {
			playerTurn(board, scn);
			if (isGameFinished(board)){
				break;
			}
			printBoard(board);
			
			computerTurn(board);
			if (isGameFinished(board)){
				break;
			}
			printBoard(board);
		}
	}
}