import java.util.ArrayList;

/**
 * 
 */

/**
 * @author spartak
 *
 */
public class Queen extends Piece{
	Queen(boolean isWhite){
		super(isWhite);
		name = isWhite ? "Q" : "q";
	}
	
	ArrayList<Location> getLegalMoves(Tile tile) {
		ArrayList<Location> moves = new ArrayList<Location>();
		checkOneDirection(moves, tile, 1, 1);
		checkOneDirection(moves, tile, 1, 0);
		checkOneDirection(moves, tile, 1,-1);
		checkOneDirection(moves, tile, 0,-1);
		checkOneDirection(moves, tile,-1,-1);
		checkOneDirection(moves, tile,-1, 0);
		checkOneDirection(moves, tile,-1, 1);
		checkOneDirection(moves, tile, 0, 1);
		System.out.printf("Found %d legal moves\n", moves.size());
		return moves;
	}
	
	private void checkOneDirection(ArrayList<Location> list, Tile tile, int xChange, int yChange){
		Location location = new Location(tile.location);
		location.x += xChange;
		location.y += yChange;
		System.out.printf("Testing location %s\n", location);
		if(!Main.isLocationOnBoard(location)){
			System.out.println("The location is not on the board");
			return;
		}
		Piece piece = tile.main.board[location.x][location.y].piece;
		if(piece != null){
			if(piece.isWhite == isWhite){
				System.out.println("The location is not a legal move");
				return;
			}
			System.out.println("The location is a legal move");
			list.add(location);
			return;
		}
		System.out.println("The location is a legal move");
		list.add(location);
		xChange += xChange >= 0 ? xChange > 0 ? 1 : 0 : -1;
		yChange += yChange >= 0 ? yChange > 0 ? 1 : 0 : -1;
		checkOneDirection(list, tile, xChange, yChange);
	}
}
