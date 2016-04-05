import java.util.ArrayList;

/**
 * 
 */

/**
 * @author spartak
 *
 */
public abstract class Piece {
	String name;
	boolean hasMoved;
	public boolean isWhite;
	Piece(boolean isWhite){
		this.isWhite = isWhite;
		name = "Y";
	}
	abstract ArrayList<Location> getLegalMoves(Tile tile);
}
