import java.util.ArrayList;

public class Tile {
	Piece piece;
	Main main;
	Location location;
	Tile(Location location){
		this.location = new Location(location.x, location.y);
	}
	void setPiece(Main main,Piece piece){
		this.main = main;
		this.piece = piece;
	}
	public Piece getPiece(){
		return piece;
	}
	public ArrayList<Location> getLegalMoves() throws Exception{
		if(piece == null){
			System.out.println("Attempted check of legal moves on an empty tile");
			throw new Exception();
		}
		return piece.getLegalMoves(this);
	}
}
