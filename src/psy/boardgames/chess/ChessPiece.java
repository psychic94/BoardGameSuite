package psy.boardgames.chess;

public abstract class ChessPiece{
	protected final ChessBoard board;
	//false=player1, true=player2
	protected final boolean player;
	protected int rank, file;
	
	public ChessPiece(ChessBoard board, boolean player, int rank, int file){
		this.board = board;
		this.player = player;
		this.rank = rank;
		this.file = file;
	}

	/**
	 * Move the piece
	 * @return true iff the move is valid
	 */
	public abstract boolean move(int newRank, int newFile);
	
	public void capture(){
		
	}
	
	public void becomeCaptured(){
		
	}
	
	public boolean isWhitePiece(){
		return player;
	}
	
	public boolean canCapture(ChessPiece other){
		return (other!=null && other.isWhitePiece()!=player);
	}
}
