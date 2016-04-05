import java.util.ArrayList;

/**
 * 
 */

/**
 * @author spartak
 *
 */
public class Pawn extends Piece{
	Pawn(boolean isWhite){
		super(isWhite);
		name = isWhite ? "P" : "p";
	}
	
	ArrayList<Location> getLegalMoves(Tile tile) {
		ArrayList<Location> moves = new ArrayList<Location>();
		
		// Forwards
		checkLocation(moves, tile, isWhite ? 1 : -1, 0);
		// Forwards skip
		checkLocation(moves, tile, isWhite ? 2 : -2,  0);
		
		// Capture
		checkLocation(moves, tile, isWhite ? 1 : -1, -1);
		checkLocation(moves, tile, isWhite ? 1 : -1,  1);
		
		System.out.printf("Found %d legal moves", moves.size());
		return null;
	}
	private void checkLocation(ArrayList<Location> list, Tile tile, int xChange, int yChange){
		Location location = new Location(tile.location);
		location.x += xChange;
		location.y += yChange;
		System.out.printf("Testing location %s\n", location);
		Piece piece = tile.main.board[location.x][location.y].piece;
		if(piece != null && yChange == 0){
			System.out.println("The location is not a legal move");
			return;
		}
		else if(piece != null){
			if(!Main.isLocationOnBoard(location) || isWhite == piece.isWhite){
				System.out.println("The location is not a legal move");
				return;
			}
			System.out.println("The location is a legal move");
			list.add(location);
			return;
		}
		if(yChange != 0){
			System.out.println("The location is not a legal move");
			return;
		}
		System.out.println("The location is a legal move");
		list.add(location);
	}
}
