import java.util.Scanner;

public class TicTacToe {
	
	public static int row, col;
	public static Scanner scan = new Scanner(System.in);
	public static char[][] board = new char[3][3];
	public static char playerTurn = 'X';
	public static int playCount = 0;
	public static boolean runGame = true;
	public static int selection = 0;

	public static void main(String[] args) {
		while (runGame) {
			//making all board spaces empty at beginning of game
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					board[i][j] = ' ';
				}
			}
			// starting game
			playerTurn = 'X';
			Play();
			playCount = 0;
			
			// choose to play again or to quit playing
			System.out.println("Enter 1 to quit or any other key to continue :");
			selection = scan.nextInt();
			if (selection == 1) {
				runGame = false;
			}
		}
		System.out.println("Thank you for playing.");

	}
	// this is the method that starts the game
	public static void Play() {

		boolean playing = true;
		while (playing) {
			PrintBoard();
			//take user inputs to put marker on a board location
			System.out.println("Player " + playerTurn + ", please enter row number 1, 2 or 3:");
			row = scan.nextInt() - 1;
			System.out.println("Player " + playerTurn + ", please enter column number 1, 2 or 3:");
			col = scan.nextInt() -1;
			
			// check that input is valid and that board location is empty
			if (row > 2 || row < 0 || col > 2 || col < 0 || board[row][col] != ' ') {
				System.out.println("Invalid input, please try again.");
				continue;
			}
			//allocate player marker on the board
			board[row][col] = playerTurn;
			playCount ++;
			
			// check if there is a winner or if there is no more space on the board
			if (GameOver(row, col)) {
				PrintBoard();
				if (playCount == 9) {
					System.out.println("The game is a draw.");
				}
				else {
				System.out.println("Player " + playerTurn + " wins!!!");
				}
				playing = false;
			}
			// if the game is still continuing, change player turn to next player
			if (playerTurn == 'X') {
				playerTurn = 'O';
			}
			else {
				playerTurn = 'X';
			}

		}
	}
	// method that prints out the board and all the current markers
	public static void PrintBoard() {
		System.out.println();
		System.out.println("-------------");
		for (int i = 0; i <3; i++) {
			System.out.println("| " + board[i][0] + " | " + board[i][1] + " | " + board[i][2] + " |");
			System.out.println("-------------");
		}
		System.out.println();
	}
	// method that checks the current state of the board to see if there is a winner or if there are no spaces left on the board
	public static boolean GameOver(int move1, int move2) {

		if (board[0][move2] == board[1][move2] && board[0][move2] == board[2][move2]) {
			return true;
		}
		else if (board[move1][0] == board[move1][1] && board[move1][0] == board[move1][2]) {
			return true;
		}
		else if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] != ' ') {
			return true;
		}
		else if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] != ' ') {
			return true;
		}
		else if (playCount == 9){
			return true;
		}
		else {
			return false;
		}

	}
	
}