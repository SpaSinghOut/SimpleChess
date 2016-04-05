import java.util.ArrayList;

/**
 * 
 */

/**
 * @author spartak
 *
 */
public class Bishop extends Piece{
	Bishop(boolean isWhite){
		super(isWhite);
		name = isWhite ? "B" : "b";
	}
	@Override
	ArrayList<Location> getLegalMoves(Tile tile){
		ArrayList<Location> moves = new ArrayList<Location>();
		checkOneDirection(moves, tile, -1, -1);
		checkOneDirection(moves, tile, 1, -1);
		checkOneDirection(moves, tile, -1, 1);
		checkOneDirection(moves, tile, 1, 1);
		System.out.printf("Found %d legal moves\n", moves.size());
		return moves;
	}
	private void checkOneDirection(ArrayList<Location> moves, Tile tile, int x, int y){
		Location startPoint = new Location(tile.location.x, tile.location.y);
		for(int i = 1; i <= 7; i++){
			startPoint.x += x;
			startPoint.y += y;
			System.out.printf("Testing location: (%d,%d)\n", startPoint.x, startPoint.y);
			if(!Main.isLocationOnBoard(startPoint)){
				System.out.println("The location is out of bounds");
				return;
			}
			if(tile.main.board[startPoint.x][startPoint.y].piece == null){
				System.out.println("The location is a valid move");
				moves.add(startPoint);
				continue;
			}
			if(tile.main.board[startPoint.x][startPoint.y].piece.isWhite == isWhite){
				System.out.println("The location contains a piece of the same color");
				return;
			}
			System.out.println("The location contains a piece of the other color");
			moves.add(startPoint);
			return;
		}
	}
}
