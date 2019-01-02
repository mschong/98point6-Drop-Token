import java.util.Scanner;

public class Game {
	/**Game board */
	private static Board board = new Board();

	/**
	 * Takes the user input and calls the corresponding functions from Board
	 */
	public static void play() {
		Scanner scr = new Scanner(System.in);
		String state = "";
		while (!(state.equals("WIN") || state.equals("DRAW"))) {
			System.out.print("\n> ");
			String line = scr.nextLine();
			String[] cmd = line.split(" ");
			if (cmd[0].equals("BOARD"))
				board.printBoard();
			else if (cmd[0].equals("GET"))
				board.printMoves();
			else if (cmd[0].equals("PUT") && cmd.length > 1) {
				int col = Integer.parseInt(cmd[1]);
				state = board.addToken(col);
				System.out.println(state);

			} else if (cmd[0].equals("EXIT"))
				System.exit(0);
			else
				System.out.println("INVALID COMMAND");
		}
		board.printBoard();
		scr.close();
	}

	public static void main(String[] args) {
		System.out.println("98point6 DROP TOKEN");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("| • PUT <column>   -> (OK|ERROR|WIN|DRAW)                               |");
		System.out.println("| • GET            -> List of columns that have been succesfully put on |");
		System.out.println("| • BOARD          -> a 4x4 matrix that shows the board state           |");
		System.out.println("| • EXIT           -> Quit game                                         |");
		System.out.println("-----------------------------------------------------------------------");
		board.initializeGrid();
		play();
	}
}
