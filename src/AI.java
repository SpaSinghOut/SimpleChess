
public abstract class AI {
	Tile[][] board;
	public AI(Tile[][] board){
		this.board = board;
	}
	public abstract Location[] getMove();
}
