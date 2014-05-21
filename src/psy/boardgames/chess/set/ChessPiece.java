package psy.boardgames.chess.set;

import org.bukkit.entity.LivingEntity;

import psy.boardgames.chess.ChessBoard;

public abstract class ChessPiece{
	protected final ChessBoard board;
	//false=player1, true=player2
	protected final boolean player;
	protected int rank, file;
	//The mob representing the piece
	protected LivingEntity mob;
	
	public ChessPiece(ChessBoard board, boolean player, LivingEntity mob, int rank, int file){
		this.board = board;
		this.player = player;
		this.mob = mob;
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
