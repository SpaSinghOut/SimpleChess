import java.util.ArrayList;

/**
 * 
 */

/**
 * @author spartak
 *
 */
public class King extends Piece{
	King(boolean isWhite){
		super(isWhite);
		name = isWhite ? "K" : "k";
	}
	ArrayList<Location> getLegalMoves(Tile tile) {
		ArrayList<Location> moves = new ArrayList<Location>();
		if(checkLegality(tile, -1, -1))moves.add(new Location(tile.location.x - 1, tile.location.y - 1));
		if(checkLegality(tile, 0, -1))moves.add(new Location(tile.location.x, tile.location.y - 1));
		if(checkLegality(tile, 1, -1))moves.add(new Location(tile.location.x + 1, tile.location.y - 1));
		if(checkLegality(tile, 1, 0))moves.add(new Location(tile.location.x + 1, tile.location.y));
		if(checkLegality(tile, 1, 1))moves.add(new Location(tile.location.x + 1, tile.location.y + 1));
		if(checkLegality(tile, 0, 1))moves.add(new Location(tile.location.x, tile.location.y + 1));
		if(checkLegality(tile, -1, 1))moves.add(new Location(tile.location.x - 1, tile.location.y + 1));
		if(checkLegality(tile, -1, 0))moves.add(new Location(tile.location.x - 1, tile.location.y));
		System.out.printf("Found %d legal moves\n", moves.size());
		return moves;
	}
	private boolean checkLegality(Tile tile, int x, int y){
		Location location = new Location(tile.location.x + x, tile.location.y + y);
		System.out.printf("Checking location %s\n", location);
		boolean isOnBoard = Main.isLocationOnBoard(location);
		if(!isOnBoard){
			System.out.println("The location is not on the board");
			return false;
		}
		Piece piece = tile.main.board[location.x][location.y].piece;
		boolean isLegal = piece == null || piece.isWhite != isWhite;
		System.out.printf("The location is %sa legal move\n", isLegal ? "" : "not ");
		return isLegal;
	}
}
