import java.util.Scanner;

public class Main {
	Tile[][] board = new Tile[8][8];
	Scanner scanner = new Scanner(System.in);
	private Main(){
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				board[i][j] = new Tile(new Location(i,j));
		board[0][0].setPiece(this, new Rook(true));
		board[0][1].setPiece(this, new Knight(true));
		board[0][2].setPiece(this, new Bishop(true));
		board[0][3].setPiece(this, new Queen(true));
		board[0][4].setPiece(this, new King(true));
		board[0][5].setPiece(this, new Bishop(true));
		board[0][6].setPiece(this, new Knight(true));
		board[0][7].setPiece(this, new Rook(true));

		for(Tile t: board[1])
			t.setPiece(this, new Pawn(true));
		for(Tile t: board[6])
			t.setPiece(this, new Pawn(false));

		board[7][0].setPiece(this, new Rook(false));
		board[7][1].setPiece(this, new Knight(false));
		board[7][2].setPiece(this, new Bishop(false));
		board[7][3].setPiece(this, new Queen(false));
		board[7][4].setPiece(this, new King(false));
		board[7][5].setPiece(this, new Bishop(false));
		board[7][6].setPiece(this, new Knight(false));
		board[7][7].setPiece(this, new Rook(false));
		
		try {
			MainAI player1 = new MainAI(board);
			Location[] move = player1.getMove();
			move(new Location(move[0].x, move[0].y), new Location(move[1].x, move[1].y));
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while(true){
			drawHorizontalBorder();
			drawBoard();
			drawHorizontalBorder();
			/*
			try {
				board[0][2].getLegalMoves();
				board[0][4].getLegalMoves();
				board[0][0].getLegalMoves();
				board[0][3].getLegalMoves();
				board[0][1].getLegalMoves();
				board[1][1].getLegalMoves();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			pause();
		}
	}
	private void drawHorizontalBorder(){
		System.out.print("*");
		for(int i = 0; i < 8; i++)
			System.out.print("- ");
		System.out.println("*");
	}
	private void drawBoard(){
		for(Tile[] row: board){
			System.out.print("|");
			for(Tile t: row)
				System.out.print((t.getPiece() == null ? "-" : t.getPiece().name) + " ");
			System.out.println("|");
		}
	}
	private void pause(){
		scanner.nextLine();
	}
	public static void main(String[] args){
		new Main();
	}
	public static boolean isLocationOnBoard(Location location){
		return location.x < 8 && location.y < 8 && location.x > -1 && location.y > -1;
	}
	public void move(Location from, Location to) throws Exception{
		if(!Main.isLocationOnBoard(from) || !Main.isLocationOnBoard(to))
			throw new Exception();
		board[to.x][to.y].piece = board[from.x][from.y].piece;
		board[from.x][from.y].piece = null;
		board[to.x][to.y].piece.hasMoved = true;
	}
}
