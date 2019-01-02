import java.util.ArrayList;

public class Board {
	/**List with all Places in the board */
	private ArrayList<Place> grid;
	
	/**Board size */
	private final int SIZE = 4;
	
	/**Player number */
	private int player;
	
	/**List of successful moves */
	private ArrayList<Integer> moves;

	/**
	 * 
	 * @return board size
	 */
	public int getSize() {
		return SIZE;
	}

	/**
	 * Create empty board with zeroes
	 */
	public void initializeGrid() {
		player = 1;
		grid = new ArrayList<>();
		moves = new ArrayList<>();
		for (int i = 1; i <= SIZE; i++) {
			for (int j = 1; j <= SIZE; j++) {
				grid.add(new Place(j, i));
			}
		}
	}

	/**
	 * Display board
	 */
	public void printBoard() {
		for (int i = SIZE; i >= 1; i--) {
			System.out.print("| ");
			for (int j = 1; j <= SIZE; j++) {
				System.out.print(getPlace(j, i).getPlayer() + " ");
			}
			System.out.println();
		}
		System.out.print("+");
		for (int i = 0; i < SIZE; i++) {
			System.out.print("--");
		}
		System.out.print("\n  ");
		for (int i = 1; i <= SIZE; i++) {
			System.out.print(i + " ");
		}
	}

	/**
	 * Takes x and y coordinates and returns the place corresponding to those
	 * coordinates
	 * 
	 * @param x
	 *            horizontal coordinate
	 * @param y
	 *            vertical coordinate
	 * @return the Place at xy
	 */
	public Place getPlace(int x, int y) {
		for (Place p : grid) {
			if (p.getX() == x && p.getY() == y)
				return p;
		}
		return null;
	}

	/**
	 * Adds token in the board in the specified column
	 * 
	 * @param column
	 *            column number where the token will be added
	 * @return move state
	 */
	public String addToken(int column) {
		if (column > SIZE || column < 1)
			return "ERROR";
		for (int i = 1; i <= SIZE; i++) {
			if (getPlace(column, i).getPlayer() == 0) {
				getPlace(column, i).setPlayer(player);
				// Checks if it's a win after the token was added
				if (isWin(column, i))
					return "WIN";
				// If it was not a win it checks if it ended in a draw
				else if (isDraw())
					return "DRAW";
				// Changes the turn to the next player
				else {
					addMove(column);
					if (player == 1)
						player = 2;
					else
						player = 1;
					return "OK";
				}
			}
		}
		return "ERROR";
	}

	/**
	 * Check if the token was added in a corner
	 * 
	 * @param x
	 *            horizontal coordinate
	 * @param y
	 *            vertical coordinate
	 * @return true if it's a corner, false otherwise.
	 */
	public boolean isCorner(int x, int y) {
		if ((x == 1 && y == 1) || (x == 1 && y == SIZE) || (x == SIZE && y == 1) || (x == SIZE && y == SIZE)) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if the player won with the last move
	 * 
	 * @param x
	 *            horizontal coordinate
	 * @param y
	 *            vertical coordinate
	 * @return true if the player won, false otherwise
	 */
	public boolean isWin(int x, int y) {
		if (isCorner(x, y))
			if (horizontalWin(y) || verticalWin(x) || diagonalWin(x, y))
				return true;
			else if (horizontalWin(y) || verticalWin(x))
				return true;
		return false;
	}

	/**
	 * Checks the given row for the same player tokens
	 * 
	 * @param y
	 *            vertical coordinate (row number)
	 * @return true if all tokens in the specified row are from the same player,
	 *         false otherwise
	 */
	public boolean horizontalWin(int y) {
		for (int i = 1; i <= SIZE; i++) {
			if (getPlace(i, y).getPlayer() != player)
				return false;
		}
		return true;
	}

	/**
	 * Checks the given column for the same player tokens
	 * 
	 * @param x
	 *            horizontal coordinate (column number)
	 * @return true if all tokens in the specified column are from the same player,
	 *         false otherwise
	 */
	public boolean verticalWin(int x) {
		for (int i = 1; i <= SIZE; i++) {
			if (getPlace(x, i).getPlayer() != player)
				return false;
		}
		return true;
	}

	/**
	 * Checks the diagonal in the board for the same player token
	 * 
	 * @param x
	 *            horizontal coordinate
	 * @param y
	 *            vertical coordinate
	 * @return true if all the tokens in a diagonal are from the same players, false
	 *         otherwise
	 */
	public boolean diagonalWin(int x, int y) {
		// Checks top right to bottom left diagonal
		if ((x == 1 && y == 1) || (x == 4 && y == 4)) {
			for (int i = 1; i <= SIZE; i++) {
				if (getPlace(i, i).getPlayer() != player)
					return false;
			}
			// Checks top left to bottom right diagonal
		} else {
			for (int i = 1, j = SIZE; i <= SIZE && j >= 1; i++, j--) {

				if (getPlace(i, j).getPlayer() != player)
					return false;

			}
		}
		return true;
	}

	/**
	 * Checks if the game is ends in a draw
	 * 
	 * @return true if the last row is full (doesn't contain any zeroes), false
	 *         otherwise
	 */
	public boolean isDraw() {
		for (int i = 1; i <= SIZE; i++) {
			if (getPlace(i, SIZE).getPlayer() == 0)
				return false;
		}
		return true;
	}

	/**
	 * Adds the column number to the list of successful moves
	 * 
	 * @param col
	 *            column number where token was added successfully
	 */
	public void addMove(int col) {
		moves.add(col);
	}

	/**
	 * Displays the list of successful moves
	 */
	public void printMoves() {
		for (int i : moves) {
			System.out.println(i);
		}
	}
}
