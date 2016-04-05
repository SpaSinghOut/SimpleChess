import java.util.ArrayList;

/**
 * 
 */

/**
 * @author spartak
 *
 */
public class Rook extends Piece{
	Rook(boolean isWhite){
		super(isWhite);
		name = isWhite ? "R" : "r";
	}

	ArrayList<Location> getLegalMoves(Tile tile) {
		ArrayList<Location> moves = new ArrayList<Location>();
		checkOneDirection(moves, tile, true,   1);
		checkOneDirection(moves, tile, true,  -1);
		checkOneDirection(moves, tile, false,  1);
		checkOneDirection(moves, tile, false, -1);
		System.out.printf("Found %d legal moves\n", moves.size());
		return moves;
	}
	
	private void checkOneDirection(ArrayList<Location> list, Tile tile, boolean x, int increase){
		Location location = new Location(tile.location);
		location.x +=  x ? increase : 0;
		location.y += !x ? increase : 0;
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
		checkOneDirection(list, tile, x, increase > 0 ? ++increase : --increase);
	}
}
