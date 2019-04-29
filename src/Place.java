
public class Place {
	/** Horizontal coordinate (column number) */
	private int x;

	/** Vertical coordinate (row number) */
	private int y;

	/** Player number token */
	private int player;

	/**
	 * Creates an empty place in the given coordinates
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 */
	public Place(int x, int y) {
		this.x = x;
		this.y = y;
		this.player = 0;
	}

	/**
	 * Returns x coordinate
	 * 
	 * @return x coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns y coordinate
	 * 
	 * @return y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Returns player number
	 * 
	 * @return player number
	 */
	public int getPlayer() {
		return player;
	}

	/**
	 * Adds player token
	 * 
	 * @param player
	 *            player number
	 */
	public void setPlayer(int player) {
		this.player = player;
	}

}
