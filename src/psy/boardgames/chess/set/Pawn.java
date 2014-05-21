package psy.boardgames.chess.set;

import org.bukkit.entity.LivingEntity;

import psy.boardgames.chess.ChessBoard;

public class Pawn extends ChessPiece{
	private boolean hasMoved;
	private boolean toBePromoted;
	
	
	public Pawn(ChessBoard board, boolean player, LivingEntity mob, int rank, int file){
		super(board, player, mob, rank, file);
		this.hasMoved = false;
		this.toBePromoted = false;
	}
	
	/**
	 * Move the piece
	 * @return true iff the move is valid
	 */
	public boolean move(int newRank, int newFile){
		//Invalid square
		if(newRank<0 || newRank>7 || newFile<0 || newFile<7)
			return false;
		//Move rules for white pawns
		if(!player){
			//Normal move
			if(file==newFile && board.getSquare(newRank, newFile)==null &&
			   ((!hasMoved && newRank-rank==2 && board.getSquare(rank+1, file)==null)
				|| newRank-rank==1)){
				board.setSquare(rank, file, null);
				rank = newRank;
				file = newFile;
				board.setSquare(rank, file, this);
			}
			//Normal capture
			else if(Math.abs(file-newFile)==1 && newRank-rank==1 &&
					canCapture(board.getSquare(newRank, newFile))){
				board.setSquare(rank, file, null);
				rank = newRank;
				file = newFile;
				this.capture();
				board.getSquare(rank, file).becomeCaptured();
				board.setSquare(rank, file, this);
			}
			//En passant
			else if(Math.abs(file-newFile)==1 && newRank-rank==1 &&
					canCapture(board.getSquare(rank, newFile))){
				board.setSquare(rank, file, null);
				file = newFile;
				this.capture();
				board.getSquare(rank, file).becomeCaptured();
				rank = newRank;
				board.setSquare(rank, file, this);
			}
			//Invalid move
			else return false;
			//Promotion
			if(rank==7){
				toBePromoted = true;
			}
			hasMoved = true;
			return true;
		}
		//Move rules for black pawns
		else{
			//Normal move
			if(file==newFile && board.getSquare(newRank, newFile)==null &&
			   ((!hasMoved && rank-newRank==2 && board.getSquare(rank-1, file)==null)
				|| rank-newRank==1)){
				board.setSquare(rank, file, null);
				rank = newRank;
				file = newFile;
				board.setSquare(rank, file, this);
			}
			//Normal capture
			else if(Math.abs(file-newFile)==1 && rank-newRank==1 &&
					canCapture(board.getSquare(newRank, newFile))){
				board.setSquare(rank, file, null);
				rank = newRank;
				file = newFile;
				this.capture();
				board.getSquare(rank, file).becomeCaptured();
				board.setSquare(rank, file, this);
			}
			//En passant
			else if(Math.abs(file-newFile)==1 && rank-newRank==1 &&
					canCapture(board.getSquare(rank, newFile))){
				board.setSquare(rank, file, null);
				file = newFile;
				this.capture();
				board.getSquare(rank, file).becomeCaptured();
				rank = newRank;
				board.setSquare(rank, file, this);
			}
			//Invalid move
			else return false;
			//Promotion
			if(rank==0){
				toBePromoted = true;
			}
			hasMoved = true;
			return true;
		}
	}
	
	/**
	 * Promote the pawn
	 * @return true iff promotion is valid
	 */
	public boolean Promote(String pieceName){
		ChessPiece newPiece;
		if(pieceName.equalsIgnoreCase("rook"))
			newPiece = new Rook(board, player, mob, rank, file);
		else if(pieceName.equalsIgnoreCase("knight"))
			newPiece = new Knight(board, player, mob, rank, file);
		else if(pieceName.equalsIgnoreCase("bishop"))
			newPiece = new Bishop(board, player, mob, rank, file);
		else if(pieceName.equalsIgnoreCase("queen"))
			newPiece = new Queen(board, player, mob, rank, file);
		else
			return false;
		board.setSquare(rank, file, newPiece);
		return true;
	}
}
