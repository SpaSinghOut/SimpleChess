import java.util.ArrayList;

/**
 * 
 */

/**
 * @author spartak
 *
 */
public class Knight extends Piece{
	Knight(boolean isWhite){
		super(isWhite);
		name = isWhite ? "N" : "n";
	}
	ArrayList<Location> getLegalMoves(Tile tile) {
		ArrayList<Location> moves = new ArrayList<Location>();
		checkALocation(moves, tile,  1,  2);
		checkALocation(moves, tile,  1, -2);
		checkALocation(moves, tile, -1,  2);
		checkALocation(moves, tile, -1, -2);
		checkALocation(moves, tile,  2,  1);
		checkALocation(moves, tile,  2, -1);
		checkALocation(moves, tile, -2,  1);
		checkALocation(moves, tile, -2, -1);
		System.out.printf("Found %d legal moves\n", moves.size());
		return moves;
	}
	
	private void checkALocation(ArrayList<Location> list, Tile tile, int x, int y){
		Location location = new Location(tile.location);
		location.x += x;
		location.y += y;
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
	}
}
